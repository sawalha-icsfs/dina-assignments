package com.jkframework.training.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {

    public Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/testdatabase?useSSL=false";
        String user = "test";
        String password = "test623";
        try {

            Connection connection = DriverManager.getConnection(url, user, password);

            return connection;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Please Enter your Choice : ");
    }
}
