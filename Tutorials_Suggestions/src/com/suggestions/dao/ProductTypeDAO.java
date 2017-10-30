package com.suggestions.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.suggestions.bean.ProductType;
import com.suggestions.database.JDBCConnection;

/**
 * This is the product type DAO class
 * this class contains the CRUD operations performed on the Product Type Table Data
 * @author User
 *
 */
public class ProductTypeDAO {
	public static final Logger logger = Logger.getLogger(JDBCConnection.class);
	private static PreparedStatement preparedStatement;  //preparedStatement for query
	private static Connection connection = JDBCConnection.getConnection(); //connection object for getting connection
	private static ResultSet resultSet;  //to display updated result
	private static Statement statement;  //to execute query
	
	
	private static String addQuery="INSERT INTO [SuggestionDB].[dbo].[ProductType] ([productTypeName]) values(?)";
	private static String deleteQuery="DELETE FROM [SuggestionDB].[dbo].[ProductType] WHERE productTypeId = ?";
	private static String selectQuery="SELECT * FROM [SuggestionDB].[dbo].[ProductType]";
	private static String selectOneQuery="SELECT * FROM [SuggestionDB].[dbo].[ProductType] where productTypeId = ?";
	
	

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
	 * This method add one product type to table
	 * @param productType object
	 * @throws SQLException
	 */
	public static ProductType addProductType(ProductType producttype) throws SQLException
	{
		preparedStatement = connection.prepareStatement(addQuery);
//		preparedStatement.setInt(1,producttype.getProductTypeId());
		preparedStatement.setString(1, producttype.getProductTypeName());
		
		preparedStatement.executeUpdate();
		return producttype;
	}//method ends here
	
	/**
	 * This method accepts productTypeId as argument and delete one product
	 * @param 
	 * @throws SQLException
	 * not implemented
	 */
	public static void deleteProductType(int productTypeId) throws SQLException
	{
		preparedStatement = connection.prepareStatement(deleteQuery);
		preparedStatement.setInt(1, productTypeId);
		
		preparedStatement.executeUpdate();
	}//method ends here
	

	/**
	 * This method accepts productTypeId as argument and returns one product type object
	 * @param ProductTypeId
	 * @return ProductType object
	 * @throws SQLException
	 */
	public ProductType getProductType(int productTypeId) throws SQLException
	{
		ProductType productType=null;
		try{
			PreparedStatement statement = connection.prepareStatement(selectOneQuery);
			statement.setInt(1, productTypeId);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				String productTypeName = resultset.getString(2);
				
				logger.info(productTypeName);
				productType= new ProductType(productTypeName);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		logger.info(productType);
	return productType;
	}
			
	/**
	 * This method is returns List of all product types
	 * @return List of ProductTYpe
	 * @throws SQLException
	 */
	public static ArrayList<ProductType> getProductTypes() throws SQLException
	{
		ArrayList<ProductType> listOfProductTypes = new ArrayList<ProductType>();
		resultSet = getResultSet();
		ProductType producttype = null;
		try{
			while(resultSet.next()){
				producttype = new ProductType();
				producttype.setProductTypeId(resultSet.getInt(1));
				String productTypeName = resultSet.getString(2);
				
				producttype.setProductTypeName(productTypeName);
				listOfProductTypes.add(producttype);
			}
		}catch(Exception e)
		{
			logger.error(e);
		}
		logger.info(listOfProductTypes);
		return listOfProductTypes;
	}//method ends here
	
}// class ends here
