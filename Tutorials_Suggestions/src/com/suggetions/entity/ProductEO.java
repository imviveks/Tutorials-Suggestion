package com.suggetions.entity;

import java.sql.SQLException;
import java.util.ArrayList;

import com.suggestions.bean.Product;
import com.suggestions.dao.ProductDAO;

public class ProductEO {

	private Product product;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(String productName, int categoryId,int productTypeId) {
		this.product = new Product(productName, categoryId, productTypeId);
	}

	public void addProduct() throws SQLException
	{
		ProductDAO.addProducts(product);
	}
	
	public static ArrayList<Product> getProductsByCategoryAndProductType(int categoryId, int ProductTypeId) throws SQLException
	{
		return ProductDAO.getProductsByCategoryAndProductType(categoryId, ProductTypeId);
	}
	
	public static ArrayList<Product> getAllProducts() throws SQLException
	{
		return ProductDAO.getProducts();
	}
}
