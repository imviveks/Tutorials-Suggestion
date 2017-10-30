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

import com.suggestions.bean.Category;
import com.suggestions.database.JDBCConnection;

/**
 * This is the category DAO class
 * this class contains the CRUD operations performed on the Category Table Data
 * @author User
 *
 */

public class CategoryDAO {
	
	public static final Logger logger = Logger.getLogger(JDBCConnection.class);
	private static PreparedStatement preparedStatement;  //preparedStatement for query
    private static Connection connection = JDBCConnection.getConnection(); //connection object for getting connection
	private static ResultSet resultSet;  //to display updated result
	private static Statement statement;  //to execute query
	
	private static final String addQuery = "INSERT INTO [SuggestionDB].[dbo].[Category] ([categoryName]) values(?)";
	private static final String deleteQuery = "DELETE FROM [SuggestionDB].[dbo].[Category] WHERE categoryId = ?";
	private static final String selectQuery = "SELECT * FROM [SuggestionDB].[dbo].[Category]";
	private static final String selectOneQuery = "SELECT * FROM [SuggestionDB].[dbo].[Category] where categoryId = ?";
	
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
	 * This method is used to Add Category
	 * @param category
	 * @throws SQLException
	 */
	
	public static void addCategory(Category category) throws SQLException
	{
		preparedStatement = connection.prepareStatement(addQuery);
//		preparedStatement.setInt(1, category.getCategoryId());
		preparedStatement.setString(1, category.getCategoryName());
		
		int result = preparedStatement.executeUpdate();
		if(result > 0)
			logger.info("Row Updated");
		else
			logger.info("No row updated");
	}//method ends here

	
	/**
	 * This method returns a particular category based on the given Category Id
	 * @param categoryId
	 * @return
	 */
	public static Category getCategory(int categoryId) 
	{
		Category category=null;
		try{
			PreparedStatement statement = connection.prepareStatement(selectOneQuery);
			statement.setInt(1, categoryId);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				String categoryName = resultset.getString(2);
				
				logger.info(categoryName);
				category= new Category(categoryName);
			}
		}catch(SQLException e)
		{
			logger.error(e);
		}
		logger.info(category);
		return category;
	}//method ends here
	
	
	/**
	 * this method return the list of the categories in the database
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Category> getCategories() throws SQLException
	{
		Category category= null;
		ArrayList<Category> listOfCategories = new ArrayList<Category>();
		resultSet = getResultSet();
		try {

			while (resultSet.next()) {
				category = new Category();
      			int categoryId = resultSet.getInt(1);
				String categoryName = resultSet.getString(2);
				
				category.setCategoryId(categoryId);
				category.setCategoryName(categoryName);
				
				listOfCategories.add(category);
				
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		logger.info(listOfCategories);
		return listOfCategories;	
	}//method ends here
	
	
	/**
	 * This method is used to delete the given Category
	 * @param categoryId
	 * @throws SQLException
	 */
	public static void deleteCategory(int categoryId) throws SQLException
	{
		preparedStatement = connection.prepareStatement(deleteQuery);
		preparedStatement.setInt(1, categoryId);
		
		preparedStatement.executeUpdate();
	}//method ends here
	
}
