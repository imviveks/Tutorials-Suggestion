package com.suggestions.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author vivek saurabh
 */
public class SqlServerJDBCConnection {

/**
     * @param args the command line arguments
     */
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection conn =DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLExpress;database=SuggestionDB;integratedSecurity=true;"
            Connection conn =DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=SuggestionDB;user=suggestiondb;password=admin"
            	  );//"jdbc:sqlserver://localhost:1433;databaseName=SuggestionDB;user=sa;password=admin;");
                   
                    
                    
            System.out.println("connected");
            Statement statement=conn.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT TOP 10 [adminId],[adminName],[adminPassword] FROM [SuggestionDB].[dbo].[Admin]");
            while(resultSet.next()){
                System.out.println(" "+resultSet.getInt(1)+"    "+resultSet.getString(2)+"    "+resultSet.getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

