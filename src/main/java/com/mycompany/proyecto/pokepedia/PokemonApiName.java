package com.mycompany.proyecto.pokepedia;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.Random;


public class PokemonApiName {
    private static final Logger LOGGER = LoggerConfig.getLogger();
    private Pokemon pokemon;
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
    public static String getPokemonUrl() {
        return properties.getProperty("pokemon.url");
    }

    public PokemonApiName(String pokemonName) {
        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            URI uri = URI.create(getPokemonUrl() + pokemonName);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            JsonElement jsonElement = JsonParser.parseString(response.body());
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String nombre = jsonObject.get("name").getAsString();
            String ilustracion = jsonObject.getAsJsonObject("sprites").get("front_default").getAsString();
            String tipo = jsonObject.getAsJsonArray("types")
                    .get(0).getAsJsonObject().getAsJsonObject("type").get("name").getAsString();

            String habilidad = "";
            String urlHabilidad = "";
            String descripcionHabilidad="";

            if (jsonObject.has("abilities") && jsonObject.getAsJsonArray("abilities").size() > 0) {
                JsonObject abilities = jsonObject.getAsJsonArray("abilities").get(0).getAsJsonObject();
                habilidad = abilities.getAsJsonObject("ability").get("name").getAsString();
                urlHabilidad = abilities.getAsJsonObject("ability").get("url").getAsString();
            }

            if (!urlHabilidad.isEmpty()) {
                URI uriHabilidad = URI.create(urlHabilidad);
                HttpRequest requestHabilidad = HttpRequest.newBuilder()
                        .uri(uriHabilidad)
                        .build();

                HttpResponse<String> responseHabilidad = httpClient.send(requestHabilidad, HttpResponse.BodyHandlers.ofString());
                JsonElement jsonElementHabilidad = JsonParser.parseString(responseHabilidad.body());
                JsonObject jsonHabilidad = jsonElementHabilidad.getAsJsonObject();
                descripcionHabilidad = obtenerDescripcionEnIngles(jsonHabilidad);
            }

            JsonArray movesArray = jsonObject.getAsJsonArray("moves");
            JsonObject randomMove = obtenerAtaqueRandom(movesArray);
            String ataque = randomMove.getAsJsonObject("move").get("name").getAsString();

            int danioAtaque = 0;
            try {
                danioAtaque = obtenerDanioAtaque(randomMove.getAsJsonObject("move").get("url").getAsString());
            } catch (Exception e) {
                LOGGER.severe("Error al obtener el daño del ataque: " + e.getMessage());
            }
            String descripcionAtaque = "";
            try {
                descripcionAtaque = obtenerDescripcionAtaque(randomMove.getAsJsonObject("move").get("url").getAsString());
            } catch (Exception e) {
                LOGGER.severe("Error al obtener la descripción del ataque: " + e.getMessage());
            }

            pokemon = new Pokemon(nombre, ilustracion, tipo, habilidad, descripcionHabilidad, ataque, danioAtaque, descripcionAtaque);

        } catch (NullPointerException ex) {
            LOGGER.severe("Error al obtener las URLs: " + ex.getMessage());
        } catch (Exception e) {
            LOGGER.severe("Sucedio un error al acceder a la API: "+e.getMessage());
        }
    }

    private static JsonObject obtenerAtaqueRandom(JsonArray movesArray) {
        Random random = new Random();
        int randomAtaque = random.nextInt(movesArray.size());
        return movesArray.get(randomAtaque).getAsJsonObject();
    }

    private static int obtenerDanioAtaque(String moveUrl) throws Exception {
        URI uri = URI.create(moveUrl);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JsonElement jsonElement = JsonParser.parseString(response.body());

        if (jsonElement.getAsJsonObject().has("power")) {
            return jsonElement.getAsJsonObject().get("power").getAsInt();
        } else {
            return 0;
        }
    }

    private static String obtenerDescripcionAtaque(String moveUrl) throws Exception {
        URI uri = URI.create(moveUrl);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JsonElement jsonElement = JsonParser.parseString(response.body());
        return jsonElement.getAsJsonObject().get("effect_entries").getAsJsonArray()
                .get(0).getAsJsonObject().get("short_effect").getAsString();
    }

    private static String obtenerDescripcionEnIngles(JsonObject jsonHabilidad) {
        String descripcionEnIngles = "";

        if (jsonHabilidad.has("effect_entries") && jsonHabilidad.getAsJsonArray("effect_entries").size() > 0) {
            JsonArray effectEntries = jsonHabilidad.getAsJsonArray("effect_entries");

            for (JsonElement entry : effectEntries) {
                JsonObject entryObject = entry.getAsJsonObject();
                JsonObject language = entryObject.getAsJsonObject("language");

                if (language.has("name") && language.get("name").getAsString().equals("en")) {
                    descripcionEnIngles = entryObject.get("effect").getAsString();
                    break;
                }
            }
        }

        return descripcionEnIngles;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
