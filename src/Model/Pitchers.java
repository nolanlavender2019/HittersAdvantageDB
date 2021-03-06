package Model;

import java.util.Collection;

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
	
	private Collection<AtBat> ab;
	private Collection<Report> report;

	public Pitchers(PitchersDAO dao, int pID, String name, int teamID, String handness, String pitch1, String pitch2, String pitch3, String pitch4){
		this.dao = dao;
		this.setPitcherID(pID);
		this.setPitcherName(name);
		this.setTeamID(teamID);
		this.setHandness(handness);
		this.setPitch1(pitch1);
		this.setPitch2(pitch2);
		this.setPitch3(pitch3);
		this.setPitch4(pitch4);
	}
	public Pitchers(){
		pitcherID=-4;
		pitcherName=null;
		teamID=-2;
		handness= null;
		String pitch1= null;
		String pitch2= null;
		String pitch3= null;
		String pitch4= null;
	}
	
	public String toString() {
		return pitcherName + " Handness = " + handness + " Pitch1 = " + pitch1 + " Pitch2 =" + pitch2 + " Pitch3 = " + pitch3 + " Pitch4 =" + pitch4;
	}

	public int getPitcherID() {
		return pitcherID;
	}

	public void setPitcherID(int pitcherID) {
		this.pitcherID = pitcherID;
	}

	public String getPitcherName() {
		return pitcherName;
	}

	public void setPitcherName(String pitcherName) {
		this.pitcherName = pitcherName;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public String getHandness() {
		return handness;
	}

	public void setHandness(String handness) {
		this.handness = handness;
	}

	public String getPitch1() {
		return pitch1;
	}

	public void setPitch1(String pitch1) {
		this.pitch1 = pitch1;
	}

	public String getPitch2() {
		return pitch2;
	}

	public void setPitch2(String pitch2) {
		this.pitch2 = pitch2;
	}

	public String getPitch3() {
		return pitch3;
	}

	public void setPitch3(String pitch3) {
		this.pitch3 = pitch3;
	}

	public String getPitch4() {
		return pitch4;
	}

	public void setPitch4(String pitch4) {
		this.pitch4 = pitch4;
	}
	public Collection <AtBat> getAB(){
		if(ab == null) ab = dao.getAB(pitcherID);
		return ab;
	}
	public Collection <Report> getReport(){
		if(report == null) report = dao.getReport(pitcherID);
		return report;
	}
}
