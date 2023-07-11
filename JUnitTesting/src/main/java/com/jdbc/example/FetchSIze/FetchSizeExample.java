package com.jdbc.example.FetchSIze;

import java.sql.*;

public class FetchSizeExample {
    static final String url = "jdbc:mysql://localhost:3306/junit";
    static final String user = "root";
    static final String pass = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement statement = connection.createStatement()
        ) {
            int fetchSize = statement.getFetchSize();
            System.out.println(fetchSize);
            statement.setFetchSize(3);
            fetchSize = statement.getFetchSize();
            System.out.println(fetchSize);
            ResultSet resultSet = statement.executeQuery("Select * from result");
            fetchSize = resultSet.getFetchSize();
            System.out.println("Fetch Size Before " + fetchSize);
            System.out.println("Changing FetchSize ResultSet");
            resultSet.setFetchSize(5);
            fetchSize = resultSet.getFetchSize();
            System.out.println(fetchSize + " Result Set");
            statement.setFetchSize(6);
            System.out.println(statement.getFetchSize());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
