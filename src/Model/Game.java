package Model;

import DAO.GameDAO;

public class Game {
	private GameDAO dao;
	private int gameID;
	private int teamID;
	private int opponentID;
	
	
	public Game(GameDAO dao, int gameID, int teamID, int opponentID){
		this.dao = dao;
		this.gameID = gameID;
		this.teamID = teamID;
		this.opponentID = opponentID;
	}
}
