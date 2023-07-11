package com.jdbc.example.simplecurd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTable {
    static final String url="jdbc:mysql://localhost:3306/junit";
    static final String user="root";
    static final String pass="root";

    public static void main(String[] args) {
        try(Connection connection= DriverManager.getConnection(url,user,pass);
            Statement statement=connection.createStatement()
        ){
            String sql="update test set first = 'scoutop' where last ='op'" ;
            statement.executeUpdate(sql);
            System.out.println("Updated");

        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

}
