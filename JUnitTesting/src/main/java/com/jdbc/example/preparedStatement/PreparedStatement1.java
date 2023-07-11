package com.jdbc.example.preparedStatement;

import java.sql.*;

public class PreparedStatement1 {
    static final String url = "jdbc:mysql://localhost:3306/junit";
    static final String pass = "root";
    static final String user = "root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "CREATE TABLE prepare (\n" +
                    "    ID int NOT NULL,\n" +
                    "    name varchar(255) NOT NULL,\n" +
                    "    PRIMARY KEY (ID)\n" +
                    ");";
            //statement.executeUpdate(sql);
            statement.close();
            String str="Hii";
            PreparedStatement preparedStatement = connection.prepareStatement("insert into prepare (?,?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, str);
            preparedStatement.execute();
            System.out.println("Prepared Statement Executed ");
            preparedStatement = connection.prepareStatement("select * from prepare where id=?");
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
