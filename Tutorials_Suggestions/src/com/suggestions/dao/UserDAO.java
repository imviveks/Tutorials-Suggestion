package com.suggestions.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.suggestions.database.JDBCConnection;
import com.suggestions.bean.User;

/**
 * This is the user DAO class
 * this class contains the CRUD operations performed on the User Table Data 
 * @author User
 *
 */

	public class UserDAO
	{
		public static final Logger logger = Logger.getLogger(JDBCConnection.class);
		private static PreparedStatement preparedStatement;  //preparedStatement for query
		private static Connection connection = JDBCConnection.getConnection(); //connection object for getting connection
		private static ResultSet resultSet;  //to display updated result
		private static Statement statement;  //to execute query
		
		private static String selectQuery = "select * from [SuggestionDB].[dbo].[user] where userId=?";
						
		/**
		 * This method extracts updated resulSet or table from
		 * database.
		 * @return resultSet
		 * @throws SQLException
		 */
		public static ResultSet getResultSet() throws SQLException
		{
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectQuery);
			
			return resultSet;
		}//method ends here
		
		
		/**
		 * This method accepts user id as argument and returns one user object
		 * @param userid
		 * @return Users object
		 * @throws SQLException
		 */
		public static User getUser(int userId)
		{
			User user=null;
			try{
				PreparedStatement statement = connection.prepareStatement(selectQuery);
				statement.setInt(1, userId);
				ResultSet resultset = statement.executeQuery();
				while (resultset.next()) {
					String userName = resultset.getString(2);
					String userPassword = resultset.getString(3);
	
//					logger.info(userName);
//					logger.info(userPassword);
					user= new User(userName, userPassword);
				}
			}catch(SQLException e)
			{
				logger.error(e);
			}
			logger.info(user);
			return user;
		}//method ends here
				
		
		/**
		 * This method is returns List of all users 
		 * @return List of Users
		 * @throws SQLException
		 */
		public static List<User> getUsers() throws SQLException
		{
			List<User> listOfUsers = new ArrayList<User>();
			resultSet = getResultSet();
			User user = null;
			
			while(resultSet.next())
			{
				user = new User();
				user.setUserId(resultSet.getInt("userId"));
				user.setUserName(resultSet.getString("userName"));
				user.setUserPassword(resultSet.getString("userPassword"));
			
				
				listOfUsers.add(user);
			}//while ends here
			return listOfUsers;
		}//method ends here
			
	}
