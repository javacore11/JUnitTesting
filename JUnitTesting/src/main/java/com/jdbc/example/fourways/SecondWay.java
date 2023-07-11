package com.jdbc.example.fourways;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SecondWay {
    static final String url = "jdbc:mysql://localhost:3306/junit";
    static final String pass = "root";
    static final String user = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement statement = connection.createStatement()) {
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
