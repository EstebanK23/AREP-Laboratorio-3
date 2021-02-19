package edu.escuelaing.arep.httpserver;

import java.net.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Esteban Bernal
 */
public class HttpServer {

    static PrintWriter out;
    static BufferedReader in;
    /**
     * Metedo main que utilizaremos implementar el servicio http
     * @param args argumentos de la clase main
     **/
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getport());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        boolean running = true;
        while(running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;

            StringBuilder stringBuilder = new StringBuilder();

            Pattern pattern = Pattern.compile("GET /([^\\s]+)");
            Matcher matcher = null;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Recibi: " + inputLine);
                stringBuilder.append(inputLine);
                if (!in.ready()) {
                    matcher = pattern.matcher(stringBuilder.toString());
                    if (matcher.find()) {
                        String req = matcher.group().substring(5);
                        Request(req,clientSocket);
                    }
                    break;
                }
            }
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    /**
     * Metedo Request se encarga de ejecutar la petición que esta solicitando ver el cliente.
     * @param req cadena req(solicitud)
     * @param client socket que se encarga del response al cliente
     **/
    public static void Request(String req, Socket client)throws IOException {
        String path = "src/main/resources/img/";
        String extension = FilenameUtils.getExtension(req);
        File archivo = new File(path + req);

        try {
            if (extension.equals("jpg") || extension.equals("png")) {
                try {
                    FileInputStream fis = new FileInputStream(archivo);
                    byte[] data = new byte[(int) archivo.length()];
                    fis.read(data);
                    fis.close();
                    DataOutputStream binaryOut = new DataOutputStream(client.getOutputStream());
                    binaryOut.writeBytes("HTTP/1.0 200 OK\r\n");
                    binaryOut.writeBytes("Content-Type: image/" + extension + "\r\n");
                    binaryOut.writeBytes("Content-Length: " + data.length);
                    binaryOut.writeBytes("\r\n\r\n");
                    binaryOut.write(data);
                    binaryOut.close();

                } catch (FileNotFoundException e) {
                    out = new PrintWriter(client.getOutputStream(), true);
                    out.println("HTTP/1.1 200 \r\nAccess-Control-Allow-Origin: *\r\nContent-Type: text/html\r\n\r\n" +
                            "<html>" +
                            "<head>" +
                            "<title>404</title>" +
                            "</head>" +
                            "<body>" +
                            "<h1>Error 404 Not Found</h1>" +
                            "</body>" +
                            "</html>");
                }
            } else {
                out.println("HTTP/1.1 200 OK \r\nContent-Type: text/html\r\n\r\n");
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                StringBuilder stringBuilder = new StringBuilder();
                String string;
                while ((string = br.readLine()) != null) {
                    stringBuilder.append(string);
                }
                out.println(stringBuilder.toString());
                br.close();
            }
        } catch (FileNotFoundException e) {
            out = new PrintWriter(client.getOutputStream(), true);
            out.println("HTTP/1.1 200 \r\nAccess-Control-Allow-Origin: *\r\nContent-Type: text/html\r\n\r\n" +
                    "<html>" +
                    "<head>" +
                    "<title>404</title>" +
                    "</head>" +
                    "<body>" +
                    "<h1>Error 404 Not Found</h1>" +
                    "</body>" +
                    "</html>");
        }
    }

    /**
     * Metedo getPort se encarga de obtener el puerto para ejecutar localmente.
     * @return 36000 Puerto para ejecutar localmente
     **/
    private static int getport() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36000;
    }
}
