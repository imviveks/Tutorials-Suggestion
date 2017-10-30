package com.suggestions.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.suggestions.bean.Product;
import com.suggetions.entity.CategoryEO;
import com.suggetions.entity.ProductEO;
import com.suggetions.entity.ProductTypeEO;

public class ProcessHandlingService {

	public static void processInputsForAdminUser(HttpServletRequest request) throws SQLException {
		// TODO Auto-generated method stub
		
		
		// get input parameters
		//String action = request.getParameter("action");
		String categoryName = request.getParameter("categoryName");
		String productTypeName = request.getParameter("productTypeName");
		String productName = request.getParameter("productName");
		
		// call DAO related CRUD
		// Add
		if(categoryName != null && !categoryName.equals(""))
		{
			CategoryEO categoryEO = new CategoryEO();
			categoryEO.setCategory(categoryName);
			categoryEO.addCategory();
		}
		
		if(productTypeName != null && !productTypeName.equals(""))
		{
			ProductTypeEO productTypeEO = new ProductTypeEO();
			productTypeEO.setProductType(productTypeName);
			productTypeEO.addProductType();
		}
		
		if(productName != null && !productName.equals(""))
		{
			String categoryId = request.getParameter("categoryId");
			String productTypeId = request.getParameter("productTypeId");
			
			ProductEO  productEO = new ProductEO();
			productEO.setProduct(productName, Integer.parseInt(categoryId), Integer.parseInt(productTypeId));
			productEO.addProduct();
			
		}
		
		// Update
		
		//Delete
		
		//Select
		
		
		
		// send result to the user back
	}

	public static void processInputsForNormalUser(HttpServletRequest request,HttpServletResponse response,PrintWriter out ) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// get input parameters
		 HttpSession session = request.getSession();
		 String userName = (String) session.getAttribute("loginUserID");
		String categoryId = request.getParameter("categoryId");
		String ProductTypeId = request.getParameter("productTypeId");
		
		ArrayList<Product> productList;
		try {
			productList = ProductEO.getProductsByCategoryAndProductType(Integer.parseInt(categoryId), Integer.parseInt(ProductTypeId));
			request.setAttribute("productList", productList);
			
			String html = "<table>";
			for(int i = 0; i < productList.size(); i+=1) 
			{
				html+="<tr>"+      
						  "<td>"+productList.get(i).getProductName()+"</td> "
					 + "</tr>";
			}
			html+="</table>";
			out.write(html);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Cookie cookieToBeSet = new Cookie(getCookieName(userName), categoryId+"#"+ProductTypeId);
		response.addCookie(cookieToBeSet);
		// send result to the user back
	}

	private static String getCookieName(String userName) {
		
		return "SUGGESTION_PROJECT_"+userName;
	}

}
