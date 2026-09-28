package com.example.__09_2026_hardware_zadatak.test;

import java.sql.*;

public class SQLDatabaseConnection {
    public static void main(String[] args) {
        String connectionUrl =
                "jdbc:sqlserver://localhost\\SQLEXPRESS;"
                        + "database=MojaPrvaBaza;"
                        + "user=sa;"
                        + "password=SQL;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * from dbo.Hardware";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
