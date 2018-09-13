package DAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.derby.jdbc.EmbeddedDriver;

import Model.Team;
import Model.Players;
import Model.AtBat; 
import Model.Pitch; 
import Model.Report; 
import Model.Game; 
import Model.Pitchers; 
import Model.Opponents; 


public class DatabaseManager {
	
	private Driver driver;
	private Connection conn;
	private TeamDAO teamDAO;
	private PlayersDAO playerDAO;
	private AtBatDAO atBatDAO;
	private OpponentsDAO opponentDAO;
	private PitchersDAO pitcherDAO;
	private GameDAO gameDAO;
	private ReportDAO reportDAO;
	private PitchDAO pitchDAO;
	
	
	private final String url = "jdbc:derby:HittersAdvantage";
	
	
	public DatabaseManager(){
		
		driver = new EmbeddedDriver();
		
		Properties prop = new Properties();
		prop.put("create", "false");
		
		try{
			conn = driver.connect(url, prop);
			conn.setAutoCommit(false);
		}
		catch(SQLException e){
			//database doesn't exist, so try creating it
			try{
				prop.put("create", "true");
				conn = driver.connect(url, prop);
				conn.setAutoCommit(false);
				create(conn);
			}
			catch (SQLException e2) {
				throw new RuntimeException("cannot connect to database", e2);
			}
		}
		teamDAO = new TeamDAO(conn, this);
		gameDAO = new GameDAO(conn, this);
		opponentDAO = new OpponentsDAO(conn, this);
		pitcherDAO = new PitchersDAO(conn, this);
		reportDAO = new ReportDAO(conn, this);
		pitchDAO = new PitchDAO(conn, this);
		atBatDAO = new AtBatDAO(conn,this);
		playerDAO = new PlayersDAO(conn,this);
		
	}
	
	private void create(Connection conn) throws SQLException { 
		TeamDAO.create(conn);
		PlayersDAO.create(conn);
		AtBatDAO.create(conn);
		OpponentsDAO.create(conn);
		PitchersDAO.create(conn);
		GameDAO.create(conn);
		ReportDAO.create(conn);
		PitchDAO.create(conn);
		conn.commit();
	}


	public Team findTeam(int id){
		return teamDAO.find(id);
	}

	public Game findGame(int gameID){
		return gameDAO.find(gameID);
	}
	
	public Opponents findOpponents(int seas){
		return opponentDAO.find(seas);
	}
	
	public AtBat findATBat(int abID){
		return atBatDAO.find(abID);
	}
	public Pitchers findPitcher(int pitcherID){
		return pitcherDAO.find(pitcherID);
	}
	public Pitch findPitch(int pitchID){
		return pitchDAO.find(pitchID);
	}
	public Report findReport(int reportID){
		return reportDAO.find(reportID);
	}
	public Players findPlayer(int playerID){
		return playerDAO.find(playerID);
	}
	
	/*
	public Team insertTeam(int id, String name, String leg, String div){
		return teamDAO.insert(id, name, leg, div);
	}
	public TeamStats insertStats(int id, int season, int win, int loss, int place){
		return statsDAO.insert(id, season,win,loss,place);
	}
 
	public Season insertSeason(int season){
		return seasonDAO.insert(season);
	}
	//--------------------------------------------------
	// Utility Functions
	
	public void commit(){
		try{
			conn.commit();
		}
		catch (SQLException e){
			throw new RuntimeException("Cannot commit database", e);
		}
	}
	
	public void cleanup(){
		try{
			conn.rollback();
			conn.close();
		}
		catch(SQLException e){
			System.out.println("Fatal error: cannot cleanup connection");
		}
	}
	public void close() {
		try {
			conn.close();
		}
		catch(SQLException e) {
			throw new RuntimeException("cannot close database connection", e);
		}
		
		try {
			Properties prop = new Properties();
			prop.put("shutdown", "true");
			conn = driver.connect(url, prop);
		} catch (SQLException e) {
			
			System.out.println("Derby has shut down successfully");
		}
	}
	public void clearTables() {
		try {
			teamDAO.clear();
			statsDAO.clear();
			seasonDAO.clear();
		} catch (SQLException e) {
			throw new RuntimeException("cannot clear tables", e);
		}
	}
}
*/
