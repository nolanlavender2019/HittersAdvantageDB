package Gui;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.derby.jdbc.EmbeddedDriver;



public class DbConnection {
	 public Driver driver;
	public static Connection conn;
	private final String url = "jdbc:derby:HittersAdvantageDB";
	
	public DbConnection(){
		driver = new EmbeddedDriver();
		
		
		Properties prop = new Properties();
		prop.put("create", "false");
		
		try{
			conn = driver.connect(url, prop);
			conn.setAutoCommit(false);
			System.out.println("Connected");
		}
		catch(SQLException e){
			System.out.println(e);
		}
	}

	public static Connection dbConnector(){
		return conn;
	}
}

