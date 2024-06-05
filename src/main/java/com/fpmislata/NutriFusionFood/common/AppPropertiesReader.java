package com.fpmislata.NutriFusionFood.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppPropertiesReader {
    private final Properties properties = new Properties();

    public static AppPropertiesReader instace;

    public static AppPropertiesReader getInstance() {
        if (instace == null) {
            instace = new AppPropertiesReader();
        }
        return instace;
    }

    private AppPropertiesReader() {
        loadProperties("application.properties");
        // Detectar el perfil y cargar las propiedades correspondientes
        String activeProfile = getProperty("spring.profiles.active");
        if (activeProfile != null) {
            loadProperties("application-" + activeProfile + ".properties");
        } else {
            System.out.println("No s'ha especificat cap perfil actiu");
        }
    }


    private void loadProperties(String filename) {
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)) {
            if (input == null) {
                System.out.println("Lo siento, no se pudo encontrar el archivo " + filename);
                return;
            }

            // Cargar las propiedades desde el archivo de configuración
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
