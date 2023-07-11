package com.jdbc.example.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetInsert {
    static final String url = "jdbc:mysql://localhost:3306/junit";
    static final String pass = "root";
    static final String user = "root";

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, pass, user);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("select * from result");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
        }
        resultSet.moveToInsertRow();
        resultSet.updateInt(1, 0);
        resultSet.updateString(2, "h");
        resultSet.updateString(3, "j");
        resultSet.insertRow();
        resultSet.beforeFirst();
        System.out.println("After Insert one Record ");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
        }


    }
}
