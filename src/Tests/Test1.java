package Tests;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;

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
		Players votto2 = dbm.insertPlayers(2,"Billy Hamilton",1, 19, "CF", "Switch", .300f, .450f,.451f);
		Players votto = dbm.insertPlayers(1,"Joey Votto",1, 19, "1st Base", "Left", .300f, .450f,.451f);
		Opponents tigers = dbm.insertOpponent(3,"Tigers");
		Opponents cubs = dbm.insertOpponent(4, "Cubs");
		Pitchers degrom = dbm.insertPitchers(4,"Jacob DeGrom", 3, "Right", "Fastball","Curveball", "Changeup", "Slider");
		Pitchers degrom1 = dbm.insertPitchers(5,"Jake Arrieta", 3, "Right", "Fastball","Curveball", "Changeup", "Slider");
		Pitch firstP = dbm.insertPitch(1,001, 0.0,"Fastball","Strike");
		Pitch firstP1 = dbm.insertPitch(2,001, 0.1,"Curveball","ball");
		Pitch firstP2 = dbm.insertPitch(3,001, 1.1, "Slider","ball");
		Pitch firstP3 = dbm.insertPitch(4,001, 2.1,"Fastball","Strike");
		Pitch firstP4 = dbm.insertPitch(1,001, 2.2,"ChangeUP","Strike");
		AtBat ab = dbm.insertAtBat(2, 1,4,003, "Homerun");
		AtBat ab1 = dbm.insertAtBat(1, 1,4,003, "FlyOut");
		AtBat ab2 = dbm.insertAtBat(003, 2,5,003, "StrikeOut");
		Game interLeague = dbm.insertGame(003, 1,3);
		Game interLeague1 = dbm.insertGame(004, 1,4);
		Report rp1 = dbm.insertReport(001, 003,4);
		Report rp2 = dbm.insertReport(002, 003, 4);
		
		dbm.commit();
		
		System.out.println("\nGetting ABs from games");
		Collection<AtBat> team = interLeague.getAB();
		for(AtBat stat: team){
			System.out.println(stat);
		}
		
		System.out.println("\nGeting games from Team");
		Collection<Game> team1 = reds.getGame();
		for(Game stat: team1){
			System.out.println(stat);
		}
		
		System.out.println("\nGeting Players from Team");
		Collection<Players> team11 = reds.getPlayers();
		for(Players stat: team11){
			System.out.println(stat);
		}
		
		System.out.println("\nGeting Report from Game");
		Collection<Report> team12 = interLeague.getReport();
		for(Report stat: team12){
			System.out.println(stat);
		}
		
		System.out.println("\nGeting Pitch from Report");
		Collection<Pitch> team13 = rp1.getPitch();
		for(Pitch stat: team13){
			System.out.println(stat);
		}
		
		System.out.println("\nGeting Pitcher from Opponents");
		Collection<Pitchers> team14 = tigers.getPitcher();
		for(Pitchers stat: team14){
			System.out.println(stat);
		}
		
		System.out.println("\nGeting AtBat from Player");
		Collection<AtBat> team15 = votto.getAB();
		for(AtBat stat: team15){
			System.out.println(stat);
		}
		
		System.out.println("\nGeting Report from Pitcher");
		Collection<Report> team16 = degrom.getReport();
		for(Report stat: team16){
			System.out.println(stat);
		}
		
		System.out.println("\nGeting AtBat from Pitcher");
		Collection<AtBat> team17 = degrom.getAB();
		for(AtBat stat: team17){
			System.out.println(stat);
		}
		
		System.out.println("\nGeting Games from Opponents");
		Collection<Game> team18 = cubs.getGame();
		for(Game stat: team18){
			System.out.println(stat);
		}
	
		
		
		
		System.out.print("\nCount from firstP1 " + firstP1.getCount());
		System.out.print("\ndone\n");
		dbm.commit();
		dbm.close();
	}
	
}
