package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.DatabaseManager;
import Model.AtBat;


public class AtBatDAO {
	
	private Connection conn;
	private DatabaseManager dbm;
	
	public AtBatDAO(Connection conn, DatabaseManager dbm){
		this.conn= conn;
		this.dbm = dbm;
	}
	
	static void create(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "create table ATBAT(" 
	+ "ABID integer not null,"
	+ "PlayerID integer not null"
	+ "PitcherID integer not null"
	+"GameID integer not null"
	+"Result varchar(100) not null"
	+ "primary key (ABID))";
	stmt.executeUpdate(s);
}
	
	public AtBat find(int id) {
		try{ 
			String qry = "select t.* from AtBat t where atBatID = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next())
				return null;
			
			int atBatID = rs.getInt("atBatID");
			int player1 = rs.getInt("playerID");
			int pitcher = rs.getInt("pitchersID");
			int game = rs.getInt("gameID");
			String place = rs.getString("result");

			rs.close();
			
			AtBat stats = new AtBat(this, atBatID, player1, pitcher, game, place);
			
			return stats;
		}
		catch( SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("Error finding teamStats", e);
		}
	}
}
