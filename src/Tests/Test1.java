package Tests;
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
		dbm.commit();
		Players votto = dbm.insertPlayers(1,"Joey Votto",1, 19, "1st Base", "Left", .300f, .450f,.451f);
		Opponents tigers = dbm.insertOpponent(3,"Tigers");
		Pitchers degrom = dbm.insertPitchers(4,"Jacob DeGrom", 3, "Right", "Fastball","Curveball", "Changeup", "Slider");
		Pitch firstP = dbm.insertPitch(1,001, 01,"Fastball","Strike");
		AtBat ab = dbm.insertAtBat(002, 1,4,003, "Homerun");
		Game interLeague = dbm.insertGame(003, 1,3);
		Report rp1 = dbm.insertReport(001, 003,4);
		
		dbm.commit();
		
		System.out.print(dbm.findTeam(1));
		
		System.out.print("done");
		dbm.close();
	}

}
