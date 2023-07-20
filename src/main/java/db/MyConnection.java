package db;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MyConnection {
    public static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filevault?useSSL=false", "root", "root");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connection Success");
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        MyConnection.getConnection();
//    }
}
