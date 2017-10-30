package com.suggestions.services;

import com.suggestions.bean.Category;

/**
 * This is the category service interface
 * @author User
 *
 */
public interface CategoryService {
	
	public  void addCategory(Category category);
	public void getCategory(int categoryId) ;
	

}
