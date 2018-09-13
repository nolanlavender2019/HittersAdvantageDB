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
		Players Votto = dbm.insertPlayers(1,1,"Joey Votto", 19, "1st Base", "Left", .300f, .450f,.451f);
		
	}

}
