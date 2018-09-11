package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.DatabaseManager;
import Model.Game;
import Model.Opponents;

public class OpponentsDAO {
	private Connection conn;
	private DatabaseManager dbm;
	
	public OpponentsDAO(Connection conn, DatabaseManager dbm){
		this.conn= conn;
		this.dbm = dbm;
	}
	static void create(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "create table OPPONENTS(" 
	+ "OpponentsID integer not null,"
	+"TeamName varchar(100) not null"
	+ "primary key (OpponentsID))";
	stmt.executeUpdate(s);
	}
	
	public Opponents find(int id){
		try{ 
		String qry = "select t.* from OPPONENTS t where opponentID = ?";
		PreparedStatement pstmt = conn.prepareStatement(qry);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(!rs.next())
			return null;
		
		int gameID = rs.getInt("opponentID");
		String teamID = rs.getString("teamName");
		
	

		rs.close();
		
		Opponents stats = new Opponents(this, gameID, teamID);
		
		return stats;
		}
	catch( SQLException e) {
		dbm.cleanup();
		throw new RuntimeException("Error finding Game", e);
	}
}
}
