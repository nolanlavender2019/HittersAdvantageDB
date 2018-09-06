package Model;

import DAO.OpponentsDAO;

public class Opponents {
	
	private OpponentsDAO dao;
	private int opponentID;
	private String teamName;
	
	public Opponents(OpponentsDAO dao, int opponentID, String teamName){
		this.dao = dao;
		this.setOpponentID(opponentID);
		this.setTeamName(teamName);
		
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
}
