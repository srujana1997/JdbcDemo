package com.stackroute;

import java.sql.*;

public class DatabaseMetadataDemo {
    public static void getMetaData(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            /*Load driver and register with DriverManager*/
            /*Use DriverManager to get Connection*/
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/empdb","root","Root@123");
            DatabaseMetaData dbmd=con.getMetaData();

            System.out.println("Driver Name: "+dbmd.getDriverName());//returns the name of the JDBC driver

            System.out.println("Driver Version: "+dbmd.getDriverVersion());// returns the version number of the JDBC driver

            System.out.println("UserName: "+dbmd.getUserName());//returns the username of the database

            System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());//returns the product name of the database

            System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());//returns the product version of the database.


            con.close();
        }catch(Exception e){
            System.out.println(e);}
    }
}
