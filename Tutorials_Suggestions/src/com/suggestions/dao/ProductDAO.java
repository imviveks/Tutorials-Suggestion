package com.suggestions.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.suggestions.database.JDBCConnection;
import com.suggestions.bean.Category;
import com.suggestions.bean.Product;

/**
 * This is a product DAO class
 * this class contains the CRUD operations performed on the Product Table Data
 * @author User
 *
 */

public class ProductDAO {
	
	private static PreparedStatement preparedStatement;  //preparedStatement for query
    private static Connection connection = JDBCConnection.getConnection(); //connection object for getting connection
	private static ResultSet resultSet;  //to display updated result
	private static Statement statement;  //to execute query
	
	private static final String addQuery = "INSERT INTO Product (productName,categoryId,productTypeId) values(?,?,?)";
	private static final String deleteQuery = "DELETE FROM Product WHERE productId = ?";
	private static final String selectQuery = "SELECT * FROM Product";
	private static final String selectOneQuery = "SELECT * FROM Product WHERE productId = ?";
	private static final String selectQueryByCategory = "SELECT * FROM Product WHERE categoryId = ?";
	private static final String selectQueryByProductType = "SELECT * FROM Product WHERE productTypeId = ?";
//	private static final String deleteQueryByCategory = "DELETE FROM Product WHERE categoryId = ?";
//	private static final String deleteQueryByProductType = "DELETE FROM Product WHERE productTypeId = ?";
	
	
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
	 * This method is used to add products to the product table
	 * @param product
	 * @throws SQLException
	 */
	public static void addProducts(Product product) throws SQLException
	{
		preparedStatement = connection.prepareStatement(addQuery);
//		preparedStatement.setInt(1, product.getProductId());
		preparedStatement.setString(1, product.getProductName());
		preparedStatement.setInt(2, product.getCategoryId());
		preparedStatement.setInt(3, product.getProductTypeId());
		
		preparedStatement.executeUpdate();
	}//method ends here
	
	
	/**
	 * this method takes product Id as the parameter and returns product associated
	 * @param productId
	 * @return
	 * @throws SQLException
	 */
	public static Product getProduct(int productId) throws SQLException
	{
		Product product = null;
		Logger logger = null;;
		try{
			PreparedStatement statement = connection.prepareStatement(selectOneQuery);
			statement.setInt(1, productId);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				String productName = resultset.getString(2);
				
				logger .info(productName);
				product= new Product(productName);
			}
		}catch(SQLException e)
		{
			logger.error(e);
		}
		
		return product;
		
	}//method ends here
	

	/**
	 * this method is used to get the list of all products in the database
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Product> getProducts() throws SQLException
	{
		ArrayList<Product> listOfProducts = new ArrayList<Product>();
		resultSet = getResultSet();
		Product product = null;
		
		while(resultSet.next())
		{
			product = new Product();

			product.setProductId(resultSet.getInt(1));
			product.setProductName(resultSet.getString(2));
			product.setCategoryId(resultSet.getInt(3));
			product.setProductTypeId(resultSet.getInt(4));
		
			
			listOfProducts.add(product);
		}//while ends here
		return listOfProducts;
	}//method ends here
	
	
	/**
	 * This method is used to fetch all the products on the basis of particular category id and the product type id 
	 */
	public static ArrayList<Product> getProductsByCategoryAndProductType(int categoryId, int ProductTypeId) throws SQLException
	{
		ArrayList<Product> listOfProducts = new ArrayList<Product>();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE categoryId = ? AND productTypeId = ?");
		statement.setInt(1, categoryId);
		statement.setInt(2, ProductTypeId);
		
		ResultSet resultSet = statement.executeQuery();
		Product product = null;
		
		while(resultSet.next())
		{
			product = new Product();

			product.setProductId(resultSet.getInt(1));
			product.setProductName(resultSet.getString(2));
			product.setCategoryId(resultSet.getInt(3));
			product.setProductTypeId(resultSet.getInt(4));
		
			
			listOfProducts.add(product);
		}//while ends here
		return listOfProducts;
	}//method ends here
	
	/**
	 * This method is used to delete product on basis of product type id
	 * @param productTypeId
	 * @throws SQLException
	 */
	public static void deleteProductByProductTypeId(int productTypeId) throws SQLException
	{
		preparedStatement = connection.prepareStatement(deleteQuery);
		preparedStatement.setInt(1, productTypeId);
		
		preparedStatement.executeUpdate();
	}//method ends here
	
	/**
	 * This method is used to delete products on the basis of category id
	 * @param categoryId
	 * @throws SQLException
	 */
	public static void deleteProductByCategoryId(int categoryId) throws SQLException
	{
		preparedStatement = connection.prepareStatement(deleteQuery);
		preparedStatement.setInt(1, categoryId);
		
		preparedStatement.executeUpdate();
	}//method ends here
	
	
}
