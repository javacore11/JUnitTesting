package com.jdbc.example.resultset;

import java.sql.*;

public class SensitiveResultSet {
    static final String url = "jdbc:mysql://localhost:3306/junit";
    static final String pass = "root";
    static final String user = "root";

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, pass);
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        System.out.println("Support Hold Cursor Holdability" + databaseMetaData.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT));
        boolean b = databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);
        System.out.println(b);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        Statement statement1 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.setFetchSize(1);
        MyThread1 thread1 = new MyThread1(statement, statement1);
        thread1.start();


    }
}

class MyThread1 extends Thread {
    Statement statement;
    Statement statement1;
    ResultSet resultSet;

    MyThread1(Statement statement, Statement statement1) {
        this.statement = statement;
        this.statement1 = statement1;
    }

    @Override
    public void run() {
        try {
            resultSet = statement.executeQuery("Select * from result");
            while (resultSet.next()) {
                System.out.println("Id " + resultSet.getInt(1));
                System.out.println("Name " + resultSet.getString(2));
                System.out.println("Last" + resultSet.getString(3));
            }
            MyThread2 myThread2 = new MyThread2(statement1);
            myThread2.start();
            try {
                myThread2.join();
            } catch (Exception exception) {
                exception.printStackTrace();

            }
            resultSet.beforeFirst();
            System.out.println("After Changes ");
            while (resultSet.next()) {
                System.out.println("Id " + resultSet.getInt(1));
                System.out.println("Name " + resultSet.getString(2));
                System.out.println("Last" + resultSet.getString(3));
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

class MyThread2 extends Thread {
    Statement statement;

    MyThread2(Statement statement) {
        this.statement = statement;

    }

    @Override
    public void run() {
        try {
            statement.executeUpdate("update result set lastname ='hello' where id =0");
            statement.executeUpdate("commit");
            statement.close();
            System.out.println("Record Updated ");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
