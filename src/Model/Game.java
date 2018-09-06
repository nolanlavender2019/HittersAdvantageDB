package Model;

import DAO.GameDAO;

public class Game {
	private GameDAO dao;
	private int gameID;
	private int teamID;
	private int opponentID;
	
	
	public Game(GameDAO dao, int gameID, int teamID, int opponentID){
		this.dao = dao;
		this.setGameID(gameID);
		this.setTeamID(teamID);
		this.setOpponentID(opponentID);
	}


	public int getGameID() {
		return gameID;
	}


	public void setGameID(int gameID) {
		this.gameID = gameID;
	}


	public int getTeamID() {
		return teamID;
	}


	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}


	public int getOpponentID() {
		return opponentID;
	}


	public void setOpponentID(int opponentID) {
		this.opponentID = opponentID;
	}
}
