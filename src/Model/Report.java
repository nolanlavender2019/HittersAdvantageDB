package Model;

import java.util.Collection;

import DAO.ReportDAO;

public class Report {
	
	private ReportDAO dao;
	int reportID;
	private int gameID;
	private int pitcherID;
	private Collection<Pitch> pitch;
	
	public Report(ReportDAO dao, int reportID, int gameID, int pitcherID){
		this.dao = dao;
		this.reportID = reportID;
		this.setGameID(gameID);
		this.setPitcherID(pitcherID);
		//this.setPitchID(pitchID);
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

	
	public Collection <Pitch> getPitch(){
		if(pitch == null) pitch = dao.getPitch(reportID);
		return pitch;
	}
}
