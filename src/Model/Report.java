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
		this.gameID = gameID;
		this.pitcherID = pitcherID;
		this.pitchID = pitchID;
	}
}
