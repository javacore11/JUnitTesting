package com.jdbc.example.fourways;

import java.sql.Connection;
import java.sql.DriverManager;

public class ThirdWay {
    static  final String url="jdbc:mysql://localhost:3306/junit";
    static final String pass="root";
    static  final String user="root";
    public static void main(String[] args) {
        try {
            //new com.mysql.jdbc.Driver();
            Connection connection=DriverManager.getConnection(url,user,pass);
            System.out.println(connection);


        }
        catch (Exception exception){
            exception.printStackTrace();
        }

    }
}
