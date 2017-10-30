package com.suggestions.bean;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * this is the bean class for the Category
 * It contains the constructors and the setter and getter functions
 * @author User
 *
 */

@XmlRootElement
public class Category {
	
	private int categoryId; //id of the category or artifacts(pdf,ppt,doc)
	private String categoryName; //name of the category
	
	
	//No param Constructor
	public Category() {
		super();
	}

	// parameterized constructor with category id and name as parameter
	public Category(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	// parameterized constructor with category name as parameter
	public Category(String categoryName)
	{
		super();
		this.categoryName = categoryName;
	}
	

	//setter and getter method 
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	

}//end class Category
