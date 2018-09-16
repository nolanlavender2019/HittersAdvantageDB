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
import Model.Team;
import Model.Players;

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
				+"teamID integer notNull"
				+ "teamName varchar(100),"
				+ "primary key (teamID))";
	stmt.executeUpdate(s);
}
	
	public Team find(int teamID){
		try{ 
		String qry = "select t.* from TEAM t where teamID = ?";
		PreparedStatement pstmt = conn.prepareStatement(qry);
		pstmt.setInt(1, teamID);
		ResultSet rs = pstmt.executeQuery();
		
		if(!rs.next())
			return null;
		
		int gameID = rs.getInt("PlayerID");
		String teamID1 = rs.getString("TeamName");
		
	

		rs.close();
		
		Team stats = new Team(this, gameID, teamID1);
		
		return stats;
		}
	catch( SQLException e) {
		dbm.cleanup();
		throw new RuntimeException("Error finding Team", e);
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
	public Collection<Players> getPlayers(int teamID){
		try{
				Collection<Players> stats = new ArrayList<Players>();
				String qry = "select s.* from PLAYERS s where TeamID = ?";
				PreparedStatement pstmt = conn.prepareStatement(qry);
				pstmt.setInt(1, teamID);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()){
					int teamID1 = rs.getInt("PlayerID");
					stats.add(dbm.findPlayer(teamID1));
		
				}
				rs.close();
				return stats;
		} catch(SQLException e){
			dbm.cleanup();
			throw new RuntimeException("error getting Players", e);
		}
	}
	public Collection<Game> getGame(int teamID){
		try{
				Collection<Game> stats = new ArrayList<Game>();
				String qry = "select s.* from Game s where TeamID = ?";
				PreparedStatement pstmt = conn.prepareStatement(qry);
				pstmt.setInt(1, teamID);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()){
					int teamID1 = rs.getInt("gameID");
					stats.add(dbm.findGame(teamID1));
		
				}
				rs.close();
				return stats;
		} catch(SQLException e){
			dbm.cleanup();
			throw new RuntimeException("error getting Games", e);
		}
	}
	void clear() throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "delete from TEAM";
		stmt.executeUpdate(s);
		}
	
}

