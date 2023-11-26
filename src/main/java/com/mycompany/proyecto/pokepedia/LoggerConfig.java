package com.mycompany.proyecto.pokepedia;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerConfig {

    private static final String LOG_FILE_PATH = "Errores.log";
    private static Logger logger;
    public static Logger getLogger() {
        if (logger == null) {
            configureLogger();
        }
        return logger;
    }
    private static void configureLogger() {
        logger = Logger.getLogger(LoggerConfig.class.getName());

        try {
            FileHandler fileHandler = new FileHandler(LOG_FILE_PATH, true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);

            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);

        } catch (IOException e) {
            logger.severe("Error al configurar el logger: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
