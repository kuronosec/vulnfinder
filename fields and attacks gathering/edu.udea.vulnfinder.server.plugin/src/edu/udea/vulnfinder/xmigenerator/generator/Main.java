/*
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.udea.vulnfinder.xmigenerator.generator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ApiResponseList;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseSet;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import edu.udea.vulnfinder.server.plugin.handlers.SpiderStartHandler;
import edu.udea.vulnfinder.server.plugin.view.dialog.AuthParamsDialog;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnServerException;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnSpideringException;
import edu.udea.vulnfinder.xmigenerator.generator.exporter.Mem2XMIFormat;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.Attack;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.AuthSetting;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.TargetOfEvaluation;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.WebComponent;
import fi.iki.elonen.NanoHTTPD;

/**
 *
 * @author Christian Delany
 */
public class Main {
	private static final String EXCLUDED_REGEX_BEGIN = ".*\\.(?:";
	private static final String EXCLUDED_REGEX_END  = ")(?:\\?.*)?";
	private static TargetOfEvaluation dominio = null;
	private static int zapPort = 8080;
	private static String zapHost = "localhost";
	private static ClientApi clientApi;
	private static Queue<Duo> cola = new ConcurrentLinkedDeque<>();
	private static int serverPort = 3000;
	private static int maxSpiderMilliseconds = 3000;
	private static int maxSpiderDepth = 0;
	private static Map<String, Attack> attackMap;
	private static IProgressMonitor monitor = null;
	private static VulnServer vulnServer = null;
	private static AuthSetting authSetting = new AuthSetting();
	private static String excludedExtensionsInSpidering = "js|jpg|jpe|png|css|gif|pdf|doc";
	private static String excludedExtensionsInModel = "js|jpg|jpe|png|css|gif|pdf|doc";
	
	private static int state = 0;

	public static void startServer() throws IOException, VulnServerException {
		initialize();
		if( !isServerUp() ){
			readyUpZapAPI();
			vulnServer = new VulnServer(serverPort);
		}else{
			throw new VulnServerException("There is another instance of the server running, please wait or restart the application.");
		}
		state = 1;
		
	}

	public static void stopServer() throws VulnServerException {
		if (vulnServer != null && (vulnServer.isAlive())) {
			vulnServer.closeAllConnections();
			vulnServer.stop();
			//vulnServer = null;
			state = 2;
		}else{
			throw new VulnServerException("The server can't be stopped because it's not running.");
		}
	}
	
	public static void restartServer() throws VulnServerException, IOException{
		stopServer();
		startServer();
	}
	
	public static boolean isServerUp(){
		return vulnServer != null && vulnServer.isAlive();
	}

	public static void startSpidering() throws VulnSpideringException, VulnServerException {
		/*try {
			stopServer();
		} catch (VulnServerException e) {
			//It's fine if it's not running.
		}*/
//		readyUpZapAPI();
		if(dominio != null && dominio.getName() != null){
			//insertarDominio(TargetOfEvaluation.extractDomain(toe));
			start();
		}else{
			throw new VulnSpideringException(1);
		}
		
	}
	
	public static void readyUpZapAPI(){
		clientApi = new ClientApi(zapHost, zapPort);
	}
	
	public static ArrayList<String> getZAPSites() throws VulnServerException{
		ArrayList<String> res = new ArrayList<>();
		ApiResponseList arl = null;
		String val;
		try{
			arl = (ApiResponseList) clientApi.core.sites();
			for (ApiResponse ar : arl.getItems()) {
				val = ((ApiResponseElement) ar).getValue();
				res.add(val);
			}
		}catch(ClientApiException e){
			throw new VulnServerException(e);
		}
		
		return res;
	}
	
	public static String generateXMI(){
		Mem2XMIFormat mem2xmi = new Mem2XMIFormat(dominio, attackMap, authSetting, false);
		return mem2xmi.generateXMIFormat();
	}
	
	public static String generateXMI(String testId, String testName, boolean allAttacks){
		Mem2XMIFormat mem2xmi = new Mem2XMIFormat(dominio, attackMap, testId, testName, authSetting, allAttacks);
		return mem2xmi.generateXMIFormat();
	}

	public static void initialize() {
		attackMap = new ConcurrentHashMap<>();
		attackMap.put("SQL Injection", new Attack("SQLInjection"));
		attackMap.put("Authentication", new Attack("Authentication"));
		attackMap.put("Authorization", new Attack("Authorization"));
		attackMap.put("XSS", new Attack("XSS"));
		attackMap.put("Privilege Scalation", new Attack("PrivilegeScalation"));
		attackMap.put("*", new Attack("*"));
		int i = 0;
		for (Map.Entry<String, Attack> e : attackMap.entrySet()) {
			e.getValue().setIndex(i++);
		}
		
	}
	
	
	
