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
	+ "PitcherID integer not null"
	+ "PitchID integer not null"
	+ "NumberOfPitches integer not null"
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
			int pitch = rs.getInt("pitchID");
			

			rs.close();
			
			Report stats = new Report(this, atBatID, player1, pitcher, pitch);
			
			return stats;
		}
		catch( SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("Error finding Report", e);
		}
	}
}
