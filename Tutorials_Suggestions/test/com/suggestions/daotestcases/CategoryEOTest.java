package com.suggestions.daotestcases;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.suggestions.bean.Category;
import com.suggestions.bean.User;
import com.suggetions.entity.CategoryEO;
import com.suggetions.entity.UserEO;

public class CategoryEOTest {
	
//	public static final Logger logger = new Logger(CategoryEO.class);
	
	CategoryEO categoryEo = new CategoryEO();
	Category category1 = new Category();

	@Test
	public void testGetCategory() {
		
		category1 =categoryEo.getCategory();
		assertNotNull(category1);
		
	}

	@Test
	public void testAddCategory() {
		
//		category1.setCategoryName("PHP");
//		assertNotNull(categoryEo.addCategory(category1));
		
	}

	@Test
	public void testGetAllCategory() {
		fail("Not yet implemented");
	}

}
