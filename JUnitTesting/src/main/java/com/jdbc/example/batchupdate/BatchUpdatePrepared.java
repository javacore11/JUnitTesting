package com.jdbc.example.batchupdate;

import java.sql.*;
import java.util.Arrays;

public class BatchUpdatePrepared {
    final static String url = "jdbc:mysql://localhost:3306/junit";
    final static String pass = "root";
    final static String user = "root";

    public static void main(String[] args) {
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, pass, user);
            Statement statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("update emp101 set name=? where id=?");
            preparedStatement.setString(1, "hello");
            preparedStatement.setInt(2, 1);
            preparedStatement.addBatch();
            preparedStatement.setString(1, "mortal");
            preparedStatement.setInt(2, 1);
            preparedStatement.addBatch();
            int[] count = preparedStatement.executeBatch();
            System.out.println(Arrays.toString(count));
            ResultSet resultSet = statement.executeQuery("select * from emp101");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(2));
                System.out.println(resultSet.getString(1));

            }


        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
