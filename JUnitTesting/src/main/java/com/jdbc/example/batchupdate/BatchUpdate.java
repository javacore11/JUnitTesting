package com.jdbc.example.batchupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class BatchUpdate {
    static final String url = "jdbc:mysql://localhost:3306/junit";
    static final String pass = "root";
    static final String user = "root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            String sql = "update result set lastname='yuhigh' where id=0";
            String sql1 = "insert into result values(8,'huu','kk') ";
            String sql2 = "delete from result where id=6";
            statement.addBatch(sql);
            statement.addBatch(sql1);
            statement.addBatch(sql2);
            statement.executeBatch();
            ResultSet resultSet = statement.executeQuery("select * from result");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
