package com.suggestions.bean;

public class Product {
	
	private int productId; //id of the product
	private String productName; //name of the product
	private int categoryId; // category of the product
	private int ProductTypeId; // product type of the product
	
	//No param Constructor
	public Product() {
		super();
	}

	public Product(int productId, String productName, int categoryId,
			int productTypeId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		ProductTypeId = productTypeId;
	}
	
	public Product(String productName, int categoryId,
			int productTypeId) {
		super();
		this.productName = productName;
		this.categoryId = categoryId;
		ProductTypeId = productTypeId;
	}

	public Product(String productName2) {
		this.productName = productName2;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getProductTypeId() {
		return ProductTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		ProductTypeId = productTypeId;
	}
	
	
	
	

}//end class Product
