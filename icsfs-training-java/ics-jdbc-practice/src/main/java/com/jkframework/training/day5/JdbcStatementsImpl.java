package com.jkframework.training.day5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jkframework.training.api.Students;
import com.jkframework.training.utilities.JdbcUtil;

public class JdbcStatementsImpl {
    Connection connection = null;
    Statement stmt = null;
    ResultSet rset = null;
    static Scanner scanner = new Scanner(System.in);
    JdbcUtil jdbcUtil = new JdbcUtil();

    public Students updateElement(Students students) throws Exception {
        Students student = new Students();
        try {
            System.out.println("Student Id : ");
            student.setId(scanner.nextInt());
            System.out.println("Student Id : " + student.getId());

            if (student.getId().equals(selectAllWithId(student.getId()))) {
                System.out.println("Input your Update Information : ");

                System.out.println("Student Id : ");
                students.setId(scanner.nextInt());

                System.out.println("Student Name : ");
                students.setName(scanner.next());

                System.out.println("Student Average : ");
                students.setAverage(scanner.nextInt());

                System.out.println("Student Email : ");
                students.setEmail(scanner.next());

                connection = jdbcUtil.getConnection();

                stmt = connection.createStatement();
                StringBuffer sql = new StringBuffer();
                sql.append("UPDATE ");
                sql.append("students  ");
                sql.append("SET  ");
                sql.append("id = '" + students.getId());
                sql.append("',");
                sql.append("name = '" + students.getName());
                sql.append("',");
                sql.append(" email = '" + students.getEmail());
                sql.append("',");
                sql.append(" average = " + students.getAverage());
                sql.append(" WHERE ");
                sql.append("id = " + student.getId());

                System.out.println("Update Statement ==>> " + sql.toString());

                int result = stmt.executeUpdate(sql.toString());
                if (result > 0) {
                    System.out.println("Updated successfully : " + sql);
                } else {
                    System.out.println("Update failed");
                }
                connection.close();

            } else {
                System.out.println("Student Id" + students.getId() + "is not found ... ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            try {
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) { // ignore
            }
        }
        return null;
    }

    public Students deleteElement(Students students) throws Exception {

        try {
            System.out.println("Student Id : ");
            students.setId(scanner.nextInt());
            System.err.println("record with id = " + students.getId() + " will be deleted ...");
            System.out.println();
            selectAllWithId(students.getId());

            if (students.getId().equals(selectAllWithId(students.getId()))) {

                connection = jdbcUtil.getConnection();
                stmt = connection.createStatement();
                StringBuffer sql = new StringBuffer();
                sql.append("DELETE ");
                sql.append("FROM ");
                sql.append("STUDENTS ");
                sql.append("WHERE ");
                sql.append("id = " + students.getId());

                int result = stmt.executeUpdate(sql.toString());
                if (result >= 0) {
                    System.out.println("Record Deleted Successfully ");
                } else {
                    System.out.println("Deletion Failed");
                }
                connection.close();
            } else {
                System.out.println("Student Id" + students.getId() + "is not found ... ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            try {
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) { // ignore
            }
        }
        return null;
    }

    public Students addElement(Students students) throws Exception {

        System.out.println("Student Id : ");
        students.setId(scanner.nextInt());

        System.out.println("Student Name : ");
        students.setName(scanner.next());

        System.out.println("Student Average : ");
        students.setAverage(scanner.nextInt());

        System.out.println("Student Email : ");
        students.setEmail(scanner.next());
        try {
            connection = jdbcUtil.getConnection();
            stmt = connection.createStatement();
            StringBuffer sql = new StringBuffer();
            sql.append("INSERT ");
            sql.append("INTO  ");
            sql.append("students  ");
            sql.append("( id , name , average , email) ");
            sql.append("VALUES ");
            sql.append(" ( " + students.getId() + ",'" + students.getName() + "'," + students.getAverage() + ",'"
                    + students.getEmail() + "'");
            sql.append(")");
            System.out.println("Insert Stmt " + sql.toString());

            int result = stmt.executeUpdate(sql.toString());
            if (result > 0) {
                System.out.println("inserted successfully : " + sql);
            } else {
                System.out.println("insertion failed");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            try {
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) { // ignore
            }
        }
        return null;
    }

    public Students showAll(Students students) throws Exception {
        try {
            connection = jdbcUtil.getConnection();
            stmt = connection.createStatement();
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT ");
            sql.append("id , ");
            sql.append("name ,  ");
            sql.append("average , ");
            sql.append("email ");
            sql.append("FROM ");
            sql.append("students ");

            rset = stmt.executeQuery(sql.toString());

            while (rset.next()) {
                students.setId(rset.getInt("id"));
                students.setName(rset.getString("name"));
                students.setAverage(rset.getInt("average"));
                students.setEmail(rset.getString("email"));
                System.out.println("Student Object -->> " + students);
            }

            if (students == null) {

                System.out.println("The Student Table is empty ...");
            }

            rset.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            try {
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) { // ignore
            }
        }
        return students;
    }

    public Integer selectAllWithId(Integer id) throws Exception {
        Students students = new Students();
        try {
            connection = jdbcUtil.getConnection();
            stmt = connection.createStatement();
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT ");
            sql.append("id , ");
            sql.append("name ,  ");
            sql.append("average , ");
            sql.append("email ");
            sql.append("FROM ");
            sql.append("students ");
            sql.append("WHERE ");
            sql.append("id = " + id);

            rset = stmt.executeQuery(sql.toString());

            while (rset.next()) {
                students.setId(rset.getInt("id"));
                students.setName(rset.getString("name"));
                students.setAverage(rset.getInt("average"));
                students.setEmail(rset.getString("email"));
                System.out.println("Student Record -->> " + students);
            }

            rset.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            try {
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) { // ignore
            }
        }
        return id;
    }

}
