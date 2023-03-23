package es.jepm.ddbbGestion.controllers;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import es.jepm.ddbbGestion.properties.bbddProperties;

public class ConnectionManager {
	
	private static Connection connection = null;

	/**
	 * Realizes the connection with data base.
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public static void realizeConnection() throws SQLException, ClassNotFoundException {
		String driver = bbddProperties.getProperty("JDBC_DRIVER_CLASS");
		String user = bbddProperties.getProperty("JDBC_USER");
		String password = bbddProperties.getProperty("JDBC_PASSWORD");
		String host = bbddProperties.getProperty("JDBC_HOST");
		String schema = bbddProperties.getProperty("JDBC_SCHEMA_NAME");
		String properties = bbddProperties.getProperty("JDBC_PROPERTIES");
		
		Class.forName(driver);
		
		try {
			Class.forName(driver);
		   
			connection = (Connection) DriverManager.getConnection ("jdbc:mysql://" + host + "/" + schema + properties, user, password);			   
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection () throws SQLException, ClassNotFoundException {
		if (connection == null) {
			realizeConnection();
		}
		while (!connection.isValid(5)) {
			realizeConnection();
		}
		
		return connection;
	}
	
}
