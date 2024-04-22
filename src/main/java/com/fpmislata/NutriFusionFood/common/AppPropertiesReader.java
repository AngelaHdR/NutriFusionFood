package com.fpmislata.NutriFusionFood.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppPropertiesReader {
    private final Properties properties = new Properties();

    public static AppPropertiesReader instace;

    private AppPropertiesReader() {
        loadAppProperties();
    }

    public static AppPropertiesReader getInstance() {
        if (instace == null) {
            instace = new AppPropertiesReader();
        }
        return instace;
    }

    private void loadAppProperties() {
        String fileName = "application.properties";
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Error loading properties file: " + fileName);
            throw new RuntimeException("Error loading properties file: " + fileName);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
