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
	
	public Game find(int id){
		try{ 
		String qry = "select t.* from GAME t where gameID = ?";
		PreparedStatement pstmt = conn.prepareStatement(qry);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(!rs.next())
			return null;
		
		int gameID = rs.getInt("gameID");
		int teamID = rs.getInt("teamID");
		int opponentID = rs.getInt("opponentID");
	

		rs.close();
		
		Game stats = new Game(this, gameID, teamID, opponentID);
		
		return stats;
		}
	catch( SQLException e) {
		dbm.cleanup();
		throw new RuntimeException("Error finding Game", e);
	}
}

}
