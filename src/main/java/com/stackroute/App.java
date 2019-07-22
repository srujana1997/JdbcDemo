package com.stackroute;
public class App
    {
        public static void main(String args[])
        {
            //SimplejdbcDemo
            SimplejdbcDemo simpleJdbcDemo = new SimplejdbcDemo();
            System.out.println("Simple jdbc demo");
            System.out.println("General Order");
            simpleJdbcDemo.getEmployeeDetails();

            System.out.println("Reverse Order");
            simpleJdbcDemo.getEmployeeDetailsInReverse();

            System.out.println("From Second Row");
            simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();

            System.out.println("getEmployeeDetailsByNameAndGender");
            simpleJdbcDemo.getEmployeeDetailsByNameAndGender("ram", "m");

            //Resultsetmetadata Demo
            System.out.println("Result Set Meta Data");
            ResultSetMetadataDemo resultSetMetadataDemo = new ResultSetMetadataDemo();
            resultSetMetadataDemo.getEmployeeDetails();

            //JdbctransactionDemo
            System.out.println("Jdbc Transaction demo");
            JdbcTransactionDemo jdbcTransactionDemo = new JdbcTransactionDemo();
            jdbcTransactionDemo.addEmployeeDetails();

            //JdbcBatchDemo
            System.out.println("Jdbc Batch demo");
            JdbcBatchDemo jdbcBatchDemo = new JdbcBatchDemo();
            jdbcBatchDemo.getEmployeeDetails();

            //DatabaseMetadatDemo
            System.out.println("Database MetaData demo");
            DatabaseMetadataDemo databaseMetaDataDemo = new DatabaseMetadataDemo();
            databaseMetaDataDemo.getMetaData();

            //RowsetDemo
            System.out.println("Rowset demo");
            RowSetDemo rowsetDemo = new RowSetDemo();
            rowsetDemo.getEmployeeDetails();
        }
    }
