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
import Model.Pitchers;
import Model.Report;

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
	+ "PitcherName varchar(100) not null,"
	+ "TeamID integer not null,"
	+ "Throw1 varchar(100) not null,"
	+ "Pitch1 varchar(100) not null,"
	+ "Pitch2 varchar(100) not null,"
	+ "Pitch3 varchar(100) not null,"
	+ "Pitch4 varchar(100) not null,"
	+ "primary key (PitcherID))";
	stmt.executeUpdate(s);
}
	public Pitchers find(int id){
		try{ 
		String qry = "select t.* from PITCHERS t where pitcherID = ?";
		PreparedStatement pstmt = conn.prepareStatement(qry);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(!rs.next())
			return null;
		
		int gameID = rs.getInt("pitcherID");
		String teamID = rs.getString("pitcherName");
		int teamID1 = rs.getInt("teamID");
		String throw1 = rs.getString("throw1");
		String pitch1 = rs.getString("pitch1");
		String pitch2 = rs.getString("pitch2");
		String pitch3 = rs.getString("pitch3");
		String pitch4 = rs.getString("pitch4");
		

		rs.close();
		
		Pitchers stats = new Pitchers(this, gameID, teamID, teamID1, throw1, pitch1, pitch2, pitch3, pitch4);
		
		return stats;
		}
	catch( SQLException e) {
		dbm.cleanup();
		throw new RuntimeException("Error finding Pitchers", e);
	}
}
	public Pitchers insert(int pitcherID, String pitcherName, int teamID, String throw1, String pitch1, String pitch2, String pitch3, String pitch4){
		try{
			if(find(pitcherID) != null)
				return null;
			
			String cmd = "insert into Pitchers(pitcherID, pitcherName, teamID, throw1, pitch1, pitch2, pitch3, pitch4)" + "values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, pitcherID);
			pstmt.setString(2, pitcherName);
			pstmt.setInt(3, teamID);
			pstmt.setString(4,  throw1);
			pstmt.setString(5, pitch1);
			pstmt.setString(6, pitch2);
			pstmt.setString(7, pitch3);
			pstmt.setString(8, pitch4);
			
			pstmt.execute();
			
			Pitchers team = new Pitchers(this, pitcherID, pitcherName, teamID, throw1, pitch1, pitch2, pitch3, pitch4);
			
			return team;
		}
			catch (SQLException e) {
				dbm.cleanup();
				throw new RuntimeException("error inserting new Pitcher", e);
		}
	}
	public Collection<AtBat> getAB(int gameID){
		try{
				Collection<AtBat> stats = new ArrayList<AtBat>();
				String qry = "select s.* from AtBat s where pitcherID = ?";
				PreparedStatement pstmt = conn.prepareStatement(qry);
				pstmt.setInt(1, gameID);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()){
					int teamID1 = rs.getInt("abID");
					stats.add(dbm.findAtBat(teamID1));
		
				}
				rs.close();
				return stats;
		} catch(SQLException e){
			dbm.cleanup();
			throw new RuntimeException("error getting AB", e);
		}
	}
	public Collection<Report> getReport(int gameID){
		try{
				Collection<Report> stats = new ArrayList<Report>();
				String qry = "select s.* from Report s where pitcherID = ?";
				PreparedStatement pstmt = conn.prepareStatement(qry);
				pstmt.setInt(1, gameID);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()){
					int teamID1 = rs.getInt("reportID");
					stats.add(dbm.findReport(teamID1));
		
				}
				rs.close();
				return stats;
		} catch(SQLException e){
			dbm.cleanup();
			throw new RuntimeException("error getting Report from Pitchers", e);
		}
	}
	void clear() throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "delete from PITCHERS";
		stmt.executeUpdate(s);
		}
}
