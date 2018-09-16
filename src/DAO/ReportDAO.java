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
import Model.Pitch;
import Model.Players;
import Model.Report;

public class ReportDAO {
	private Connection conn;
	private DatabaseManager dbm;
	
	public ReportDAO(Connection conn, DatabaseManager dbm){
		this.conn= conn;
		this.dbm = dbm;
	}
	static void create(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "create table REPORT(" 
	+ "ReportID integer not null"
	+ "GameID integer not null,"
	+ "PitcherID integer not null,"
	
	+ "primary key (ReportID))";
	stmt.executeUpdate(s);
}

	
	public Report find(int id) {
		try{ 
			String qry = "select t.* from REPORT t where reportID = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next())
				return null;
			
			int atBatID = rs.getInt("reportID");
			int player1 = rs.getInt("gameID");
			int pitcher = rs.getInt("pitcherID");
		
			

			rs.close();
			
			Report stats = new Report(this, atBatID, player1, pitcher);
			
			return stats;
		}
		catch( SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("Error finding Report", e);
		}
	}

	public Report insert(int reportID,int gameID, int pitcherID){
		try{
			if(find(reportID) != null)
				return null;
			
			String cmd = "insert into Report(reportID, gameID, pitcherID)" + "values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, reportID);
			pstmt.setInt(2, gameID);
			pstmt.setInt(3,pitcherID);
			
			
			
			pstmt.execute();
			
			Report team = new Report(this, reportID, gameID, pitcherID);
			
			return team;
		}
			catch (SQLException e) {
				dbm.cleanup();
				throw new RuntimeException("error inserting new AtBat", e);
		}
	}
	public Collection<Pitch> getPitch(int reportID){
		try{
				Collection<Pitch> stats = new ArrayList<Pitch>();
				String qry = "select s.* from Pitch s where reportID = ?";
				PreparedStatement pstmt = conn.prepareStatement(qry);
				pstmt.setInt(1, reportID);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()){
					int teamID1 = rs.getInt("pitchID");
					stats.add(dbm.findPitch(teamID1));
		
				}
				rs.close();
				return stats;
		} catch(SQLException e){
			dbm.cleanup();
			throw new RuntimeException("error getting Pitch", e);
		}
	}
	
	void clear() throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "delete from REPORT";
		stmt.executeUpdate(s);
		}
}

