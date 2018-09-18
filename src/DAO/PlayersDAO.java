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
import Model.Players;

public class PlayersDAO {
	private Connection conn;
	private DatabaseManager dbm;
	
	public PlayersDAO(Connection conn, DatabaseManager dbm){
		this.conn= conn;
		this.dbm = dbm;
	}
	
	static void create(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "create table PLAYERS(" 
	+ "PlayerID integer not null,"
	+ "PlayerName varchar(100),"
	+ "Number integer,"
	+ "TeamID integer,"
	+ "Position varchar(100),"
	+ "Hit varchar(100),"
	+ "BattingAverage float,"
	+ "OnBasePercentage float,"
	+ "SluggingPercentage float,"
	+ "primary key (PlayerID))";
	stmt.executeUpdate(s);
}
	public Players find(int id){
		try{ 
		String qry = "select t.* from PLAYERS t where playerID = ?";
		PreparedStatement pstmt = conn.prepareStatement(qry);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(!rs.next())
			return null;
		
		int playerID = rs.getInt("playerID");
		String playerName = rs.getString("playerName");
		int teamID = rs.getInt("teamID");
		int number = rs.getInt("number");
		String position = rs.getString("position");
		String hit = rs.getString("hit");
		float pitch2 = rs.getFloat("battingAverage");
		float pitch3 = rs.getFloat("sluggingPercentage");
		float pitch4 = rs.getFloat("onBasePercentage");
		

		rs.close();
		
		Players stats = new Players(this, playerID, playerName, teamID, number, position, hit, pitch2, pitch3, pitch4);
		
		return stats;
		}
	catch( SQLException e) {
		dbm.cleanup();
		throw new RuntimeException("Error finding Players", e);
	}
}
	public Players insert(int playerID, String playerName, int teamID, int number, String position, String hit, float battingAverage, float onBasePercentage, float sluggingPercentage){
		try{
			if(find(playerID) != null)
				return null;
			
			String cmd = "insert into PLAYERS(playerID, playerName,teamID, number, position, hit, battingAverage, onBasePercentage, sluggingPercentage)" + "values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, playerID);
			pstmt.setString(2, playerName);
			pstmt.setInt(3,teamID);
			pstmt.setInt(4, number);
			pstmt.setString(5,  position);
			pstmt.setString(6, hit);
			pstmt.setFloat(7, battingAverage);
			pstmt.setFloat(8, onBasePercentage);
			pstmt.setFloat(9, sluggingPercentage);
			
			pstmt.execute();
			
			Players team = new Players(this, playerID, playerName, teamID, number, position, hit, battingAverage, onBasePercentage, sluggingPercentage);
			
			return team;
		}
			catch (SQLException e) {
				dbm.cleanup();
				throw new RuntimeException("error inserting new Player", e);
		}
	}
	public Collection<AtBat> getAB(int playerID){
		try{
				Collection<AtBat> stats = new ArrayList<AtBat>();
				String qry = "select s.* from AtBat s where PlayerID = ?";
				PreparedStatement pstmt = conn.prepareStatement(qry);
				pstmt.setInt(1, playerID);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()){
					int teamID1 = rs.getInt("ABID");
					stats.add(dbm.findAtBat(teamID1));
		
				}
				rs.close();
				return stats;
		} catch(SQLException e){
			dbm.cleanup();
			throw new RuntimeException("error getting AB", e);
		}
	}
	void clear() throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "delete from PLAYERS";
		stmt.executeUpdate(s);
		}
}
