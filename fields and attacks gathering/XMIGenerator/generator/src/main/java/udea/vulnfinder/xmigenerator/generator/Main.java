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
package udea.vulnfinder.xmigenerator.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.mina.util.SynchronizedQueue;

import br.com.softplan.security.zap.zaproxy.clientapi.core.ApiResponse;
import br.com.softplan.security.zap.zaproxy.clientapi.core.ApiResponseElement;
import br.com.softplan.security.zap.zaproxy.clientapi.core.ApiResponseList;
import br.com.softplan.security.zap.zaproxy.clientapi.core.ApiResponseSet;
import br.com.softplan.security.zap.zaproxy.clientapi.core.ClientApi;
import br.com.softplan.security.zap.zaproxy.clientapi.core.ClientApiException;
import udea.vulnfinder.xmigenerator.generator.exporter.Mem2XMIFormat;
import udea.vulnfinder.xmigenerator.generator.metaclasses.Attack;
import udea.vulnfinder.xmigenerator.generator.metaclasses.Input;
import udea.vulnfinder.xmigenerator.generator.metaclasses.TargetOfEvaluation;
import udea.vulnfinder.xmigenerator.generator.metaclasses.WebComponent;



/**
 *
 * @author Christian Delany
 */
public class Main {

    private static final String TOE = "http://www.pcl.com/";
    //private static final ArrayList<TargetOfEvaluation> dominios = new ArrayList<>();
    private static TargetOfEvaluation dominio = null;
    private static final ClientApi clientApi = new ClientApi("localhost", 8090);
    private static Queue<String> cola = new ConcurrentLinkedDeque<>();//new LinkedList<>();
    private static final int SERVERPORT = 3000;
    private static final Map<String, Attack> attackMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws ClientApiException, IOException {
        IoAcceptor acc = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initialize();
        acc = startServerSocketFinder();
        do {
            System.out.println("Ingrese y para iniciar el spidering.");
        } while (!"y".equals(br.readLine()));
        acc.unbind();
        acc.dispose();
        
        insertarDominio(TargetOfEvaluation.extractDomain(TOE));
        System.out.println("Dominio: " + dominio.getNombre());
        for (WebComponent c : dominio.getPaginas()) {
            System.out.println("Pagina: " + c.getRuta());
            for (Input i : c.getEntradas()) {
                System.out.println("\tInput: " + i.getNombre());
                for (Attack a : i.getAttList()) {
                    System.out.println("\t\tAttack: " + a.getName());
                }
            }
        }
        start();
    }

    private static IoAcceptor startServerSocketFinder() throws IOException {
        IoAcceptor acceptor = new NioSocketAcceptor();

        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

        acceptor.setHandler(new ServerSocketFinderMina());
        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        acceptor.bind(new InetSocketAddress(SERVERPORT));
        return acceptor;
    }

    private static void initialize() {
        attackMap.put("SQL Injection", new Attack("SQLInjection"));
        attackMap.put("Authentication", new Attack("Authentication"));
        attackMap.put("Authorization", new Attack("Authorization"));
        attackMap.put("XSS", new Attack("XSS"));
        attackMap.put("Privilege Scalation", new Attack("PrivilegeScalation"));
        int i = 0;
        for (Map.Entry<String, Attack> e : attackMap.entrySet()) {
            e.getValue().setIndex(i++);
        }
    }

    private static void start() {
        cola.offer(/*dominio.getNombre()*/TOE);
        while (!cola.isEmpty()) {
            realizarSpidering();
        }
        try {
            System.out.println("ingresando entradas");
            ingresarEntradas();
        } catch (ClientApiException cae) {
            cae.printStackTrace();
            //System.out.println("error");
        }
        Mem2XMIFormat mem2xmi = new Mem2XMIFormat(dominio, attackMap);
        System.out.println("generando");
        System.out.println(mem2xmi.generateXMIFormat());
    }

    private static void ingresarEntradas() throws ClientApiException {
        ApiResponseSet ars;
        for (ApiResponse respuestaParams : ((ApiResponseList) clientApi.params.params(null)).getItems()) {
            for (ApiResponse valoresParams : ((ApiResponseList) respuestaParams).getItems()) {
                if (valoresParams instanceof ApiResponseSet) {
                    ars = (ApiResponseSet) valoresParams;
                    String nombreParam = ars.getAttribute("name");
                    String tipoParam = ars.getAttribute("type");
                    //System.out.println("sitio: "+ars.getAttribute("site"));
                    agregarParam(tipoParam, nombreParam);
                }
            }
        }
    }

