package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.DatabaseManager;

public class PlayersDAO {
	private Connection conn;
	private DatabaseManager dbm;
	
	public PlayersDAO(Connection conn, DatabaseManager dbm){
		this.conn= conn;
		this.dbm = dbm;
	}
	
	static void create(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement();
		String s = "create table PLAYERS(" 
	+ "PlayerID integer not null,"
	+ "PlayerName varchar(100)"
	+ "Number integer"
	+ "Position varchar(100)"
	+ "Hit varchar(100) "
	+ "BattingAverage integer"
	+ "OnBasePercentage integer"
	+ "SluggingPercentage integer"
	+ "primary key (PlayerID))";
	stmt.executeUpdate(s);
}

}
