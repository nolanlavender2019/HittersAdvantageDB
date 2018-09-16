package Model;

import java.util.Collection;

import DAO.OpponentsDAO;

public class Opponents {
	
	private OpponentsDAO dao;
	private int opponentID;
	private String teamName;
	
	private Collection<Game> game;
	private Collection<Pitchers> pitcher;
	
	public Opponents(OpponentsDAO dao, int opponentID, String teamName){
		this.dao = dao;
		this.setOpponentID(opponentID);
		this.setTeamName(teamName);
		
	}
	public String toString() {
		return teamName + " " + opponentID;
	}
	public int getOpponentID() {
		return opponentID;
	}

	public void setOpponentID(int opponentID) {
		this.opponentID = opponentID;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Collection <Game> getGame(){
		if(game == null) game = dao.getGame(opponentID);
		return game;
	}
	public Collection <Pitchers> getPitcher(){
		if(pitcher == null) pitcher = dao.getPitcher(opponentID);
		return pitcher;
	}
}