    private static void agregarParam(String tipoParam, String nombreParam) throws ClientApiException {
        ApiResponseSet ars;
        ApiResponseList respuesta = null;
        String url = null;
        //String tipo = null;
        int dom, pag;
        try {
            switch (tipoParam) {
                case "form":
                    //System.out.println("post");
                    respuesta = (ApiResponseList) clientApi.search.urlsByRequestRegex(nombreParam + "=.*", "", "", "");
                    /*tipo = "POST";*/
                    break;
                case "url":
                    //System.out.println("get");
                    respuesta = (ApiResponseList) clientApi.search.urlsByUrlRegex("[?&]" + nombreParam + "=.*", "", "", "");
                    /*tipo = "GET";*/
                    break;
                case "cookie":
                    
                    //FIXME: cookies raras!
                    return;
                    //respuesta = (ApiResponseList) clientApi.search.urlsByHeaderRegex(nombreParam + "=.*", "", "", "");

                    /*tipo = "COOKIE";*/
                    //break;
                default:
                    break;
            }
        } catch (ClientApiException cae) {
            //System.out.println("Excepción param:" + nombreParam);
            return;
            //throw cae;
        }

        for (ApiResponse ar : respuesta.getItems()) {
            ars = (ApiResponseSet) ar;
            url = ars.getAttribute("url");
            dom = insertarDominio(TargetOfEvaluation.extractDomain(url));
            if (dom != 1) {
                continue;
            }
            //pag = dominios.get(dom).insertarPagina(WebComponent.extractPagina(url));
            pag = dominio.insertarPagina(WebComponent.extractPagina(url));
            dominio.getPaginas().get(pag).insertarEntrada(/*tipo, */nombreParam);
        }
    }

    private static void realizarSpidering() {
        
        String urlInicial = cola.poll();
        int domIni = insertarDominio(TargetOfEvaluation.extractDomain(urlInicial));
        
        if (domIni != 1) {
            return;
        }
        //int pagIni = dominios.get(domIni).insertarPagina(WebComponent.extractPagina(urlInicial));
        int pagIni = dominio.insertarPagina(WebComponent.extractPagina(urlInicial));
        //WebComponent p = dominios.get(domIni).getPaginas().get(pagIni);
        WebComponent p = dominio.getPaginas().get(pagIni);
        
        if (p.isSpidered()) {
            return;
        }
        
        String sp = spiderear(urlInicial);
        insertarPaginas(sp, p);
    }

    private static void insertarPaginas(String spID, WebComponent paginaRoot) {
        int domIns;
        int pagIns;
        String pagPath, domPath;
        
        try {
            
            
            ApiResponseList arl = (ApiResponseList) clientApi.spider.results(spID);
            for (ApiResponse ar : arl.getItems()) {
                String res = ((ApiResponseElement) ar).getValue();
                domPath = TargetOfEvaluation.extractDomain(res); //Sacamos el dominio
                pagPath = WebComponent.extractPagina(res); //Sacamos la ruta
                if (!WebComponent.revisaExtensiones(pagPath) || paginaRoot.getRuta().equals(pagPath)) {
                    continue;
                }
                domIns = insertarDominio(domPath);
                if (domIns != 1) {
                    continue;
                }
                //pagIns = dominios.get(domIns).insertarPagina(pagPath);
                pagIns = dominio.insertarPagina(pagPath);
                //int[] enlaceIns = {domIns, pagIns};
                int[] enlaceIns = {pagIns};
                paginaRoot.insertarEnlaces(enlaceIns);
                cola.offer(res);
                //clientApi.spider.stop("JSON", spID);
            }
        } catch (ClientApiException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        paginaRoot.setSpidered();
    }

    public static int insertarDominio(String strDominio) {

        if (dominio == null) {
            dominio = new TargetOfEvaluation(strDominio);
            return 1;
        } else if (dominio.getNombre().equals(strDominio)) {
            return 1;
        } else {
            return 0;
        }

        /*for (int i = 0; i < dominios.size(); i++) {
            if (dominios.get(i).getNombre().equals(strDominio)) {
                return i;
            }
        }
        
        TargetOfEvaluation nuevo = new TargetOfEvaluation(strDominio);
        //dominios.add(nuevo);
        return dominios.size() - 1;*/
    }

    public static TargetOfEvaluation getDominio() {
        return dominio;
    }

    public static Queue<String> getCola() {
        return cola;
    }

    public static Map<String, Attack> getAttackMap() {
        return attackMap;
    }

    private static String spiderear(String url) {
        System.out.println("Spidereando: " + url);
        String retorno = "-1";
        int total = 0;
        ApiResponseElement falta;
        
        try {
            clientApi.spider.setOptionMaxDepth("JSON", 1);
            clientApi.spider.setOptionParseSitemapXml("JSON", false);
            clientApi.spider.setOptionParseComments("JSON", false);
            
            ApiResponseElement ape = (ApiResponseElement) clientApi.spider.scan("JSON", url, "0", "1", "Default Context");
            retorno = ape.getValue();
            while(total < 70){
                /*falta = (ApiResponseElement)clientApi.spider.status(spID);
                total = Integer.parseInt(falta.getValue());
                System.out.println("falta: "+total);
                Thread.sleep(1000);*/
                Thread.sleep(3000);
                total = 70;
            }
        } catch (ClientApiException | InterruptedException ex) {
            
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }

}
