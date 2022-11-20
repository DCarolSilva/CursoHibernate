package com.examenDaniela.examen.conexionApi;

import org.apache.el.stream.Stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * @author Daniela Carolina Silva Laguna.
 */
public class ClienteConexionApi {
    public static Map<String, Object> peticion(String tipo, String path, String parametroClase) {
        final String pathBase = "http://localhost:8080/";
        Map<String,Object> respuesta = new HashMap<>();
        try {
            URL url = new URL(pathBase.concat(path));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("admin", "1234".toCharArray());
                }
            };
            Authenticator.setDefault(auth);
            connection.setRequestMethod(tipo.toUpperCase());

            switch (tipo.toUpperCase()) {
                case "GET":
                case "DELETE":
                    connection.connect();
                    Integer resp = connection.getResponseCode();
                    if (resp != 200) {
                        System.out.println("conexion erronea");
                        respuesta.put("cod",resp);
                        respuesta.put("data","conexion erronea");
                        return respuesta;
                    } else {
                        if (tipo.toUpperCase().equals("DELETE")) {
                            System.out.println("Registro eliminado correctamente");
                            respuesta.put("cod",resp);
                            respuesta.put("data","Registro eliminado correctamente");
                            return respuesta;
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            Scanner scanner = new Scanner(connection.getInputStream());
                            while (scanner.hasNext()) {
                                stringBuilder.append(scanner.nextLine());
                            }
                            scanner.close();
                            System.out.println(stringBuilder);

                            respuesta.put("cod",resp);
                            respuesta.put("data",stringBuilder.toString());
                            return respuesta;
                        }
                    }
                case "POST":
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setRequestProperty("Accept", "application/json");
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    try (OutputStream os = connection.getOutputStream()) {
                        byte[] in = parametroClase.getBytes("utf-8");
                        os.write(in, 0, in.length);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                        StringBuilder response = new StringBuilder();
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        System.out.println(response.toString());
                    }

                    break;
                default:
                    break;
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
