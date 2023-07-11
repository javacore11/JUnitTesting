package com.jdbc.example.resultset;

import java.sql.*;

public class MyResultSetUpdate {
    static final String url = "jdbc:mysql://localhost:3306/junit";
    static final String user = "root";
    static final String pass = "root";

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, pass);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("select * from result");
        while (resultSet.next()) {
            if (resultSet.getInt(1) == 3) {
                resultSet.updateString(3, "Hello");
                resultSet.updateRow();
                System.out.println("Record Updated ");
            }
        }


    }
}
