package Model;

import DAO.PitchDAO;

public class Pitch {
	
	private PitchDAO dao;
	private int pitchID;
	private int reportID;
	private String count;
	private String type;
	private String ballOrStrike;
	
	public Pitch(PitchDAO dao, int pitchID, int reportID, String count, String type, String ballOrStrike){
		this.dao = dao;
		this.pitchID = pitchID;
		this.reportID = reportID;
		this.count = count;
		this.type = type;
		this.ballOrStrike = ballOrStrike;
		
	}
}
