package Tests;
import java.util.Collection;

import DAO.DatabaseManager;
import Model.Team;
import Model.AtBat;
import Model.Game;
import Model.Opponents;
import Model.Pitch;
import Model.Pitchers;
import Model.Players;
import Model.Report;
public class Test1 {
	
	public static void main(String[] args){
		
		DatabaseManager dbm = new DatabaseManager();
		
		dbm.clearTables();
		
		
		Team reds = dbm.insertTeam(1, "Reds");
		Players votto = dbm.insertPlayers(1,"Joey Votto",1, 19, "1st Base", "Left", .300f, .450f,.451f);
		Opponents tigers = dbm.insertOpponent(3,"Tigers");
		Pitchers degrom = dbm.insertPitchers(4,"Jacob DeGrom", 3, "Right", "Fastball","Curveball", "Changeup", "Slider");
		Pitch firstP = dbm.insertPitch(1,001, 00,"Fastball","Strike");
		Pitch firstP1 = dbm.insertPitch(2,001, 01,"Curveball","ball");
		Pitch firstP2 = dbm.insertPitch(3,001, 11, "Slider","ball");
		Pitch firstP3 = dbm.insertPitch(4,001, 21,"Fastball","Strike");
		Pitch firstP4 = dbm.insertPitch(1,001, 22,"ChangeUP","Strike");
		AtBat ab = dbm.insertAtBat(002, 1,4,003, "Homerun");
		Game interLeague = dbm.insertGame(003, 1,3);
		Report rp1 = dbm.insertReport(001, 003,4);
		
		dbm.commit();
		
		Collection<Pitch> team = rp1.getPitch();
		for(Pitch stat: team){
			System.out.println(stat);
		}
		
		System.out.print("done");
		//dbm.close();
	}
	
}
