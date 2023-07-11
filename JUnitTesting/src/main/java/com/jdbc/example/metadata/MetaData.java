package com.jdbc.example.metadata;

import java.sql.*;

public class MetaData {
    static final String url = "jdbc:mysql://localhost:3306/junit";
    static final String pass = "root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, pass, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from result");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int count = resultSetMetaData.getColumnCount();
            System.out.println(count);
            for (int i = 1; i <= count; i++) {
                System.out.println(resultSetMetaData.getColumnName(i));
                System.out.println(resultSetMetaData.getColumnTypeName(i));
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
