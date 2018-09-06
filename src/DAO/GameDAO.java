package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.DatabaseManager;


public class GameDAO {
	
	private Connection conn;
	private DatabaseManager dbm;
	
	public GameDAO(Connection conn, DatabaseManager dbm){
		this.conn= conn;
		this.dbm = dbm;
	}
	
	static void create(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "create table GAME(" 
	+ "GameID integer not null,"
	+ "TeamID integer not null"
	+ "OpponentID integer not null"
	+ "primary key (GameID))";
	stmt.executeUpdate(s);
}

}
