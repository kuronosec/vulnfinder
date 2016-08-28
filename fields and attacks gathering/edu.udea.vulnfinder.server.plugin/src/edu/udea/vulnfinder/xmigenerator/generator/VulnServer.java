package edu.udea.vulnfinder.xmigenerator.generator;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import edu.udea.vulnfinder.server.plugin.utils.MessageLauncher;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnRequestParseException;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnServerException;
import edu.udea.vulnfinder.xmigenerator.generator.gsonClasses.VulnJsonRequestElement;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.Attack;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.Input;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.TargetOfEvaluation;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.WebComponent;
import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response.Status;

public class VulnServer extends NanoHTTPD {

	public VulnServer(int port) throws IOException {
		super(port);
		start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
	}

	@Override
	public Response serve(IHTTPSession session) {
		Scanner scanner = new Scanner(session.getInputStream());
		Response r = null;
		if (scanner.hasNext()) {
			try {
				handleMessage(scanner.nextLine());
				r = newFixedLengthResponse(Status.OK, "text/html", "");
			} catch (VulnRequestParseException | VulnServerException e) {
				System.err.println("Error while parsing request: "+e.getMessage());
				r = newFixedLengthResponse(Status.BAD_REQUEST, "text/html", e.getMessage());
			}
		}
		if(r == null){
			r = newFixedLengthResponse(Status.BAD_REQUEST, "text/html", "Request body was empty.");
		}
		r.addHeader("Access-Control-Allow-Origin", "*");
		return r;

		
	}

	private void handleMessage(String msg) throws VulnRequestParseException, VulnServerException {
		Attack a;
		try {
			MessageLauncher.showInformation(null, "Llegó petición", msg);
			
			VulnJsonRequestElement[] vjres = new Gson().fromJson(msg, VulnJsonRequestElement[].class);

			
			WebComponent wc = null;
			Input inp = null;

			for (VulnJsonRequestElement element : vjres) {
				if (element.getActionForm() == null || element.getInputName() == null || element.getAttacks() == null) {
					throw new VulnRequestParseException("JSON format exception, request is lacking fields.");
				}

			}
			System.out.println(Arrays.deepToString(vjres));
			for (VulnJsonRequestElement element : vjres) {

				wc = handleDomain(element.getActionForm());
				if (wc != null) {
					inp = wc.insertarEntrada(element.getInputName());
					if (inp != null) {
						for (String at : element.getAttacks()) {
							a = Main.getAttackMap().get(at);
							if(a != null){
								inp.getAttList().add(a);
							}else{
								throw new VulnRequestParseException("Attack '"+at+"' is not a valid attack type");
							}
						}
					} else {
						throw new VulnRequestParseException("Input name was null or invalid");
					}
				} else {
					throw new VulnRequestParseException("URL was null or invalid");
				}
			}
		} catch (JsonSyntaxException jse) {
			throw new VulnRequestParseException("Error while parsing JSON",jse);
		}
	}

	private WebComponent handleDomain(String url) throws VulnServerException {
		String domStr = TargetOfEvaluation.extractDomain(url);
		if(Main.getDominio() != null && !Main.getDominio().getNombre().equals(url)){
			Main.clearDomain();
		}
		int domIni = Main.insertarDominio(domStr);
		if (domIni != 1) {
			return null;
		}
		int pagIni = Main.getDominio().insertarPagina(WebComponent.extractPagina(url));
		WebComponent p = Main.getDominio().getPaginas().get(pagIni);
		if (!p.isSpidered()) {
			Main.getCola().offer(url);
		}
		return p;
	}
}