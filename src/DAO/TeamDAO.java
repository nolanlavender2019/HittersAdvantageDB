package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.DatabaseManager;

public class TeamDAO {
	private Connection conn;
	private DatabaseManager dbm;
	
	public TeamDAO(Connection conn, DatabaseManager dbm){
		this.conn= conn;
		this.dbm = dbm;
	}
	static void create(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "create table TEAM(" 
	+ "PlayerID integer not null,"
	+"TeamName varchar(100)"
	+ "primary key (PlayerID))";
	stmt.executeUpdate(s);
}
}
