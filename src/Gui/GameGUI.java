package Gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DAO.DatabaseManager;
import Model.Opponents;
import Model.Pitchers;
import Model.Players;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.util.Collection;
import java.util.ArrayList;

public class GameGUI {

	private JFrame frmGame;
	private JTextField spot1;
	private JTextField spot2;
	private JTextField spot3;
	private JTextField spot4;
	private JTextField spot5;
	private JTextField spot6;
	private JTextField spot7;
	private JTextField spot8;
	private JTextField spot9;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;
	private JTable table_7;
	private JTable table_8;
	private JTable table_9;
	private JTable table_10;
	private JTable table_11;
	MainMenu mainMenu;
	private static int gameID = 0;
	//static int opponentID;
	AddPitcherGUI pitcher;
	static DatabaseManager dbm;
	static ArrayList<Players> lineUP;
	static int spotInTheLineUP;
	//static int pitcherID;
	static Opponents opp;
	static Pitchers pp;
	static int opponentID;
	static int pitcherID;
	static int reportID;
	/**
	 * Launch the application.
	 */
	public static void newScreen(int game, int opponent,int pID,int rID) {
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				 gameID = game;
					opponentID = opponent;
					pitcherID = pID;
					reportID = rID;
				try{
					GameGUI window = new GameGUI();
					window.frmGame.setVisible(true);
					dbm = new DatabaseManager();
					lineUP = new ArrayList<Players>();
					spotInTheLineUP = 0;
					pp= new Pitchers();
					opp = new Opponents();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frmGame = new JFrame();
		frmGame.setTitle("Game");
		frmGame.setBounds(100, 100, 850, 705);
		frmGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGame.getContentPane().setLayout(null);
	
		System.out.println("This is the gameID + " + gameID);
		System.out.println("This is the pitcherID + " + pitcherID);
		System.out.println("This is the reportID + " + reportID);
		System.out.println("This is the opponentID + " + opponentID);
		
		
		
		JButton btnGameOver = new JButton("Game Over");
		btnGameOver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.newScreen1();
				frmGame.setVisible(false);
			}
		});
		btnGameOver.setBounds(6, 6, 117, 29);
		frmGame.getContentPane().add(btnGameOver);
		
		JLabel LineupLBl = new JLabel("Lineup");
		LineupLBl.setBounds(6, 68, 97, 16);
		frmGame.getContentPane().add(LineupLBl);
		
		spot1 = new JTextField();
		spot1.setBounds(6, 92, 130, 26);
		frmGame.getContentPane().add(spot1);
		spot1.setColumns(10);
		
		spot2 = new JTextField();
		spot2.setBounds(6, 130, 130, 26);
		frmGame.getContentPane().add(spot2);
		spot2.setColumns(10);
		
		spot3 = new JTextField();
		spot3.setBounds(6, 168, 130, 26);
		frmGame.getContentPane().add(spot3);
		spot3.setColumns(10);
		
		spot4 = new JTextField();
		spot4.setBounds(6, 206, 130, 26);
		frmGame.getContentPane().add(spot4);
		spot4.setColumns(10);
		
		spot5 = new JTextField();
		spot5.setBounds(6, 244, 130, 26);
		frmGame.getContentPane().add(spot5);
		spot5.setColumns(10);
		
		spot6 = new JTextField();
		spot6.setBounds(6, 282, 130, 26);
		frmGame.getContentPane().add(spot6);
		spot6.setColumns(10);
		
		spot7 = new JTextField();
		spot7.setBounds(6, 320, 130, 26);
		frmGame.getContentPane().add(spot7);
		spot7.setColumns(10);
		
		spot8 = new JTextField();
		spot8.setBounds(6, 358, 130, 26);
		frmGame.getContentPane().add(spot8);
		spot8.setColumns(10);
		
		spot9 = new JTextField();
		spot9.setBounds(6, 396, 130, 26);
		frmGame.getContentPane().add(spot9);
		spot9.setColumns(10);
		
		JButton btnSubmitLineup = new JButton("Submit Lineup");
		btnSubmitLineup.setBounds(6, 434, 117, 29);
		frmGame.getContentPane().add(btnSubmitLineup);
		btnSubmitLineup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstHitter = spot1.getText();
				String secondHitter = spot2.getText();
				String thirdHitter = spot3.getText();
				String fourthHitter = spot4.getText();
				String fifthHitter = spot5.getText();
				String sixthHitter = spot6.getText();
				String seventhHitter = spot7.getText();
				String eighthHitter = spot8.getText();
				String ninthHitter = spot9.getText();
				
				//code to get player from playerName;
				Players one = dbm.getPlayerByName(firstHitter);
				Players two = dbm.getPlayerByName(secondHitter);
				Players three = dbm.getPlayerByName(thirdHitter);
				Players four = dbm.getPlayerByName(fourthHitter);
				Players five = dbm.getPlayerByName(fifthHitter);
				Players six = dbm.getPlayerByName(sixthHitter);
				Players seven = dbm.getPlayerByName(seventhHitter);
				Players eight = dbm.getPlayerByName(eighthHitter);
				Players nine = dbm.getPlayerByName(ninthHitter);
			
				lineUP.add(one);
				lineUP.add(two);
				lineUP.add(three);
				lineUP.add(four);
				lineUP.add(five);
				lineUP.add(six);
				lineUP.add(seven);
				lineUP.add(eight);
				lineUP.add(nine);
			}
		});
		
		JLabel lblOpponent = new JLabel("Opponent");
		lblOpponent.setBounds(223, 11, 70, 16);
		frmGame.getContentPane().add(lblOpponent);
		
		JLabel lblPitcher = new JLabel("Pitcher");
		lblPitcher.setBounds(223, 47, 61, 16);
		frmGame.getContentPane().add(lblPitcher);
		
		JLabel opponentName = new JLabel("OpponentName");
		opponentName.setBounds(233, 29, 144, 16);
		frmGame.getContentPane().add(opponentName);
		
		JLabel lblPitcherName = new JLabel("PitcherName");
		lblPitcherName.setBounds(233, 68, 111, 16);
		frmGame.getContentPane().add(lblPitcherName);
		
		JLabel lblCount = new JLabel("Count");
		lblCount.setBounds(178, 97, 61, 16);
		frmGame.getContentPane().add(lblCount);
		
		JRadioButton radioButton = new JRadioButton("0-0");
		radioButton.setBounds(188, 116, 117, 23);
		frmGame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("0-1");
		radioButton_1.setBounds(188, 145, 97, 23);
		frmGame.getContentPane().add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("0-2");
		radioButton_2.setBounds(188, 169, 90, 23);
		frmGame.getContentPane().add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("1-0");
		radioButton_3.setBounds(304, 116, 141, 23);
		frmGame.getContentPane().add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("2-0");
		radioButton_4.setBounds(304, 145, 141, 23);
		frmGame.getContentPane().add(radioButton_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("3-0");
		rdbtnNewRadioButton.setBounds(304, 169, 141, 23);
		frmGame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton radioButton_5 = new JRadioButton("1-1");
		radioButton_5.setBounds(188, 193, 96, 23);
		frmGame.getContentPane().add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("2-2");
		radioButton_6.setBounds(304, 193, 141, 23);
		frmGame.getContentPane().add(radioButton_6);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2-1");
		rdbtnNewRadioButton_1.setBounds(188, 221, 90, 23);
		frmGame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton radioButton_7 = new JRadioButton("3-1");
		radioButton_7.setBounds(304, 221, 141, 23);
		frmGame.getContentPane().add(radioButton_7);
		
		JRadioButton radioButton_8 = new JRadioButton("1-2");
		radioButton_8.setBounds(188, 245, 84, 23);
		frmGame.getContentPane().add(radioButton_8);
		
		JRadioButton radioButton_9 = new JRadioButton("3-2");
		radioButton_9.setBounds(304, 245, 141, 23);
		frmGame.getContentPane().add(radioButton_9);
		
		JLabel lblPitch = new JLabel("Pitch");
		lblPitch.setBounds(178, 282, 61, 16);
		frmGame.getContentPane().add(lblPitch);
		
		JRadioButton rdbtnPitch = new JRadioButton("Pitch 1");
		rdbtnPitch.setBounds(188, 303, 141, 23);
		frmGame.getContentPane().add(rdbtnPitch);
		
		JRadioButton rdbtnPitch_1 = new JRadioButton("Pitch 2");
		rdbtnPitch_1.setBounds(188, 324, 141, 23);
		frmGame.getContentPane().add(rdbtnPitch_1);
		
		JRadioButton rdbtnPitch_2 = new JRadioButton("Pitch 3 ");
		rdbtnPitch_2.setBounds(188, 348, 141, 23);
		frmGame.getContentPane().add(rdbtnPitch_2);
		
		JRadioButton rdbtnPitch_3 = new JRadioButton("Pitch 4");
		rdbtnPitch_3.setBounds(188, 371, 141, 23);
		frmGame.getContentPane().add(rdbtnPitch_3);
		
		JLabel lblBallOrStrike = new JLabel("Ball or Strike");
		lblBallOrStrike.setBounds(178, 401, 90, 16);
		frmGame.getContentPane().add(lblBallOrStrike);
		
		JRadioButton rdbtnBall = new JRadioButton("Ball");
		rdbtnBall.setBounds(188, 418, 90, 23);
		frmGame.getContentPane().add(rdbtnBall);
		
		JRadioButton rdbtnStrike = new JRadioButton("Strike");
		rdbtnStrike.setBounds(304, 418, 79, 23);
		frmGame.getContentPane().add(rdbtnStrike);
		
		JButton btnPitch = new JButton("Pitch");
		btnPitch.setBounds(178, 445, 117, 29);
		frmGame.getContentPane().add(btnPitch);
		btnPitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double count = 1.1010;
				String ballStrike = null;
				String pitch = null;
				int pitchTypeCount = 0;
				int strikeBall = 0;
				int countsClicked = 0;
				int pitchesID = -1;
				if(radioButton.isSelected()){
					count = 0.0;
					countsClicked++;
				}
				if(radioButton_1.isSelected()){
					count = 0.1;
					countsClicked++;
				}
				if(radioButton_2.isSelected()){
					count = 0.2;
					countsClicked++;
				}
				if(radioButton_3.isSelected()){
					count = 1.0;
					countsClicked++;
				}
				if(radioButton_4.isSelected()){
					count = 2.0;
					countsClicked++;
				}
				if(rdbtnNewRadioButton.isSelected()){
					count = 3.0;
					countsClicked++;
				}
				if(radioButton_5.isSelected()){
					count = 1.1;
					countsClicked++;
				}
				if(radioButton_6.isSelected()){
					count = 2.2;
					countsClicked++;
				}
				if(rdbtnNewRadioButton_1.isSelected()){
					count = 2.1;
					countsClicked++;
				}
				if(radioButton_7.isSelected()){
					count = 3.1;
					countsClicked++;
				}
				if(radioButton_8.isSelected()){
					count = 1.2;
					countsClicked++;
				}
				if(radioButton_9.isSelected()){
					count = 3.2;
					countsClicked++;
				}
				if(rdbtnBall.isSelected()){
					ballStrike = "Ball";
					strikeBall++;
				}
				if(rdbtnBall.isSelected()){
					ballStrike = "Ball";
					strikeBall++;
				}
				if(rdbtnStrike.isSelected()){
					ballStrike = "Strike";
					strikeBall++;
				}
				if(rdbtnPitch.isSelected()){
					pitch = "Pitch1";
					pitchTypeCount++;
				}
				if(rdbtnPitch_1.isSelected()){
					pitch = "Pitch2";
					pitchTypeCount++;
				}
				if(rdbtnPitch_2.isSelected()){
					pitch = "Pitch3";
					pitchTypeCount++;
				}
				if(rdbtnPitch_3.isSelected()){
					pitch = "Pitch4";
					pitchTypeCount++;
				}
				if(countsClicked == 1 && pitchTypeCount == 1 && strikeBall == 1){
					for(int i = 0; i<100000; i++){
						if(dbm.findPitch(i)== null){
							pitchesID = i;
						}
					}
			
					
					dbm.insertPitch(pitchesID, reportID, count, pitch, ballStrike);
				}
			}
		});
		
		JLabel lblAtBatResult = new JLabel("At Bat Result");
		lblAtBatResult.setBounds(178, 478, 90, 16);
		frmGame.getContentPane().add(lblAtBatResult);
		
		JRadioButton rdbtnHit = new JRadioButton("Single");
		rdbtnHit.setBounds(188, 506, 90, 23);
		frmGame.getContentPane().add(rdbtnHit);
		
		JRadioButton rdbtnOut = new JRadioButton("Double");
		rdbtnOut.setBounds(292, 506, 79, 23);
		frmGame.getContentPane().add(rdbtnOut);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Triple");
		rdbtnNewRadioButton_2.setBounds(188, 529, 84, 23);
		frmGame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnHbp = new JRadioButton("HomeRun");
		rdbtnHbp.setBounds(292, 529, 141, 23);
		frmGame.getContentPane().add(rdbtnHbp);
		
		JRadioButton rdbtnOut_1 = new JRadioButton("Out");
		rdbtnOut_1.setBounds(188, 550, 84, 23);
		frmGame.getContentPane().add(rdbtnOut_1);
		
		JRadioButton rdbtnWalk = new JRadioButton("Walk");
		rdbtnWalk.setBounds(292, 550, 141, 23);
		frmGame.getContentPane().add(rdbtnWalk);
		
		JRadioButton rdbtnHbp_1 = new JRadioButton("HBP");
		rdbtnHbp_1.setBounds(188, 573, 70, 23);
		frmGame.getContentPane().add(rdbtnHbp_1);
		
		JRadioButton rdbtnError = new JRadioButton("Error");
		rdbtnError.setBounds(292, 573, 141, 23);
		frmGame.getContentPane().add(rdbtnError);
		
		JButton btnAtbat = new JButton("AtBat");
		btnAtbat.setBounds(178, 597, 117, 29);
		frmGame.getContentPane().add(btnAtbat);
		btnAtbat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numSelected = 0;
				String result2 = null;
				if(rdbtnHit.isSelected()){
					result2 = "Single";
					numSelected++;
				}
				if(rdbtnOut.isSelected()){
					result2 = "Double";
					numSelected++;
				}
				if(rdbtnNewRadioButton_2.isSelected()){
					result2 = "Triple";
					numSelected++;
				}
				if(rdbtnHbp.isSelected()){
					result2 = "HomeRun";
					numSelected++;
				}
				if(rdbtnOut_1.isSelected()){
					result2 = "Out";
					numSelected++;
				}
				if(rdbtnWalk.isSelected()){
					result2 = "Walk";
					numSelected++;
				}
				if(rdbtnHbp_1.isSelected()){
					result2 = "HBP";
					numSelected++;
				}
				if(rdbtnError.isSelected()){
					result2 = "Error";
					numSelected++;
				}
				if(numSelected == 1){
					int ab = 0;
					for(int i = 0; i<100000; i++){
						if(dbm.findAtBat(i) == null){
							ab = i;
						}
					}
					int playerIdent = lineUP.get(spotInTheLineUP).getPlayerID();
					if(spotInTheLineUP == 8){
						spotInTheLineUP = 0;
					}
					else{
						spotInTheLineUP++;
					}
					
					//get PitcherID 
					
					
					
					//get gameID
					
					
					
					dbm.insertAtBat(ab, playerIdent, pitcherID, gameID, result2);
				}
			}
		});
		
		JLabel lblTendency = new JLabel("Tendency");
		lblTendency.setBounds(377, 97, 79, 16);
		frmGame.getContentPane().add(lblTendency);
		
		JLabel label = new JLabel("0-0");
		label.setBounds(384, 120, 61, 16);
		frmGame.getContentPane().add(label);
		
		table = new JTable();
		table.setBounds(387, 136, 211, 52);
		frmGame.getContentPane().add(table);
		
		JLabel label_1 = new JLabel("0-1");
		label_1.setBounds(384, 197, 61, 16);
		frmGame.getContentPane().add(label_1);
		
		table_1 = new JTable();
		table_1.setBounds(387, 212, 211, 52);
		frmGame.getContentPane().add(table_1);
		
		JLabel label_2 = new JLabel("1-2");
		label_2.setBounds(384, 266, 61, 16);
		frmGame.getContentPane().add(label_2);
		
		table_2 = new JTable();
		table_2.setBounds(387, 283, 211, 52);
		frmGame.getContentPane().add(table_2);
		
		table_3 = new JTable();
		table_3.setBounds(387, 364, 211, 52);
		frmGame.getContentPane().add(table_3);
		
		JLabel label_3 = new JLabel("2-1");
		label_3.setBounds(384, 341, 61, 16);
		frmGame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("3-0");
		label_4.setBounds(384, 422, 61, 16);
		frmGame.getContentPane().add(label_4);
		
		table_4 = new JTable();
		table_4.setBounds(387, 440, 211, 52);
		frmGame.getContentPane().add(table_4);
		
		JLabel label_5 = new JLabel("0-2");
		label_5.setBounds(384, 501, 61, 16);
		frmGame.getContentPane().add(label_5);
		
		table_5 = new JTable();
		table_5.setBounds(387, 521, 211, 52);
		frmGame.getContentPane().add(table_5);
		
		table_6 = new JTable();
		table_6.setBounds(620, 136, 211, 52);
		frmGame.getContentPane().add(table_6);
		
		table_7 = new JTable();
		table_7.setBounds(620, 212, 211, 52);
		frmGame.getContentPane().add(table_7);
		
		table_8 = new JTable();
		table_8.setBounds(620, 282, 211, 52);
		frmGame.getContentPane().add(table_8);
		
		table_9 = new JTable();
		table_9.setBounds(620, 364, 211, 52);
		frmGame.getContentPane().add(table_9);
		
		table_10 = new JTable();
		table_10.setBounds(620, 440, 211, 52);
		frmGame.getContentPane().add(table_10);
		
		table_11 = new JTable();
		table_11.setBounds(620, 521, 211, 52);
		frmGame.getContentPane().add(table_11);
		
		JLabel label_6 = new JLabel("1-0");
		label_6.setBounds(620, 120, 61, 16);
		frmGame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("1-1");
		label_7.setBounds(620, 193, 61, 16);
		frmGame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("2-2");
		label_8.setBounds(620, 266, 61, 16);
		frmGame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("3-1");
		label_9.setBounds(620, 348, 61, 16);
		frmGame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("2-0");
		label_10.setBounds(620, 422, 61, 16);
		frmGame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("3-2");
		label_11.setBounds(620, 501, 61, 16);
		frmGame.getContentPane().add(label_11);
		
		JButton btnCalculateTendency = new JButton("Calculate Tendency");
		btnCalculateTendency.setBounds(540, 597, 151, 29);
		frmGame.getContentPane().add(btnCalculateTendency);
		btnCalculateTendency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnNewPitcher = new JButton("New Pitcher");
		btnNewPitcher.setBounds(6, 34, 117, 29);
		frmGame.getContentPane().add(btnNewPitcher);
		btnNewPitcher.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			pitcher.newScreen2(opponentID,gameID);
		}
	});
}
}