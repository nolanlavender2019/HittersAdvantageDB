package Model;


import java.util.Collection;

import DAO.PlayersDAO;

public class Players {
	
	private PlayersDAO dao;
	private int playerID;
	private String playerName;
	private int teamID;
	private int number;
	private String position;
	private String hit;
	private float battingAverage;
	private float oBP;
	private float slugging;
	
	private Collection<AtBat> ab;

	public Players(PlayersDAO dao, int playerID,  String playerName, int teamID, int number, String position, String hit, float battingAverage, float oBP, float slugging){
		this.dao = dao;
		this.setPlayerID(playerID);
		this.setPlayerName(playerName);
		this.setTeamID(teamID);
		this.setNumber(number);
		this.setPosition(position);
		this.setHit(hit);
		this.setBattingAverage(battingAverage);
		this.setoBP(oBP);
		this.setSlugging(slugging);
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public float getBattingAverage() {
		return battingAverage;
	}

	public void setBattingAverage(float battingAverage) {
		this.battingAverage = battingAverage;
	}

	public float getoBP() {
		return oBP;
	}

	public void setoBP(float oBP) {
		this.oBP = oBP;
	}

	public float getSlugging() {
		return slugging;
	}

	public void setSlugging(float slugging) {
		this.slugging = slugging;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	public Collection <AtBat> getAB(){
		if(ab == null) ab = dao.getAB(playerID);
		return ab;
	}
}
