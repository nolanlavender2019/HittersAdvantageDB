package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.DatabaseManager;

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
	+"TeamName varchar(100) not null"
	+ "primary key (OpponentsID))";
	stmt.executeUpdate(s);
}
}
