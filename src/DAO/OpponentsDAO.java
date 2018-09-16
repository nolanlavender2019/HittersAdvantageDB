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
import Model.Game;
import Model.Opponents;
import Model.Pitchers;

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
	+"TeamName varchar(100) not null,"
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
	public Opponents insert(int teamID, String teamName){
		try{
			if(find(teamID) != null)
				return null;
			
			String cmd = "insert into Opponents(teamID, teamName)" + "values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, teamID);
			pstmt.setString(2, teamName);
			
			
			pstmt.execute();
			
			Opponents team = new Opponents(this, teamID, teamName);
			
			return team;
		}
			catch (SQLException e) {
				dbm.cleanup();
				throw new RuntimeException("error inserting new Opponents", e);
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
			throw new RuntimeException("error getting Game", e);
		}
	}
	public Collection<Pitchers> getPitcher(int teamID){
		try{
				Collection<Pitchers> stats = new ArrayList<Pitchers>();
				String qry = "select s.* from Pitcher s where TeamID = ?";
				PreparedStatement pstmt = conn.prepareStatement(qry);
				pstmt.setInt(1, teamID);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()){
					int teamID1 = rs.getInt("pitcherID");
					stats.add(dbm.findPitcher(teamID1));
		
				}
				rs.close();
				return stats;
		} catch(SQLException e){
			dbm.cleanup();
			throw new RuntimeException("error getting Opponents Pitchers", e);
		}
	}
	void clear() throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "delete from OPPONENTS";
		stmt.executeUpdate(s);
		}

}


