package Model;

import DAO.PitchDAO;

public class Pitch {
	
	private PitchDAO dao;
	private int pitchID;
	private int reportID;
	private String count;
	private String type;
	private String ballOrStrike;
	
	public Pitch(PitchDAO dao, int pitchID, int reportID, String d, String type, String ballOrStrike){
		this.dao = dao;
		this.setPitchID(pitchID);
		this.setReportID(reportID);
		this.setCount(d);
		this.setType(type);
		this.setBallOrStrike(ballOrStrike);
		
	}

	public String toString() {
		return type + " count = " + count + " " + ballOrStrike + " PitchID = " + pitchID + " ReportID = "+ reportID;
	}
	public int getPitchID() {
		return pitchID;
	}

	public void setPitchID(int pitchID) {
		this.pitchID = pitchID;
	}

	public int getReportID() {
		return reportID;
	}

	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBallOrStrike() {
		return ballOrStrike;
	}

	public void setBallOrStrike(String ballOrStrike) {
		this.ballOrStrike = ballOrStrike;
	}
}
