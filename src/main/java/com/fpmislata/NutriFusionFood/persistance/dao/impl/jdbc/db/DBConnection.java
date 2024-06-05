package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.LogManager;

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
        String host = appPropertiesReader.getProperty("nutrifusionfood.datasource.url");
        String user = appPropertiesReader.getProperty("nutrifusionfood.datasource.username");
        String passwd = appPropertiesReader.getProperty("nutrifusionfood.datasource.password");
        try {
            connection = DriverManager.getConnection(
                    host,
                    user,
                    passwd
            );
            System.out.println("Connection established with the database");
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database. " +
                    host +" "+ user +" "+ passwd + " " + e.getMessage());
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
            LogManager.getLogManager().getLogger("").info(String.format("Error executing script %s:\n    %s\n", scriptPath, e.getMessage()));
            throw new RuntimeException(e);
        }
    }
}
