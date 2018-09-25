package DAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Collection;
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
	
	
	private final String url = "jdbc:derby:HittersAdvantageDB";
	
	
	public DatabaseManager(){
		
		driver = new EmbeddedDriver();
		
		Properties prop = new Properties();
		prop.put("create", "false");
		
		try{
			conn = driver.connect(url, prop);
			conn.setAutoCommit(false);
			System.out.println("Connected");
		}
		catch(SQLException e){
			//database doesn't exist, so try creating it
			try{
				prop.put("create", "true");
				conn = driver.connect(url, prop);
				conn.setAutoCommit(false);
				create(conn);
				System.out.print("Database created /n");
			}
			catch (SQLException e2){
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
	
	public AtBat findAtBat(int abID){
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
	public AtBat insertAtBat(int abID, int playerID, int pitcherID, int gameID, String result){
		return atBatDAO.insert(abID,playerID,pitcherID,gameID,result);
	}
	
	public Game insertGame(int gameID, int teamID, int opponentID){
		return gameDAO.insert(gameID,teamID,opponentID);
	}
	
	public Opponents insertOpponent(int teamID, String teamName){
		return opponentDAO.insert(teamID,teamName);
	}
	public Pitch insertPitch(int pitchID, int reportID, double d, String type, String ballOrstrike){
		return pitchDAO.insert(pitchID,reportID,d,type,ballOrstrike);
	}
	public Pitchers insertPitchers(int pitcherID, String pitcherName, int teamID, String throw1, String pitch1, String pitch2, String pitch3, String pitch4){
		return pitcherDAO.insert(pitcherID,pitcherName,teamID,throw1,pitch1,pitch2,pitch3,pitch4);
	}
	public Players insertPlayers(int playerID, String playerName, int teamID, int number, String position, String hit, float battingAverage, float onBasePercentage, float sluggingPercentage){	
		return playerDAO.insert(playerID,playerName,teamID, number,position, hit, battingAverage, onBasePercentage, sluggingPercentage);
	}
	public Report insertReport(int reportID,int gameID, int pitcherID){
		return reportDAO.insert(reportID,gameID,pitcherID);
	}
	public Team insertTeam(int teamID, String teamName){
		return teamDAO.insert(teamID,teamName);
	}
	
	public Collection<Players> gettingPlayers(int teamID){
		return teamDAO.getPlayers(teamID);
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
			atBatDAO.clear();
			gameDAO.clear();
			opponentDAO.clear();
			pitchDAO.clear();
			pitcherDAO.clear();
			playerDAO.clear();
			reportDAO.clear();
		} catch (SQLException e) {
			throw new RuntimeException("cannot clear tables", e);
		}
	}
}

