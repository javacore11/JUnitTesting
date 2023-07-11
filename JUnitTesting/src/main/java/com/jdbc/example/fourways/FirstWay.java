package com.jdbc.example.fourways;

import java.sql.*;

public class FirstWay {
    /**
     * Simple Try catch
     */
    static final String url="jdbc:mysql://localhost:3306/junit";
    static final String user="root";
    static final String pass="root";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,user,pass);
            Statement statement= connection.createStatement();
            statement.executeUpdate("insert into test values('tom','cuz')");
            System.out.println("Insert Successfully");
            ResultSet resultSet= statement.executeQuery("select * from test");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }
            System.out.println("Successfully ");

        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
