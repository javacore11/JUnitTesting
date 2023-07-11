package com.jdbc.example.simplecurd;

import java.sql.*;

public class RetrieveTable {
    static final String url = "jdbc:mysql://localhost:3306/junit";
    static final String user = "root";
    static final String pass = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement statement = connection.createStatement()
        ) {
            String sql = "select * from test";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
