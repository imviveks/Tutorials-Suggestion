package com.suggestions.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.suggestions.database.JDBCConnection;

public class LoginDAO {

	public static final Logger logger = Logger.getLogger(JDBCConnection.class);
	private static PreparedStatement preparedStatement;  //preparedStatement for query
	private static Connection connection = JDBCConnection.getConnection(); //connection object for getting connection
	private static ResultSet resultSet;  //to display updated result
	private static Statement statement;  //to execute query
	
	public static boolean validate(String userName,String userPassword){  
		boolean status=false;  
		try{  
		      
		preparedStatement =connection.prepareStatement(  
		"select * from User where userName=? and userPassword=?");  
		preparedStatement.setString(1,userName);  
		preparedStatement.setString(2,userPassword);  
		      
		resultSet =preparedStatement.executeQuery();  
		
		status=resultSet.next();  
		// System.out.println(status);         
		}catch(Exception e){
			logger.error(e);;
			}  
		return status;  
		
	
		}  
		}  

