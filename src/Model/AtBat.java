package Model;

import DAO.AtBatDAO;


public class AtBat {
	
	private AtBatDAO dao;
	private int abID;
	private int playerID;
	private int pitcherID;
	private int gameID;
	private String result;
	
	public AtBat(AtBatDAO dao, int abID, int playerID, int pitcherID, int gameID, String result){
		this.dao = dao;
		this.abID = abID;
		this.playerID = playerID;
		this.pitcherID = pitcherID;
		this.gameID = gameID;
		this.result = result;
	}
}
