package Model;

import java.util.Collection;
import DAO.PlayersDAO;

import DAO.TeamDAO;

public class Team {
	private TeamDAO dao;
	private int teamID;
	private String teamName;
	private Collection<Players> players;
	private Collection<Game> game;

	
	public Team(TeamDAO dao, int teamID, String teamName){
		this.dao = dao;
		this.setTeamID(teamID);
		this.setTeamName(teamName);
		
	}
	public String toString() {
		return teamName + " " + teamID;
	}
	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int playerID) {
		this.teamID = playerID;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	

public Collection <Players> getPlayers(){
	if(players == null) players = dao.getPlayers(teamID);
	return players;
}
public Collection <Game> getGame(){
	if(game == null) game = dao.getGame(teamID);
	return game;
}
}