package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DBConnection {
    private final Connection connection;

    private final AppPropertiesReader appPropertiesReader = AppPropertiesReader.getInstance();
    private static DBConnection instance = null;
    public static DBConnection getInstance(){
        if (instance==null){
            instance = new DBConnection();
        }
        return instance;
    }

    public DBConnection() {
        System.out.println("Establishing connection with the database...");
        try {
            connection = DriverManager.getConnection(
                    appPropertiesReader.getProperty("nutrifusionfood.datasource.url"),
                    appPropertiesReader.getProperty("nutrifusionfood.datasource.username"),
                    appPropertiesReader.getProperty("nutrifusionfood.datasource.password")
            );
            System.out.println("Connection established with the database");
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database.");
        }
    }

    public Connection getConnection(){
        return connection;
    }
    public void executeScript(String scriptPath) {
        try {
            ScriptRunner scriptRunner = new ScriptRunner(connection, false, false);

            InputStream scriptStream = getClass().getClassLoader().getResourceAsStream(scriptPath);
            if (scriptStream == null)
                throw new RuntimeException("Script not found: " + scriptPath);

            scriptRunner.runScript(new InputStreamReader(scriptStream));
        } catch (IOException | SQLException e) {
            log.error(String.format("Error executing script %s:\n    %s\n", scriptPath, e.getMessage()));
            throw new RuntimeException(e);
        }
    }
}