	public static void setupAuthWithZAP() throws ClientApiException{
		StringBuilder sb = new StringBuilder();
		String userId;
		
		if(!authSetting.isComplete()){
			return;
		}
		sb.append("loginUrl=").append(authSetting.getLoginTargetUrl());
		sb.append("&loginRequestData=");
		sb.append(authSetting.getUsernameParam()).append("%3D%7B%25").append(authSetting.getUsername()).append("%25%7D%26");
		sb.append(authSetting.getPasswordParam()).append("%3D%7B%25").append(authSetting.getPassword()).append("%25%7D");
		clientApi.authentication.setAuthenticationMethod("", "1", "formBasedAuthentication", sb.toString());
		if(!"".contentEquals(authSetting.getLoginMessagePattern())){
			clientApi.authentication.setLoggedInIndicator("", "1", authSetting.getLoginMessagePattern());
		}
		if(!"".contentEquals(authSetting.getLogoutMessagePattern())){
			clientApi.authentication.setLoggedOutIndicator("", "1", authSetting.getLogoutMessagePattern());
		}
		
		sb = new StringBuilder();
		sb.append("type=UsernamePasswordAuthenticationCredentials&username=");
		sb.append(authSetting.getUsername());
		sb.append("&password=").append(authSetting.getPassword());
		
		
		ApiResponseElement are = (ApiResponseElement)clientApi.users.newUser("", "1", authSetting.getUsername());
		userId = are.getValue();
		clientApi.users.setAuthenticationCredentials("", "1", userId, sb.toString() );
		clientApi.users.setUserEnabled("", "1", userId, "true");
		clientApi.forcedUser.setForcedUser("", "1", userId);
		clientApi.forcedUser.setForcedUserModeEnabled("", true);
	}
	
	
	private static boolean checkValidExtension(String toe){
		return toe != null && !toe.matches(EXCLUDED_REGEX_BEGIN+excludedExtensionsInSpidering+EXCLUDED_REGEX_END);
	}
	
	

	private static void start() throws VulnSpideringException, VulnServerException {
		
		ApiResponseList arl = null;
		state = 3;
		cola.offer(new Duo(dominio.getName(), 0));
		for(WebComponent wc : dominio.getWebComponents()){
			wc.setSpidered(false);
		}
		try{
			setupAuthWithZAP();
			arl = (ApiResponseList) clientApi.core.urls();
			for (ApiResponse ar : arl.getItems()) {
				String res = ((ApiResponseElement) ar).getValue();
				boolean cb = checkValidExtension(res);
				System.out.println(res+" "+cb);
				if(cb){
					cola.offer(new Duo(res, 0));
				}
			}
		}catch(ClientApiException e){
			throw new VulnSpideringException(e, 3);
		}
		
		while (!cola.isEmpty()) {
			runSpidering();
			if (monitor != null) {
				if (monitor.isCanceled()) {
					//Main.setMonitor(null);
					//state = 2;
					//throw new VulnSpideringException(2);
					cola.clear();
				}

			}
		}
		try {
			if(monitor != null){
				if(monitor.isCanceled()){
					monitor.subTask("Cancelling spidering, retrieving partial results.");
				}else{
					monitor.subTask("Retrieving results...");
				}
			}
			addInputs();
			state = 4;
			clientApi.spider.stopAllScans(null);
		} catch (ClientApiException cae) {
			state = 2;
			throw new VulnSpideringException(cae, 3);
			// System.out.println("error");
		}
		
		
	}

	private static void addInputs() throws ClientApiException, VulnServerException {
		ApiResponseSet ars;
		for (ApiResponse respuestaParams : ((ApiResponseList) clientApi.params.params(null)).getItems()) {
			for (ApiResponse valoresParams : ((ApiResponseList) respuestaParams).getItems()) {
				if (valoresParams instanceof ApiResponseSet) {
					ars = (ApiResponseSet) valoresParams;
					String nombreParam = ars.getAttribute("name");
					String tipoParam = ars.getAttribute("type");
					// System.out.println("sitio: "+ars.getAttribute("site"));
					addParam(tipoParam, nombreParam);
				}
			}
		}
	}

