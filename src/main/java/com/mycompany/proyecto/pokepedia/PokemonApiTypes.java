package com.mycompany.proyecto.pokepedia;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

public class PokemonApiTypes implements Runnable {
    private static final Logger LOGGER = LoggerConfig.getLogger();
    private final String userType;
    

    private static final String PROPERTIES_FILE = "URL.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            LOGGER.severe("Error al cargar el archivo: "+e.getMessage());
        }
    }

    public static String getTypeUrl() {
        return properties.getProperty("typeEndpoint.url");
    }
    

    public PokemonApiTypes(String userType){
        this.userType = userType;

    }
    public String[] getListaPokemones() {
    try {
        String typeEndpoint = getTypeUrl() + userType + "/";
        String typeResponse = sendHttpRequest(typeEndpoint);
        JsonObject typeJson = JsonParser.parseString(typeResponse).getAsJsonObject();
        JsonArray pokemonList = typeJson.getAsJsonArray("pokemon");

        String[] pokemonListString = new String[pokemonList.size()];

        for (int i = 0; i < pokemonList.size(); i++) {
            JsonObject pokemon = pokemonList.get(i).getAsJsonObject();
            pokemonListString[i] = pokemon.getAsJsonObject("pokemon").get("name").getAsString();
        }

        return pokemonListString;
    } catch (Exception e) {
        LOGGER.severe("Error al obtener la lista de Pokémon: " + e.getMessage());
        return null;
    }
}

    @Override
    public void run() {
        try {
            String typeEndpoint = getTypeUrl() + userType + "/";
            String typeResponse = sendHttpRequest(typeEndpoint);
            JsonObject typeJson = JsonParser.parseString(typeResponse).getAsJsonObject();
            JsonArray pokemonList = typeJson.getAsJsonArray("pokemon");
            System.out.println("Lista de Pokémon de tipo " + userType + ":");
            String[] pokemonListString = new String[pokemonList.size()];
            for (int i = 0; i < pokemonList.size(); i++) {
                JsonObject pokemon = pokemonList.get(i).getAsJsonObject();
                pokemonListString[i] = pokemon.getAsJsonObject("pokemon").get("name").getAsString();
                System.out.print(pokemonListString[i]+"\t"+"\t");
            }
            System.out.println();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userType = reader.readLine();
            Pokemon pokemon = new PokemonApiName(userType).getPokemon();

            System.out.println("Nombre: " + pokemon.getNombre());
            System.out.println("Ilustración: " + pokemon.getIlustracion());
            System.out.println("Tipo: " + pokemon.getTipo());
            System.out.println("Habilidad: " + pokemon.getHabilidad());
            System.out.println("Descripción de la Habilidad: " + pokemon.getDescripcionHabilidad());
            System.out.println("Ataque: " + pokemon.getAtaque());
            System.out.println("Daño del Ataque: " + pokemon.getDanioAtaque());
            System.out.println("Descripción del Ataque: " + pokemon.getDescripcionAtaque());
        } catch (NullPointerException ex) {
            LOGGER.severe("Error al obtener las URLs: " + ex.getMessage());
        } catch (Exception e) {
            LOGGER.severe("Sucedio un error al acceder a la API: "+e.getMessage());
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
