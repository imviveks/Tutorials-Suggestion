package com.suggestions.bean;

/**
 * This is the bean class for the Product Type
 * This class contains the constructors and the setter and getter method for the ProductType
 * @author User
 *
 */
public class ProductType {
	
	private int productTypeId; 
	private String productTypeName;
	public int getProductTypeId() {
		return productTypeId;
	}
	
	
	//No param constructor
	public ProductType() {
		super(); 
	}


	//parameterized constructor
	public ProductType(int productTypeId, String productTypeName) {
		super();
		this.productTypeId = productTypeId;
		this.productTypeName = productTypeName;
	}


	//parameterized constructor
		public ProductType(String productTypeName) {
			super();
			this.productTypeName = productTypeName;
		}
	
		
	//setter and getter method
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	
	

}//end class productType
