package Model;

import DAO.OpponentsDAO;

public class Opponents {
	
	private OpponentsDAO dao;
	private int opponentID;
	private String teamName;
	
	public Opponents(OpponentsDAO dao, int opponentID, String teamName){
		this.dao = dao;
		this.opponentID = opponentID;
		this.teamName = teamName;
		
	}
}
