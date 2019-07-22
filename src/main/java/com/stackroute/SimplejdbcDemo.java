package com.stackroute;

import java.sql.*;

public class SimplejdbcDemo {

    private Connection connection;

    private Statement statement;

    private ResultSet resultSet;

    public void getEmployeeDetails() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            /*Load driver and register with DriverManager*/

            /*Use DriverManager to get Connection*/
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "Root@123");

            statement = connection.createStatement();

            resultSet = statement.executeQuery("Select * from employee");

            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + "\tName: " + resultSet.getString(2) + "\tage: " + resultSet.getString(3) + "\tgender: " + resultSet.getString(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            /*Load driver and register with DriverManager*/

            /*Use DriverManager to get Connection*/
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "Root@123");

            statement = connection.createStatement();

            resultSet = statement.executeQuery("Select * from employee");
            resultSet.afterLast();

            while (resultSet.previous()) {
                System.out.println("Id: " + resultSet.getInt(1) + " \tName: " + resultSet.getString(2) + "\tage: " + resultSet.getString(3) + "\tgender: " + resultSet.getString(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }


    //Move ResultSet to second row and print in reverse order
    public void getEmployeeDetailsFromSecondRowInReverse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)

        {

            resultSet.absolute(2);
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " \tName: " + resultSet.getString(2) + "\tage: " + resultSet.getString(3) + "\tgender: " + resultSet.getString(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


   // Use PreparedStatement to display by name and gender

   public void getEmployeeDetailsByNameAndGender(String name,String gender) {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }

       try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "Root@123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from employee where name='"+name+"' and gender='"+gender+"'");)
       {

           while (resultSet.next()) {
               System.out.println( "Name: " + resultSet.getString(2) + "\tgender: " + resultSet.getString(4));
           }


       } catch (SQLException e) {
           e.printStackTrace();
       } catch (Exception ex) {
           ex.printStackTrace();
       }


    }
}