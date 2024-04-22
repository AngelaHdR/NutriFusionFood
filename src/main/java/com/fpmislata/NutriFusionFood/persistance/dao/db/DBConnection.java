package com.fpmislata.NutriFusionFood.persistance.dao.db;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final Connection connection;

    private final AppPropertiesReader appPropertiesReader = AppPropertiesReader.getInstance();

    public DBConnection() {
        System.out.println("Establishing connection with the database...");
        try {
            connection = DriverManager.getConnection(
                    appPropertiesReader.getProperty("daw1bookstore.datasource.url"),
                    appPropertiesReader.getProperty("daw1bookstore.datasource.username"),
                    appPropertiesReader.getProperty("daw1bookstore.datasource.password")
            );
            System.out.println("Connection established with the database");
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database.");
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
