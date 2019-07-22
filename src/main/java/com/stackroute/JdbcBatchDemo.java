package com.stackroute;
import java.sql.*;

    public class JdbcBatchDemo {

        Connection connection;
        ResultSet resultSet ;
        Statement statement;

        public void getEmployeeDetails() {

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                /*Load driver and register with DriverManager*/

                /*Use DriverManager to get Connection*/

                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "Root@123");

                connection.setAutoCommit(false);

                statement = connection.createStatement();

                String sql = "SELECT * FROM employee";

                statement.execute("delete from employee where name = 'charan'");

                for(int i=20; i <= 30 ;i++){

                    statement.addBatch("insert into employee values ("+i+",'charan',20,'m')");//adds query into batch.
                }

                int[] result = statement.executeBatch();//executes the batch of queries

                System.out.println("The number of rows inserted: "+ result.length);

                connection.commit();

                resultSet = statement.executeQuery(sql);// Returns one ResultSet object.

                while (resultSet.next()) {

                    int id = resultSet.getInt("id");
                    String age = resultSet.getString("age");
                    String name = resultSet.getString("name");
                    String gender=resultSet.getString("gender");

                    //Display values
                    System.out.println("ID: " + id+"\t name: " + name+"\t age:"+age +"\t gender:"+gender);

                }
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();

                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

