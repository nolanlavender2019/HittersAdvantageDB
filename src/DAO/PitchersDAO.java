package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.DatabaseManager;

public class PitchersDAO {
	private Connection conn;
	private DatabaseManager dbm;
	
	public PitchersDAO(Connection conn, DatabaseManager dbm){
		this.conn= conn;
		this.dbm = dbm;
	}
	static void create(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "create table PITCHERS(" 
	+ "PitcherID integer not null,"
	+ "PitcherName varchar(100) not null"
	+ "TeamID integer not null"
	+ "Throw varchar(100) not null"
	+ "Pitch1 varchar(100) not null"
	+ "Pitch2 varchar(100) not null"
	+ "Pitch3 varchar(100) not null"
	+ "Pitch4 varchar(100) not null"
	+ "primary key (PitcherID))";
	stmt.executeUpdate(s);
}
}
