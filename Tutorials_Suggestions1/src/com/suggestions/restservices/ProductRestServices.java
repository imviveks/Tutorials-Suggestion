package com.suggestions.restservices;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.suggestions.bean.Product;
import com.suggestions.dao.ProductDAO;
import com.suggetions.entity.ProductEO;

@Path("/product")
public class ProductRestServices {
	
	ProductEO prodEO= new ProductEO();

	@GET

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public  ArrayList<Product> getAllProducts() throws SQLException
	{
		return ProductEO.getAllProducts();
	}
	
	@GET
	@Path("{cid}/{ptid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static ArrayList<Product> getProductsByCategoryAndProductType(@PathParam("cid")int categoryId, @PathParam("ptid") int ProductTypeId) throws SQLException
	{
		return ProductEO.getProductsByCategoryAndProductType(categoryId, ProductTypeId);
	}
	
	


	

}
