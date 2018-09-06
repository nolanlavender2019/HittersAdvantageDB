package Model;


import DAO.PlayersDAO;

public class Players {
	
	private PlayersDAO dao;
	private int playerID;
	private String playerName;
	private int number;
	private String position;
	private String hit;
	private float battingAverage;
	private float oBP;
	private float slugging;

	public Players(PlayersDAO dao, int playerID, String playerName,int number, String position, String hit, float battingAverage, float oBP, float slugging){
		this.dao = dao;
		this.playerID = playerID;
		this.playerName = playerName;
		this.number = number;
		this.position = position;
		this.hit = hit;
		this.battingAverage = battingAverage;
		this.oBP = oBP;
		this.slugging = slugging;
	}
}
