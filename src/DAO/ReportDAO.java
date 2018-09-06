package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.DatabaseManager;

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
}
