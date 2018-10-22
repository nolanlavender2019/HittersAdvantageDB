package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.DatabaseManager;
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
		String s = "create table PITCHS(" 
	+ "PitchID integer not null,"
	+ "ReportID integer not null,"
	+ "Count varchar(40) not null,"
	+"Type varchar(100) not null,"
	+"BallStrike varchar(100) not null,"
	+ "primary key (PitchID))";
	stmt.executeUpdate(s);
}
	
	public Pitch find(int id){
		try{ 
		String qry = "select t.* from PITCHS t where pitchID = ?";
		PreparedStatement pstmt = conn.prepareStatement(qry);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(!rs.next())
			return null;
		
		int pitchID = rs.getInt("pitchID");
		int reportID = rs.getInt("reportID");
		String countID = rs.getString("count");
		String type = rs.getString("type");
		String ballStrike = rs.getString("ballStrike");
		

		rs.close();
		
		Pitch stats = new Pitch(this, pitchID, reportID, countID, type, ballStrike);
		
		return stats;
		}
	catch( SQLException e) {
		dbm.cleanup();
		throw new RuntimeException("Error finding Pitch", e);
	}
}
	
	public Pitch insert(int pitchID, int reportID, String d, String type, String ballOrstrike){
		try{
			if(find(pitchID) != null)
				return null;
			
			String cmd = "insert into PITCHS(pitchID, reportID, count, type, ballstrike)" + "values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, pitchID);
			pstmt.setInt(2, reportID);
			pstmt.setString(3, d);
			pstmt.setString(4,  type);
			pstmt.setString(5,ballOrstrike);
			
			pstmt.execute();
			
			Pitch team = new Pitch(this, pitchID, reportID, d, type, ballOrstrike);
			
			return team;
		}
			catch (SQLException e) {
				dbm.cleanup();
				throw new RuntimeException("error inserting new Pitch", e);
		}
	}
	
	public ArrayList<Double> getPitchTendency(int reportID, String countID){
		ArrayList<Double> tendencies = new ArrayList<Double>();
			try{
					int fastballCount = 0;
					int curveBallCount = 0;
					int sliderCount = 0;
					int changeUpCount = 0 ;
					int length = 0;
					double fTendency = 0.0;
					double cbTendency = 0.0;
					double changeUpTendency = 0.0;
					double sliderTendency = 0.0;

					//get specific pitch and count
					String qry = "select s.* from Pitchs s where reportID = ? and count = ?";
					PreparedStatement pstmt = conn.prepareStatement(qry);
					pstmt.setInt(1, reportID);
					pstmt.setString(2,countID);
					System.out.println(countID);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()){
						length++;
						String type = rs.getString("Type");
						System.out.println(type);
						System.out.println("This is the count " + rs.getString("Count"));
						if(type.equals("Fastball")){
							fastballCount++;
						}
						if(type.equals("Curveball")){
							curveBallCount++;
						}
						if(type.equals("Slider")){
							sliderCount++;
						}
						if(type.equals("Changeup")){
							changeUpCount++;
						}
					}
					if( length != 0 ){
					fTendency = (double)fastballCount/length;
					cbTendency = (double)curveBallCount/length;
					sliderTendency = (double)sliderCount/length;
					changeUpTendency = (double)changeUpCount/length;
					}
					else{
						fTendency = 0;
						cbTendency = 0;
						sliderTendency = 0;
						changeUpTendency = 0;
					}
					tendencies.add(fTendency);
					tendencies.add(cbTendency);
					tendencies.add(sliderTendency);
					tendencies.add(changeUpTendency);
					rs.close();
					return tendencies;
					
			} catch(SQLException e){
				dbm.cleanup();
				System.out.println(e);
				throw new RuntimeException("error getting Pitches", e);
			}
		}
	void clear() throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "delete from PITCHS";
		stmt.executeUpdate(s);
		}
}
