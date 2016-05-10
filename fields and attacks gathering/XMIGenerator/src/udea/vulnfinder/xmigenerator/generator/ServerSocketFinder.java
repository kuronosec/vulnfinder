package udea.vulnfinder.xmigenerator.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerSocketFinder extends Thread {

    private static Socket sockett;

    @Override
    public void run() {
        try {
            int x = 0;
            int port = 3000;
            ServerSocket serverSocket = new ServerSocket(port);
            //String l;

            while (true) {
                sockett = serverSocket.accept();
                
                //sockett.close();
                x++;
                System.out.println(x);
                
                Thread t1 = new Thread(new Runnable() {
                    public void run() {
                        Socket socket = sockett;
                        String l;
                        InputStream is;
                        try {
                            is = socket.getInputStream();
                            InputStreamReader isr = new InputStreamReader(is);
                            BufferedReader br = new BufferedReader(isr);
                           
                            StringBuilder sb;
                            
                            try {
                                while ((l = br.readLine()) != null) {
                                    //if (l.startsWith("GET")) {
                                        System.out.println(l);
                                    //}
                                }
                                //System.out.println("1");
                            } catch (Exception ex) {
                                System.out.println("uuu");
                                Logger.getLogger(ServerSocketFinder.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (IOException ex) {
                            System.out.println("eee");
                            Logger.getLogger(ServerSocketFinder.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("Cliente Conectado");
                    }
                });
                t1.start();
                //Thread.sleep(1000);
                //sockett.close();
                
                /*int c;
                boolean inicio = false;
                StringBuilder datos = new StringBuilder();

                while ((c = br.read()) != 125) {
                    if (c == 123) {
                        inicio = true;
                    }
                    if (inicio) {
                        datos.append((char) c);
                    }
                }

                datos.append('}');

                System.out.println("Datos = " + datos.toString());

                String dataResponse = "";

                if (datos.length() <= 2) {
                    dataResponse = "{\"response\":\"empty\"}";
                } else {
                    dataResponse = "{\"response\":\"ok\"}";
                }

                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);

                bw.write("HTTP/1.1 200 OK\r\n");
                bw.write("Content-Type: text/html\r\n");
                bw.write("Content-Length: " + dataResponse.length() + "\r\n");
                // Permitir la respuesta por ajax desde cualquier origen.
                bw.write("Access-Control-Allow-Origin: *\r\n");

                bw.write("\r\n");
                bw.write(dataResponse);
                System.out.println("Mensaje enviado al cliente: " + dataResponse);
                bw.flush();*/
                //socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
