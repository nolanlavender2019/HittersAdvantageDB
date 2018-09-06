package Model;

import DAO.TeamDAO;

public class Team {
	private TeamDAO dao;
	private int playerID;
	private String teamName;
	
	public Team(TeamDAO dao, int playerID, String teamName){
		this.dao = dao;
		this.setPlayerID(playerID);
		this.setTeamName(teamName);
		
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
}
