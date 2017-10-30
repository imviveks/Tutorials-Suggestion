package com.suggetions.entity;

import java.sql.SQLException;
import java.util.ArrayList;

import com.suggestions.bean.Category;
import com.suggestions.dao.CategoryDAO;

/**
 * This is the Category Entity Class
 * this class implements the category service operations
 * @author User
 *
 */
public class CategoryEO {

	private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(String categoryName) {
		category = new Category();
		category.setCategoryName(categoryName);
		
	}

	public void addCategory() throws SQLException
	{
		CategoryDAO.addCategory(category);
	}

	public static ArrayList<Category> getAllCategory() throws SQLException {
		
		return CategoryDAO.getCategories();
	}
}
