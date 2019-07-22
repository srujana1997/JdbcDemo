package com.stackroute;
import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
public class RowSetDemo {


        private Connection connection;

        public void getEmployeeDetails()
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                /*Load driver and register with DriverManager*/

                /*Use DriverManager to get Connection*/
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "Root@123");
                JdbcRowSet jdbcRowSet = new JdbcRowSetImpl(connection);
                jdbcRowSet.setCommand("select * from employee"); // set properties, and
                jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/empdb"); // connect to database
                jdbcRowSet.setUsername("root");
                jdbcRowSet.setPassword("Root@123");
                jdbcRowSet.execute(); // populate with data

                while (jdbcRowSet.next())
                {
                    System.out.println(" "+ jdbcRowSet.getInt(1) + " " + jdbcRowSet.getString(2) + " " + jdbcRowSet.getString(3) + " " + jdbcRowSet.getString(4));
                }
            }
            catch (ClassNotFoundException| SQLException e) {

                e.printStackTrace();
            }
            finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}
