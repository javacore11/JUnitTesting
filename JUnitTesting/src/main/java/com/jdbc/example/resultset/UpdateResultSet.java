package com.jdbc.example.resultset;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateResultSet {
    static  final String url="jdbc:mysql://localhost:3306/junit";
    static final String user="root";
    static  final String pass="root";
    public static void main(String[] args)throws Exception {
        ResultSet resultSet=null;
        Statement statement=null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection(url,user,pass);
        statement= connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        resultSet=statement.executeQuery("select * from test");
        resultSet.next();
        resultSet.next();
        resultSet.deleteRow();
        System.out.println("Deleted Row Successfully");

    }
}