	private static void addParam(String tipoParam, String nombreParam) throws ClientApiException, VulnServerException {
		ApiResponseSet ars;
		ApiResponseList respuesta = null;
		String url = null;
		// String tipo = null;
		int dom, pag;
		try {
			switch (tipoParam) {
			case "form":
				// System.out.println("post");
				respuesta = (ApiResponseList) clientApi.search.urlsByRequestRegex(nombreParam + "=.*", "", "", "");
				/* tipo = "POST"; */
				break;
			case "url":
				// System.out.println("get");
				respuesta = (ApiResponseList) clientApi.search.urlsByUrlRegex("[?&]" + nombreParam + "=.*", "", "", "");
				/* tipo = "GET"; */
				break;
			case "cookie":

				// FIXME: cookies raras!
				return;
			// respuesta = (ApiResponseList)
			// clientApi.search.urlsByHeaderRegex(nombreParam + "=.*", "", "",
			// "");

			/* tipo = "COOKIE"; */
			// break;
			default:
				break;
			}
		} catch (ClientApiException cae) {
			// System.out.println("Excepción param:" + nombreParam);
			return;
			// throw cae;
		}

		for (ApiResponse ar : respuesta.getItems()) {
			ars = (ApiResponseSet) ar;
			url = ars.getAttribute("url");
			dom = insertDomain(TargetOfEvaluation.extractDomain(url));
			if (dom != 1 || !checkValidExtension(url)) {
				continue;
			}
			// pag =
			// dominios.get(dom).insertarPagina(WebComponent.extractPagina(url));
			
			pag = dominio.addNewWebComponent(WebComponent.extractWebComponentNoGet(url),30);
			dominio.getWebComponents().get(pag).addInput(/* tipo, */nombreParam);
		}
	}

	private static void runSpidering() throws VulnServerException {
		Duo inicial = cola.poll();
		String urlInicial = inicial.page;
		int domIni = insertDomain(TargetOfEvaluation.extractDomain(urlInicial));

		if (domIni != 1) {
			return;
		}
		// int pagIni =
		// dominios.get(domIni).insertarPagina(WebComponent.extractPagina(urlInicial));
		int pagIni = dominio.addNewWebComponent(WebComponent.extractWebComponent(urlInicial),inicial.depth);
		// WebComponent p = dominios.get(domIni).getPaginas().get(pagIni);
		WebComponent p = dominio.getWebComponents().get(pagIni);

		if (p.isSpidered() || (maxSpiderDepth > 0 && p.getDepth() >= maxSpiderDepth)) {
			p.setSpidered();
			return;
		}

		String sp = doSpider(urlInicial);
		insertWebComponent(sp, p);
	}

