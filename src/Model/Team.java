package Model;

import DAO.TeamDAO;

public class Team {
	private TeamDAO dao;
	private int playerID;
	private String teamName;
	
	public Team(TeamDAO dao, int playerID, String teamName){
		this.dao = dao;
		this.playerID = playerID;
		this.teamName = teamName;
		
	}
	
}
