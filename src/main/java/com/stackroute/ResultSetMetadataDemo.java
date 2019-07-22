package com.stackroute;

import java.sql.*;

public class ResultSetMetadataDemo {

        public void getEmployeeDetails()
        {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                /*Load driver and register with DriverManager*/

                /*Use DriverManager to get Connection*/

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "Root@123");

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("select * from employee");

                while (resultSet.next()) {
                    System.out.println("Id:" + resultSet.getInt(1) + " Name:" + resultSet.getString(2) + " Age:" + resultSet.getString(3));
                }

                ResultSetMetaData rsmd = resultSet.getMetaData();


                int colCount = rsmd.getColumnCount();//Returns the number of columns in a ResultSet.

                System.out.println("Number Of Columns : " + colCount);

                System.out.println("column Details :");

                for (int i = 1; i <=colCount; i++)
                {
                    System.out.println(rsmd.getColumnName(i) + " is of type " + rsmd.getColumnTypeName(i));//Returns the column name,Returns the database specific datatype of the column.

                    System.out.println("Catalog Name:"+ rsmd.getCatalogName(i));

                    System.out.println("Column Type: "+rsmd.getColumnType(i));

                    System.out.println("Column Class Name : "+rsmd.getColumnClassName(i));
                }
            }
            catch(SQLException|ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }
