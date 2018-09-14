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
import Model.Opponents;
import Model.Pitch;

public class PitchDAO {
	private Connection conn;
	private DatabaseManager dbm;
	
	public PitchDAO(Connection conn, DatabaseManager dbm){
		this.conn= conn;
		this.dbm = dbm;
	}
	
	static void create(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "create table PITCH(" 
	+ "PitchID integer not null,"
	+ "ReportID integer not null,"
	+ "Count integer not null,"
	+"Type varchar(100) not null,"
	+"BallStrike varchar(100) not null,"
	+ "primary key (PitchID))";
	stmt.executeUpdate(s);
}
	
	public Pitch find(int id){
		try{ 
		String qry = "select t.* from PITCH t where pitchID = ?";
		PreparedStatement pstmt = conn.prepareStatement(qry);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(!rs.next())
			return null;
		
		int pitchID = rs.getInt("pitchID");
		int reportID = rs.getInt("reportID");
		int countID = rs.getInt("countID");
		String type = rs.getString("type");
		String ballStrike = rs.getString("ballStrike");
		

		rs.close();
		
		Pitch stats = new Pitch(this, pitchID, reportID, countID, type, ballStrike);
		
		return stats;
		}
	catch( SQLException e) {
		dbm.cleanup();
		throw new RuntimeException("Error finding Game", e);
	}
}
	
	public Pitch insert(int pitchID, int reportID, int count, String type, String ballOrstrike){
		try{
			if(find(pitchID) != null)
				return null;
			
			String cmd = "insert into PITCH(pitchID, reportID, count, type, ballOrstrike)" + "values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, pitchID);
			pstmt.setInt(2, reportID);
			pstmt.setInt(3, count);
			pstmt.setString(4,  type);
			pstmt.setString(5,ballOrstrike);
			
			pstmt.execute();
			
			Pitch team = new Pitch(this, pitchID, reportID, count, type, ballOrstrike);
			
			return team;
		}
			catch (SQLException e) {
				dbm.cleanup();
				throw new RuntimeException("error inserting new Pitch", e);
		}
	}
	void clear() throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "delete from PITCH";
		stmt.executeUpdate(s);
		}
}