	private static void insertWebComponent(String spID, WebComponent paginaRoot) throws VulnServerException {
		int domIns;
		int pagIns;
		String pagPath, domPath;

		try {

			ApiResponseList arl = (ApiResponseList) clientApi.spider.results(spID);
			for (ApiResponse ar : arl.getItems()) {
				String res = ((ApiResponseElement) ar).getValue();
				domPath = TargetOfEvaluation.extractDomain(res); // Sacamos el
																	// dominio
				pagPath = WebComponent.extractWebComponentNoGet(res); // Sacamos la ruta
				if (!WebComponent.checkExtensions(pagPath) || paginaRoot.getPath().equals(pagPath)) {
					continue;
				}
				
				domIns = insertDomain(domPath);
				
				if (domIns != 1) {
					continue;
				}
				// pagIns = dominios.get(domIns).insertarPagina(pagPath);
				pagIns = dominio.addNewWebComponent(pagPath, paginaRoot.getDepth()+1);
				// int[] enlaceIns = {domIns, pagIns};
				int[] enlaceIns = { pagIns };
				paginaRoot.addLinks(enlaceIns);
				cola.offer(new Duo(res,paginaRoot.getDepth()+1));
				// clientApi.spider.stop("JSON", spID);
			}
		} catch (ClientApiException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		paginaRoot.setSpidered();
	}

	public static int insertDomain(String strDominio) throws VulnServerException {
		String reg = "";
		if (dominio == null) {
			dominio = new TargetOfEvaluation(strDominio);
			
			reg = strDominio.replace("/", "\\/").replace(".", "\\.");
			reg = "^(?:(?!"+reg+").*).$";
			try{
				//clientApi.core.newSession("JSON", "", "");
				clientApi.core.excludeFromProxy("JSON", reg);
				clientApi.core.excludeFromProxy("JSON", EXCLUDED_REGEX_BEGIN+excludedExtensionsInSpidering+EXCLUDED_REGEX_END);
				
			}catch(ClientApiException e){
				throw new VulnServerException("Couldn't start a new OWASP ZAP session.", e);
			}
			
			return 1;
		} else if (dominio.getName().equals(strDominio)) {
			return 1;
		} else {
			return 0;
		}

		/*
		 * for (int i = 0; i < dominios.size(); i++) { if
		 * (dominios.get(i).getNombre().equals(strDominio)) { return i; } }
		 * 
		 * TargetOfEvaluation nuevo = new TargetOfEvaluation(strDominio);
		 * //dominios.add(nuevo); return dominios.size() - 1;
		 */
	}

	public static TargetOfEvaluation getDomain() {
		return dominio;
	}
	
	public static void clearDomain(){
		dominio = null;
		
	}

	public static Queue<Duo> getQueue() {
		return cola;
	}

	public static Map<String, Attack> getAttackMap() {
		return attackMap;
	}

	private static String doSpider(String url) {

		
		
		if (monitor != null) {
			System.out.println("Currently Spidering: " + url+" time: "+maxSpiderMilliseconds);
			monitor.subTask("Currently Spidering: " + url);
		}
		String retorno = "-1";
		int total = 0;
		ApiResponseElement falta;

		try {
			clientApi.spider.setOptionMaxDepth("JSON", 1);
			clientApi.spider.setOptionParseSitemapXml("JSON", false);
			clientApi.spider.setOptionParseComments("JSON", false);
			clientApi.spider.setOptionParseRobotsTxt("JSON", false);
			clientApi.spider.setOptionParseSVNEntries("JSON", false);
			clientApi.spider.excludeFromScan("JSON", EXCLUDED_REGEX_BEGIN+excludedExtensionsInSpidering+EXCLUDED_REGEX_END);
			

			ApiResponseElement ape = (ApiResponseElement) clientApi.spider.scan("JSON", url, "0", "1", "", "");
			retorno = ape.getValue();
			while (total < 70) {
				/*
				 * falta = (ApiResponseElement)clientApi.spider.status(spID);
				 * total = Integer.parseInt(falta.getValue());
				 * System.out.println("falta: "+total); Thread.sleep(1000);
				 */
				Thread.sleep(maxSpiderMilliseconds);
				total = 70;
			}
		} catch (ClientApiException | InterruptedException ex) {

			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}

		

		return retorno;
	}

	public static int getZapPort() {
		return zapPort;
	}

	public static void setZapPort(int zapPort) {
		Main.zapPort = zapPort;
	}

	public static String getZapHost() {
		return zapHost;
	}

	public static void setZapHost(String zapHost) {
		Main.zapHost = zapHost;
	}

	public static int getServerPort() {
		return serverPort;
	}

	public static void setServerPort(int serverPort) {
		Main.serverPort = serverPort;
	}

	public static int getMaxSpiderMilliseconds() {
		return maxSpiderMilliseconds;
	}

	public static void setMaxSpiderMilliseconds(int maxSpiderMilliseconds) {
		Main.maxSpiderMilliseconds = maxSpiderMilliseconds;
	}

	public static IProgressMonitor getMonitor() {
		return monitor;
	}

	public static void setMonitor(IProgressMonitor monitor) {
		Main.monitor = monitor;
	}

	public static int getState() {
		return state;
	}

	public static void setState(int state) {
		Main.state = state;
	}
	
	public static String getExcludedExtensionsInSpidering() {
		return excludedExtensionsInSpidering;
	}
	
	public static void setExcludedExtensionsInSpidering(String excludedExtensions) {
		Main.excludedExtensionsInSpidering = excludedExtensions;
	}
	
	public static String getExcludedExtensionsInModel() {
		return excludedExtensionsInModel;
	}
	
	public static void setExcludedExtensionsInModel(String excludedExtensionsInModel) {
		Main.excludedExtensionsInModel = excludedExtensionsInModel;
	}

	public static int getMaxSpiderDepth() {
		return maxSpiderDepth;
	}

	public static void setMaxSpiderDepth(int maxSpiderDepth) {
		Main.maxSpiderDepth = maxSpiderDepth;
	}
	
	
	
	public static AuthSetting getAuthSetting() {
		return authSetting;
	}

	public static void setAuthSetting(AuthSetting authSetting) {
		Main.authSetting = authSetting;
	}



	public static class Duo{
		String page;
		int depth;
		public Duo(String page, int depth) {
			super();
			this.page = page;
			this.depth = depth;
		}
		
	}
}
