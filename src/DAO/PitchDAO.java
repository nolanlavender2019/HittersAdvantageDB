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
		String s = "create table PITCH(" 
	+ "PitchID integer not null,"
	+ "ReportID integer not null,"
	+ "Count Double not null,"
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
		Double countID = rs.getDouble("count");
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
	
	public Pitch insert(int pitchID, int reportID, double d, String type, String ballOrstrike){
		try{
			if(find(pitchID) != null)
				return null;
			
			String cmd = "insert into PITCH(pitchID, reportID, count, type, ballstrike)" + "values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, pitchID);
			pstmt.setInt(2, reportID);
			pstmt.setDouble(3, d);
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
	public Collection<Float> getPitchTendency(int reportID,int pitcherID, double countID){
		Collection<Float> tendencies = new ArrayList<Float>();
			try{
					int fastballCount = 0;
					int curveBallCount = 0;
					int sliderCount = 0;
					int changeUpCount = 0 ;
					int length = 0;

					//get specific pitch and count
					String qry = "select s.* from Pitch s where reportID = ? and pitcherID = ? and count = ?" + "values(?,?,?)" ;
					PreparedStatement pstmt = conn.prepareStatement(qry);
					pstmt.setInt(1, reportID);
					pstmt.setInt(2, pitcherID);
					pstmt.setDouble(3,countID);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()){
						length++;
						String type = rs.getString("Type");
						if(type == "Fastball"){
							fastballCount++;
						}
						if(type == "Curveball"){
							curveBallCount++;
						}
						if(type == "Slider"){
							sliderCount++;
						}
						if(type == "ChangeUp"){
							changeUpCount++;
						}
					}
					float fTendency = fastballCount/length;
					float cbTendency = curveBallCount/length;
					float sliderTendency = sliderCount/length;
					float changeUpTendency = changeUpCount/length;
					tendencies.add(fTendency);
					tendencies.add(cbTendency);
					tendencies.add(sliderTendency);
					tendencies.add(changeUpTendency);
					rs.close();
					return tendencies;
			} catch(SQLException e){
				dbm.cleanup();
				throw new RuntimeException("error getting Pitches", e);
			}
		}
	void clear() throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "delete from PITCH";
		stmt.executeUpdate(s);
		}
}
