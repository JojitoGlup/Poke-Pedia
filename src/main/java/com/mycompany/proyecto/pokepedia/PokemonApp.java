package com.mycompany.proyecto.pokepedia;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Properties;


public class PokemonApp {

    public static final Logger LOGGER = LoggerConfig.getLogger();
    private static final String PROPERTIES_FILE = "URL.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            LOGGER.severe("Error al cargar el archivo: "+e.getMessage());
            //e.printStackTrace();
        }
    }

    public static String getTypeUrl() {
        return properties.getProperty("allTypesEndpoint.url");
    }

    public static void main(String[] args) {
        try {
            String allTypesEndpoint = getTypeUrl();
            String allTypesResponse = sendHttpRequest(allTypesEndpoint);
            JsonObject allTypesJson = JsonParser.parseString(allTypesResponse).getAsJsonObject();
            JsonArray typesList = allTypesJson.getAsJsonArray("results");
            String[] typesString = new String[typesList.size()];
            for (int i = 0; i < typesList.size(); i++) {
                JsonObject type = typesList.get(i).getAsJsonObject();
                typesString[i] = type.get("name").getAsString();
            }
            System.out.println("Selecciona un tipo de Pokemon que existe");
            for (int i = 0; i < typesString.length; i++) {
                System.out.print((i+1)+":"+typesString[i]+"\t");
            }
            System.out.println();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userType = reader.readLine();
            System.out.println(userType);
            PokemonApiTypes apiTypes = new PokemonApiTypes(userType);
            Thread apiThread = new Thread(apiTypes);
            apiThread.start();
            apiThread.join();
        } catch (NullPointerException ex) {
            LOGGER.severe("Error al obtener las URLs: " + ex.getMessage());
            //ex.printStackTrace();
        } catch (Exception e) {
            LOGGER.severe("Sucedio un error al acceder a la API: "+e.getMessage());
            //e.printStackTrace();
        }
    }

    private static String sendHttpRequest(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        return response.toString();
    }
}
