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
		this.setAbID(abID);
		this.playerID = playerID;
		this.setPitcherID(pitcherID);
		this.setGameID(gameID);
		this.setResult(result);
	}
	public String toString() {
		return "ABID = " + abID + " PlayerID = " + playerID + " PitcherID = " + pitcherID + " Result= " + result + " GameID = " + gameID;
	}
	public int getPlayerID(){
		return playerID;
	}

	public int getAbID() {
		return abID;
	}

	public void setAbID(int abID) {
		this.abID = abID;
	}

	public int getPitcherID() {
		return pitcherID;
	}

	public void setPitcherID(int pitcherID) {
		this.pitcherID = pitcherID;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
}
