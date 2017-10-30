package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;

import com.suggestions.bean.Product;
import com.suggestions.bean.ProductType;
import com.suggestions.bean.User;
import com.suggestions.dao.UserDAO;
import com.suggestions.database.JDBCConnection;
import com.suggetions.entity.CategoryEO;
import com.suggetions.entity.ProductEO;
import com.suggetions.entity.ProductTypeEO;

/**
 * Servlet implementation class UserLoginController1
 */
@WebServlet("/UserLoginController1")
public class UserLoginController1 extends HttpServlet {
	Logger logger=Logger.getLogger(UserLoginController1.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in user login controller");
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String userName = request.getParameter("userid");
		    String userPassword = request.getParameter("userPassword");
		    HttpSession session = request.getSession();
		    session.setAttribute("loginUserID", userName);
		    logger.info(userName + " " + userPassword); 
	//	    JDBCConnection con=new JDBCConnection();
	//	   Connection con1= con.getConnection();
		   int i= Integer.parseInt(userName);
		   
		   User u = UserDAO.getUser(i);
		      String username1=u.getUserName();
		      String userpass=u.getUserPassword();
				 if(userPassword.equals(userpass))
				 { 
					 ArrayList<com.suggestions.bean.Category> listOfCategory = CategoryEO.getAllCategory();
					 ArrayList<ProductType> listOfProductType = ProductTypeEO.getAllCategory();
					 request.setAttribute("categoryList",listOfCategory);
					 request.setAttribute("productTypeList",listOfProductType);
					 logger.info("password correct");
					 if(i == 5)
					 {
						 RequestDispatcher requestdispatcher=request.getRequestDispatcher("Admin.jsp");  
						 requestdispatcher.forward(request,response);
					 }
					 else
					 {
				        RequestDispatcher requestdispatcher=request.getRequestDispatcher("userPage.jsp");  
				        
				        String cookieName = "";
						Cookie[] cookies =  request.getCookies();
						String cookieValue = "";
						boolean isCookieAvailable = false;
						for(int j=0;j<cookies.length;j++)
						{
							cookieName = cookies[j].getName();
							if(cookieName.equals("SUGGESTION_PROJECT_"+userName))
							{
								isCookieAvailable = true;
								cookieValue = cookies[j].getValue();
							}
						}
	
						String categoryId ="0";
						String ProductTypeId = "0";
						ArrayList<Product>	 productList = new ArrayList<Product>();
						if(isCookieAvailable)
						{
							String[] parameters = cookieValue.split("#");
							 categoryId =parameters[0];
							 ProductTypeId = parameters[1];
							 
							 if(!categoryId.equals("null") && !ProductTypeId.equals("null"))
							 {
								 productList = ProductEO.getProductsByCategoryAndProductType(Integer.parseInt(categoryId), Integer.parseInt(ProductTypeId));
							 }
						}
						else
						{
							 productList = ProductEO.getAllProducts();
						}
							
							request.setAttribute("productList", productList);
			        requestdispatcher.forward(request,response);  
			     }
			 }  
			else{  
			        out.print("Sorry username or password error");  
			        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			        rd.include(request,response);  
			    }  
	   
				 out.close();  
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
