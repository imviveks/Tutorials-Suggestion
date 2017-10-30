package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.suggestions.bean.User;
import com.suggestions.dao.LoginDAO;
import com.suggestions.dao.UserDAO;
import com.suggestions.database.JDBCConnection;

/**
 * @author User
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	public static final Logger logger = Logger.getLogger(JDBCConnection.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public LoginServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * method to fetch GET request and response
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * method to fetch POST request and response
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		logger.info("in servlet login");
		String userName = request.getParameter("userid");
		int i= Integer.parseInt(userName);
		String userPassword = request.getParameter("userPassword");
//      UserDAO userdao= new UserDAO();
      User u = UserDAO.getUser(i);
      String username1=u.getUserName();
      String userpass=u.getUserPassword();
		 if(userPassword.equals(userpass))
		 { 
			 logger.info("password correct");
		        RequestDispatcher requestdispatcher=request.getRequestDispatcher("userPage.jsp");  
		        requestdispatcher.forward(request,response);  
		 }  
		else{  
		        out.print("Sorry username or password error");  
		        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
		        rd.include(request,response);  
		    }  
		          
		    out.close();  
		    }  

				
	}


