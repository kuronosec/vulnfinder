/*
 * Copyright (C) 2016 raven
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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import udea.vulnfinder.xmigenerator.generator.metaclasses.Input;
import udea.vulnfinder.xmigenerator.generator.metaclasses.TargetOfEvaluation;
import udea.vulnfinder.xmigenerator.generator.metaclasses.WebComponent;

public class ServerSocketFinderMina extends IoHandlerAdapter {

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str = message.toString();
        if (str.startsWith("GET")) {
            handleGET(str);
            //System.out.println(str);
            session.closeNow();
        }
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        //System.out.println("IDLE " + session.getIdleCount(status));
    }

    private void handleGET(String msg) {
        String clean;
        String[] parts = msg.split("&");
        //StringBuilder sb = new StringBuilder();
        WebComponent wc = null;
        Input inp = null;
        try {
            for (String part : parts) {
                clean = URLDecoder.decode(part, "UTF-8");
                if (part.startsWith("actionForm")) {
                    //sb.append("action: \"");
                    wc = handleDomain(clean.substring(11));
                    System.out.println("page: "+wc.getRuta());
                } else if (part.startsWith("inputName")) {
                    //sb.append("\" input: \"");
                    if(wc != null){
                        inp = wc.insertarEntrada(clean.substring(10));
                        System.out.println(inp.getNombre());
                    }
                    
                } else if (part.startsWith("attacks")) {
                    //sb.append("\" attack: \"");
                    if(inp != null){
                        inp.getAttList().add(Main.getAttackMap().get(clean.substring(10)));
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //System.out.println(sb.toString());
    }
    
    private WebComponent handleDomain(String url){
        
        int domIni = Main.insertarDominio(TargetOfEvaluation.extractDomain(url));
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
