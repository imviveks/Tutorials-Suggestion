package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.suggestions.bean.User;
import com.suggestions.dao.UserDAO;
import com.suggestions.services.ProcessHandlingService;


@WebServlet("/ProcessHandlerController")
public class ProcessHandlerController extends HttpServlet {


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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userType = request.getParameter("userType");
		try {
				if(userType.equalsIgnoreCase("admin"))
				{
					
						ProcessHandlingService.processInputsForAdminUser(request);
						out.write("Successfully added"); 
					
				}
				else if(userType.equalsIgnoreCase("user"))
				{
					ProcessHandlingService.processInputsForNormalUser(request,response,out);
				}
		
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.write("Some error occured"); 
			e.printStackTrace();
		}
		 
	}
	
}
