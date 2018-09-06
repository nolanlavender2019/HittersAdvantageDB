package Model;

import DAO.PitchersDAO;

public class Pitchers {
	
	private PitchersDAO dao;
	private int pitcherID;
	private String pitcherName;
	private int teamID;
	private String handness;
	private String pitch1;
	private String pitch2;
	private String pitch3;
	private String pitch4;

	public Pitchers(PitchersDAO dao, int pID, String name, int teamID, String handness, String pitch1, String pitch2, String pitch3, String pitch4){
		this.dao = dao;
		this.pitcherID = pID;
		this.pitcherName = name;
		this.teamID = teamID;
		this.handness = handness;
		this.pitch1 = pitch1;
		this.pitch2 = pitch2;
		this.pitch3 = pitch3;
		this.pitch4 = pitch4;
	}
	
	
}
