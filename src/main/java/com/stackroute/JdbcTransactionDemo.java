package com.stackroute;
import java.sql.*;
import java.util.Scanner;

    public class JdbcTransactionDemo {

        Connection connection;

        public void addEmployeeDetails() {

            String insertTableSQL = "insert into employee values(?,?,?,?)";

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                /*Load driver and register with DriverManager*/

                /*Use DriverManager to get Connection*/

                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "Root@123");

                PreparedStatement preparedStatementInsert = connection.prepareStatement(insertTableSQL);

                connection.setAutoCommit(false);

                Scanner scanner = new Scanner(System.in);

                //insert values into table
                System.out.println("Enter values to insert into table : Id, Name, Age, Gender");

                int id = scanner.nextInt();

                String name = scanner.nextLine();

                int age = scanner.nextInt();

                String gender = scanner.next();
                System.out.println("inserted...!");

                PreparedStatement preparedStatementUpdate = connection.prepareStatement("update employee set age = 27 where name = 'sam'");

                preparedStatementUpdate.executeUpdate();//Returns an integer representing the number of rows affected by the SQL statement.

                System.out.println("Updated!!!");

                preparedStatementInsert = connection.prepareStatement(insertTableSQL);
                preparedStatementInsert.setInt(1, id);
                preparedStatementInsert.setString(2, name);
                preparedStatementInsert.setInt(3, age);
                preparedStatementInsert.setString(4,gender);
                preparedStatementInsert.executeUpdate();//Returns an integer representing the number of rows affected by the SQL statement.

                connection.commit();

                System.out.println("Done!");

            } catch (SQLException | ClassNotFoundException e) {

                System.out.println(e.getMessage());

                try {
                    System.out.println("Connection Rollback done!!!!");
                    connection.rollback();

                } catch (SQLException ex) {

                    ex.printStackTrace();
                }
            }
            finally {

                try {

                    connection.close();

                }
                catch (SQLException e) {

                    e.printStackTrace();
                }
            }
        }
    }
