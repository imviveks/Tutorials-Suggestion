package com.suggestions.dao;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.suggestions.dao.UserDAO;
import com.suggestions.bean.*;

public class TestMain {
	
	public static final Logger logger = Logger.getLogger(TestMain.class);

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		/*UserDAO udao = new UserDAO();
		udao.getUser(2);
		logger.info(udao);
		
		Category c = new Category("abc");
		CategoryDAO cdao = new CategoryDAO();
//		cdao.addCategory(c);
		cdao.getCategory(103);
		cdao.getCategories();
		logger.info(cdao);
		*/
		
		ProductType pt = new ProductType("mali");
		ProductTypeDAO ptdao = new ProductTypeDAO();
		ptdao.addProductType(pt);
		ptdao.getProductType(1002);
		ptdao.getProductTypes();
		logger.info(ptdao);
		
	}

}

/*
import java.sql.SQLException;

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		ProductTypeDAO ptdao=new ProductTypeDAO();
		
			ptdao.getProductType(1002);
		
			logger.info(ptdao);
		
		
	}
}*/