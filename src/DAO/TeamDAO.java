package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.DatabaseManager;
import Model.Opponents;
import Model.Team;

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
	
	public Team find(int id){
		try{ 
		String qry = "select t.* from TEAM t where teamID = ?";
		PreparedStatement pstmt = conn.prepareStatement(qry);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(!rs.next())
			return null;
		
		int gameID = rs.getInt("playerID");
		String teamID = rs.getString("teamName");
		
	

		rs.close();
		
		Team stats = new Team(this, gameID, teamID);
		
		return stats;
		}
	catch( SQLException e) {
		dbm.cleanup();
		throw new RuntimeException("Error finding Game", e);
	}
}
	
	public Team insert(int teamID, String teamName){
		try{
			if(find(teamID) != null)
				return null;
			
			String cmd = "insert into TEAM(teamID, teamName)" + "values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, teamID);
			pstmt.setString(2, teamName);
			
			
			pstmt.execute();
			
			Team team = new Team(this, teamID, teamName);
			
			return team;
		}
			catch (SQLException e) {
				dbm.cleanup();
				throw new RuntimeException("error inserting new Team", e);
		}
	}
}
}
