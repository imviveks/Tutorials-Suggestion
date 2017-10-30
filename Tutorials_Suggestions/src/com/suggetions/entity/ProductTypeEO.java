package com.suggetions.entity;

import java.sql.SQLException;
import java.util.ArrayList;

import com.suggestions.bean.ProductType;
import com.suggestions.dao.ProductTypeDAO;

/**
 * This is the product type entity class
 * this class implements product type's service operation
 * @author User
 *
 */
public class ProductTypeEO {

	private ProductType productType;

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(String productTypeName) {
		productType = new ProductType(productTypeName);
	}
	
	
	public void addProductType() throws SQLException
	{
		ProductTypeDAO.addProductType(productType);
	}

	public static ArrayList<ProductType> getAllCategory() throws SQLException {
		return ProductTypeDAO.getProductTypes();
	}
	
}
