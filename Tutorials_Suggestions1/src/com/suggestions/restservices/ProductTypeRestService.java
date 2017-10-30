package com.suggestions.restservices;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.suggestions.bean.ProductType;
import com.suggestions.dao.ProductTypeDAO;
import com.suggetions.entity.ProductTypeEO;


@Path("/producttype")
public class ProductTypeRestService {
	
	ProductTypeEO producttype=new ProductTypeEO();
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public static ArrayList<ProductType> getAllCategory() throws SQLException {
		return ProductTypeEO.getAllCategory();
	}

	
	
}
