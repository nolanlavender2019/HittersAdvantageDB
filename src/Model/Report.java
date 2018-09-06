package Model;

import DAO.ReportDAO;

public class Report {
	
	private ReportDAO dao;
	int reportID;
	private int gameID;
	private int pitcherID;
	private int pitchID;
	
	public Report(ReportDAO dao, int reportID, int gameID, int pitcherID, int pitchID){
		this.dao = dao;
		this.reportID = reportID;
		this.setGameID(gameID);
		this.setPitcherID(pitcherID);
		this.setPitchID(pitchID);
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public int getPitcherID() {
		return pitcherID;
	}

	public void setPitcherID(int pitcherID) {
		this.pitcherID = pitcherID;
	}

	public int getPitchID() {
		return pitchID;
	}

	public void setPitchID(int pitchID) {
		this.pitchID = pitchID;
	}
}
