package com.suggestions.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.suggestions.bean.Cookies;
import com.suggestions.database.JDBCConnection;
import com.suggestions.database.SqlServerJDBCConnection;

	
	public class CookiesDao {
		public static final Logger logger = Logger.getLogger(CookiesDao.class);
		private static Connection connection;
		
		/*private static String addQuery = "Insert into " + TABLENAME
				+ " values (?,?,?)";

		static String getFileQuery = "Select * from " + TABLENAME + " where "
				+ COOKIEID + "=(?)";

		private static String getFilesQuery = "Select * from " + TABLENAME;

		private static String updateFileQuery = "update " + TABLENAME + " set "
				+ COOKIENAME + "=? "  + " where " + COOKIEID + "=?";*/

		private static final String addQuery = "INSERT INTO COOKIES(cookieName,userId) values(?,?)";
		private static final String deleteQuery = "DELETE FROM PRODUCT WHERE productId = ?";
		private static final String selectQuery = "SELECT * FROM PRODUCT";
		private static final String update = "";
		
		public static boolean addCookies(Cookies cookies) throws IOException {
		connection = JDBCConnection.getConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(addQuery);
				
				int cookieId = cookies.getCookieId();
				String cookieName = cookies.getCookieName();
				int userId = cookies.getUserId();
				
				
				statement.setInt(1, cookieId);
				statement.setString(2, cookieName);
				statement.setInt(3, userId);
				
				int i = statement.executeUpdate();
				if (i > 0) {
					return true;
				} else
					return false;
			} catch (Exception e) {
				logger.error(e);
			}
			return false;
		}

		public static boolean updateCookies(Cookies cookies) {
			try {
				PreparedStatement statement = connection.prepareStatement(update);
				int cookieId = cookies.getCookieId();
				String cookieName = cookies.getCookieName();
				int userId = cookies.getUserId();
				
				
				statement.setString(1, cookieName);
				statement.setInt(2, userId);
				
				int i = statement.executeUpdate();
				if (i > 0) {
					logger.info(i + " values updated");
					return true;
				} else {
					logger.info("not updated");
					return false;
				}
			} catch (Exception e) {
				logger.error(e);
			}
			return false;
		}
		
		public static ArrayList<Cookies> getsCookies(Cookies cookies) {
			ArrayList<Cookies> fileresourcelist=new ArrayList<Cookies>();
			try{
				PreparedStatement statement=connection.prepareStatement(selectQuery);
				ResultSet resultset=statement.executeQuery();
				while(resultset.next())
				{
					int cookieId=resultset.getInt(1);
					String cookiesName=resultset.getString(2);
					int userId=resultset.getInt(3);
					
					
					cookies=new Cookies(cookieId,cookiesName,userId);
					fileresourcelist.add(cookies);
				}
				
			}catch(Exception e){System.out.println(e);}
			return fileresourcelist;
		}
		
		public static Cookies getCookies(int fileid) {
			Cookies cookies=new Cookies();
			try{
				PreparedStatement statement=connection.prepareStatement(selectQuery);
				statement.setLong(1, fileid);
				ResultSet resulset=statement.executeQuery();
				while(resulset.next())
				{
					int cookieId=resulset.getInt(1);
					String cookiesName=resulset.getString(2);
					int userId=resulset.getInt(3);
					
					
					cookies=new Cookies(cookieId,cookiesName,userId);
				}
				
			}catch(Exception e){System.out.println(e);}
			return cookies;
		}
	
	
}
