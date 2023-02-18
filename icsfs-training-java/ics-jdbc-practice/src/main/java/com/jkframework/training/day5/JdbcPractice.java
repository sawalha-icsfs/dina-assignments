package com.jkframework.training.day5;

import java.util.Scanner;

import com.jkframework.training.api.Students;
import com.jkframework.training.utilities.JdbcUtil;

public class JdbcPractice {
    static Scanner scanner = new Scanner(System.in);
    static JdbcUtil jdbcUtil = new JdbcUtil();

    public static void main(String[] args) throws Exception {

        JdbcStatementsImpl statementsImpl = new JdbcStatementsImpl();
        Students students = new Students();

        String[] options = { "==========================", "|  1-  Add Student        |", "|  2-  Update Student     |",
                "|  3-  Delete Student     |", "|  4-  Show All Students  |", "|  5- Quit                |",
                "==========================" };

        int option = 1;

        while (option != 5) {
            JdbcUtil.printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                case 1:
                    try {
                        statementsImpl.addElement(students);
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case 2:
                    try {
                        statementsImpl.updateElement(students);
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case 3:
                    try {
                        statementsImpl.deleteElement(students);
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case 4:
                    try {
                        statementsImpl.showAll(students);
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case 5:
                    System.out.println("exit selection");
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Please enter an integer value between 1 and " + (options.length - 2));
                scanner.next();
            }
        }

    }

}
