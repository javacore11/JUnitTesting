package com.jdbc.example.simplecurd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost/junit";
        final String user = "root";
        final String password = "root";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement()
        ) {
            String sql = "create table test(first varchar(255),last varchar(255))";
            statement.executeUpdate(sql);
            System.out.println("Table Created Successfully ");


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
