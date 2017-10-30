package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	
	/**
	 * Servlet implementation class UserLoginController
	 */
	@WebServlet("/UserLoginController")
	public class UserLoginController extends HttpServlet {
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
			PrintWriter writer=response.getWriter();
			response.setContentType("text/html");
			String userId=request.getParameter("username");
			
			String userPassword=request.getParameter("password");
			if( userId.equals("user") && userPassword.equals("123") )
			{
				writer.append("<html><body>login sucessfully</body></html>");
			   //writer.println("login Successfully");
			}
			else{
				writer.append("<html><body>login failed</body></html>");
			}
		}
	    public void init()
	    {
	    	
	    }	
	}


