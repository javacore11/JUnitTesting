package com.jdbc.example.preparedStatement;

import java.sql.*;

public class PreparedStatement2 {
    final static String url = "jdbc:mysql://localhost:3306/junit";
    final static String user = "root";
    final static String pass = "root";

    public static void main(String[] args) {
        try {
            String str = "Hi";
            int id = 1;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            statement.executeUpdate("create table emp101(name varchar(255),id int)");
            statement.close();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into emp101 values(?,?)");
            preparedStatement.setString(1, str);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            preparedStatement.close();
            preparedStatement = connection.prepareStatement("select * from emp101 where id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getInt(2));
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
