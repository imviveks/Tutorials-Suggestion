package com.suggestions.restservices;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.suggestions.bean.Category;
import com.suggestions.dao.CategoryDAO;
import com.suggetions.entity.CategoryEO;


@Path("/category")
public class CategoryRestService {

	CategoryEO categoryEntity=new CategoryEO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static ArrayList<Category> getAllCategory() throws SQLException {
		
		return CategoryEO.getAllCategory();
	}

}
