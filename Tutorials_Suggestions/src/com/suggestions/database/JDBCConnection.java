package com.suggestions.database;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

	public class JDBCConnection
	{
		public static final Logger log= Logger.getLogger(JDBCConnection.class.getName());
		private static Connection connection;
		static Statement statement;
		static ResultSet resultSet;
		static PreparedStatement preparedStatement;
				
		/**
		 * @return
		 */
		public static Connection getConnection()
		{
			try
			{
				if(connection != null)
				{
					if(!connection.isClosed())
					{
						return connection;
					}
				} 
				else
				{
					
					log.info("in connection");
					ClassLoader loader = Thread.currentThread().getContextClassLoader();
//					InputStream in = loader.getResourceAsStream("db.properties");
					Properties properties = new Properties();
					String filePath="com/suggestions/database/db.properties";
					InputStream resource=Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
//					properties.load(new FileReader("./src/com/suggestions/database/db.properties"));
                     properties.load(resource);
					String driver = properties.getProperty("db.driver");
					String host = properties.getProperty("db.host");
					String port = properties.getProperty("db.port");
					String dbName = properties.getProperty("db.dbName");
					String user = properties.getProperty("db.user");
					String password = properties.getProperty("db.password");
					String protocol = properties.getProperty("db.protocol");
					
					Class.forName(driver);
					String ConnectionString =protocol+"://"+host+":"+port+";database="+dbName+";user="+user+";password="+password;
//							"jdbc:sqlserver://localhost:1433;database=SuggestionDB;user=suggestiondb;password=admin";
					connection = DriverManager.getConnection(ConnectionString);
//					log.info(connection);
					
				}//if-else ends here
				
			}
			catch(SQLException | ClassNotFoundException | IOException e)
			{
				log.error(e);
			}//try catch ends here

			return connection;
		}// getConnection() method ends here
		public static void main(String[] args){
			try{
				log.info("in main");
				Connection con =JDBCConnection.getConnection();
				log.info(con+"connection established");
			}
			catch(Exception e){
				log.error(e);
			}
		}
		
	}//class ends here
