package Gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.DatabaseManager;
import Model.Opponents;
import Model.Pitchers;
import Model.Players;

import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
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
	static Pitchers pitcher2;
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
	
		String[] columnNames = {"Fastball, Curveball, Slider, Changeup"};
		
		JLabel lblPitcherName = new JLabel("PitcherName");
		JLabel opponentName = new JLabel("OpponentName");
		JRadioButton rdbtnPitch = new JRadioButton("Pitch 1");
		JRadioButton rdbtnPitch_1 = new JRadioButton("Pitch 2");
		JRadioButton rdbtnPitch_2 = new JRadioButton("Pitch 3 ");
		JRadioButton rdbtnPitch_3 = new JRadioButton("Pitch 4 ");
		
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
				
				pitcher2 = dbm.findPitcher(pitcherID);
				String name = pitcher2.getPitcherName();
				lblPitcherName.setText(name);
				String name2 = dbm.findOpponents(opponentID).getTeamName();
				opponentName.setText(name2);
				rdbtnPitch.setText(pitcher2.getPitch1());
				rdbtnPitch_1.setText(pitcher2.getPitch2());
				rdbtnPitch_2.setText(pitcher2.getPitch3());
				rdbtnPitch_3.setText(pitcher2.getPitch4());
				
			}
		});
		
		JLabel lblOpponent = new JLabel("Opponent");
		lblOpponent.setBounds(223, 11, 70, 16);
		frmGame.getContentPane().add(lblOpponent);
		
		JLabel lblPitcher = new JLabel("Pitcher");
		lblPitcher.setBounds(223, 47, 61, 16);
		frmGame.getContentPane().add(lblPitcher);
		
		//JLabel opponentName = new JLabel("OpponentName");
		opponentName.setBounds(233, 29, 144, 16);
		frmGame.getContentPane().add(opponentName);
		
		//JLabel lblPitcherName = new JLabel("PitcherName");
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
		
		//JRadioButton rdbtnPitch = new JRadioButton("Pitch 1");
		
		rdbtnPitch.setBounds(188, 303, 141, 23);
		frmGame.getContentPane().add(rdbtnPitch);
		
		//JRadioButton rdbtnPitch_1 = new JRadioButton("Pitch 2");
		rdbtnPitch_1.setBounds(188, 324, 141, 23);
		frmGame.getContentPane().add(rdbtnPitch_1);
		
		//JRadioButton rdbtnPitch_2 = new JRadioButton("Pitch 3 ");
		rdbtnPitch_2.setBounds(188, 348, 141, 23);
		frmGame.getContentPane().add(rdbtnPitch_2);
		
		//JRadioButton rdbtnPitch_3 = new JRadioButton("Pitch 4");
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
				String count = null;
				String ballStrike = null;
				String pitch = null;
				int pitchTypeCount = 0;
				int strikeBall = 0;
				int countsClicked = 0;
				int pitchesID = -1;
				if(radioButton.isSelected()){
					count = "0.0";
					countsClicked++;
				}
				if(radioButton_1.isSelected()){
					count = "0.1";
					countsClicked++;
				}
				if(radioButton_2.isSelected()){
					count = "0.2";
					countsClicked++;
				}
				if(radioButton_3.isSelected()){
					count = "1.0";
					countsClicked++;
				}
				if(radioButton_4.isSelected()){
					count = "2.0";
					countsClicked++;
				}
				if(rdbtnNewRadioButton.isSelected()){
					count = "3.0";
					countsClicked++;
				}
				if(radioButton_5.isSelected()){
					count = "1.1";
					countsClicked++;
				}
				if(radioButton_6.isSelected()){
					count = "2.2";
					countsClicked++;
				}
				if(rdbtnNewRadioButton_1.isSelected()){
					count = "2.1";
					countsClicked++;
				}
				if(radioButton_7.isSelected()){
					count = "3.1";
					countsClicked++;
				}
				if(radioButton_8.isSelected()){
					count = "1.2";
					countsClicked++;
				}
				if(radioButton_9.isSelected()){
					count = "3.2";
					countsClicked++;
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
					pitch = rdbtnPitch.getText();
					pitchTypeCount++;
				}
				if(rdbtnPitch_1.isSelected()){
					pitch = rdbtnPitch_1.getText();
					pitchTypeCount++;
				}
				if(rdbtnPitch_2.isSelected()){
					pitch = rdbtnPitch_2.getText();
					pitchTypeCount++;
				}
				if(rdbtnPitch_3.isSelected()){
					pitch = rdbtnPitch_3.getText();
					pitchTypeCount++;
				}
				if(countsClicked == 1 && pitchTypeCount == 1 && strikeBall == 1){
					for(int i = 0; i<100000; i++){
						if(dbm.findPitch(i)== null){
							pitchesID = i;
							break;
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
							break;
						}
					}System.out.println(ab);
					
					int playerIdent = lineUP.get(spotInTheLineUP).getPlayerID();
					System.out.println(playerIdent);
					if(spotInTheLineUP == 8){
						spotInTheLineUP = 0;
					}
					else{
						spotInTheLineUP++;
					}
					
					System.out.println(pitcherID + gameID + result2);
					dbm.insertAtBat(ab, playerIdent, pitcherID, gameID, result2);
					dbm.commit();
				}
			}
		});
		
		JLabel lblTendency = new JLabel("Tendency");
		lblTendency.setBounds(377, 97, 79, 16);
		frmGame.getContentPane().add(lblTendency);
		
		JLabel label = new JLabel("0-0");
		label.setBounds(384, 120, 61, 16);
		frmGame.getContentPane().add(label);
		
		DefaultTableModel modelOhOh = new DefaultTableModel();
		table = new JTable(modelOhOh);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(387, 136, 211, 52);
		frmGame.getContentPane().add(js);
		//modelOhOh.addColumn("0-0");
		modelOhOh.addColumn("Fastball");
		modelOhOh.addColumn("Curveball");
		modelOhOh.addColumn("Slider");
		modelOhOh.addColumn("ChangeUp");
		
		JLabel label_1 = new JLabel("0-1");
		label_1.setBounds(384, 197, 61, 16);
		frmGame.getContentPane().add(label_1);
		
		DefaultTableModel modelOhOne = new DefaultTableModel();
		table_1 = new JTable(modelOhOne);
		JScrollPane js1 = new JScrollPane(table_1);
		js1.setBounds(387, 212, 211, 52);
		frmGame.getContentPane().add(js1);
		//modelOhOne.addColumn("0-1");
		modelOhOne.addColumn("Fastball");
		modelOhOne.addColumn("Curveball");
		modelOhOne.addColumn("Slider");
		modelOhOne.addColumn("ChangeUp");
		
		JLabel label_2 = new JLabel("1-2");
		label_2.setBounds(384, 266, 61, 16);
		frmGame.getContentPane().add(label_2);
		
		DefaultTableModel modelOneTwo = new DefaultTableModel();
		table_2 = new JTable(modelOneTwo);
		JScrollPane js2 = new JScrollPane(table_2);
		js2.setBounds(387, 283, 211, 52);
		frmGame.getContentPane().add(js2);
		//modelOneTwo.addColumn("1-2");
		modelOneTwo.addColumn("Fastball");
		modelOneTwo.addColumn("Curveball");
		modelOneTwo.addColumn("Slider");
		modelOneTwo.addColumn("ChangeUp");
		
		DefaultTableModel modelTwoOne = new DefaultTableModel();
		table_3 = new JTable(modelTwoOne);
		JScrollPane js3 = new JScrollPane(table_3);
		js3.setBounds(387, 364, 211, 52);
		frmGame.getContentPane().add(js3);
		//modelTwoOne.addColumn("2-1");
		modelTwoOne.addColumn("Fastball");
		modelTwoOne.addColumn("Curveball");
		modelTwoOne.addColumn("Slider");
		modelTwoOne.addColumn("ChangeUp");
		
		JLabel label_3 = new JLabel("2-1");
		label_3.setBounds(384, 341, 61, 16);
		frmGame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("3-0");
		label_4.setBounds(384, 422, 61, 16);
		frmGame.getContentPane().add(label_4);
		
		DefaultTableModel modelThreeOh = new DefaultTableModel();
		table_4 = new JTable(modelThreeOh);
		JScrollPane js4 = new JScrollPane(table_4);
		js4.setBounds(387, 440, 211, 52);
		frmGame.getContentPane().add(js4);
		//modelThreeOh.addColumn("3-0");
		modelThreeOh.addColumn("Fastball");
		modelThreeOh.addColumn("Curveball");
		modelThreeOh.addColumn("Slider");
		modelThreeOh.addColumn("ChangeUp");
		
		JLabel label_5 = new JLabel("0-2");
		label_5.setBounds(384, 501, 61, 16);
		frmGame.getContentPane().add(label_5);
		
		DefaultTableModel modelOhTwo = new DefaultTableModel();
		table_5 = new JTable(modelOhTwo);
		JScrollPane js5 = new JScrollPane(table_5);
		js5.setBounds(387, 521, 211, 52);
		frmGame.getContentPane().add(js5);
		//modelOhTwo.addColumn("0-2");
		modelOhTwo.addColumn("Fastball");
		modelOhTwo.addColumn("Curveball");
		modelOhTwo.addColumn("Slider");
		modelOhTwo.addColumn("ChangeUp");
		
		DefaultTableModel modelOneOh = new DefaultTableModel();
		table_6 = new JTable(modelOneOh);
		JScrollPane js6 = new JScrollPane(table_6);
		js6.setBounds(620, 136, 211, 52);
		frmGame.getContentPane().add(js6);
		//modelOneOh.addColumn("1-0");
		modelOneOh.addColumn("Fastball");
		modelOneOh.addColumn("Curveball");
		modelOneOh.addColumn("Slider");
		modelOneOh.addColumn("ChangeUp");
		
		DefaultTableModel modelOneOne = new DefaultTableModel();
		table_7 = new JTable(modelOneOne);
		JScrollPane js7 = new JScrollPane(table_7);
		js7.setBounds(620, 212, 211, 52);
		frmGame.getContentPane().add(js7);
		//modelOneOne.addColumn("1-1"); 
		modelOneOne.addColumn("Fastball");
		modelOneOne.addColumn("Curveball");
		modelOneOne.addColumn("Slider");
		modelOneOne.addColumn("ChangeUp");
		
		DefaultTableModel modelTwoTwo = new DefaultTableModel();
		table_8 = new JTable(modelTwoTwo);
		JScrollPane js8 = new JScrollPane(table_8);
		js8.setBounds(620, 282, 211, 52);
		frmGame.getContentPane().add(js8);
		//modelTwoTwo.addColumn("2-2");
		modelTwoTwo.addColumn("Fastball");
		modelTwoTwo.addColumn("Curveball");
		modelTwoTwo.addColumn("Slider");
		modelTwoTwo.addColumn("ChangeUp");
		
		DefaultTableModel modelThreeOne = new DefaultTableModel();
		table_9 = new JTable(modelThreeOne);
		JScrollPane js9 = new JScrollPane(table_9);
		js9.setBounds(620, 364, 211, 52);
		frmGame.getContentPane().add(js9);
		//modelThreeOne.addColumn("3-1");
		modelThreeOne.addColumn("Fastball");
		modelThreeOne.addColumn("Curveball");
		modelThreeOne.addColumn("Slider");
		modelThreeOne.addColumn("ChangeUp");
		
		DefaultTableModel modelTwoOh = new DefaultTableModel();
		table_10 = new JTable(modelTwoOh);
		JScrollPane js10 = new JScrollPane(table_10);
		//table_10.setBounds(620, 440, 211, 52);
		js10.setBounds(620,440,211,52);
		//modelTwoOh.addColumn("2-0");
		modelTwoOh.addColumn("Fastball");
		modelTwoOh.addColumn("Curveball");
		modelTwoOh.addColumn("Slider");
		modelTwoOh.addColumn("ChangeUp");
		//frmGame.getContentPane().add(table_10);
		table_10.setFillsViewportHeight(true);
		frmGame.getContentPane().add(js10);
		

		
		DefaultTableModel modelFull = new DefaultTableModel();
		table_11 = new JTable(modelFull);
		JScrollPane js11 = new JScrollPane(table_11);
		js11.setBounds(620, 521, 211, 52);
		frmGame.getContentPane().add(js11);
		modelFull.addColumn("Fastball");
		modelFull.addColumn("Curveball");
		modelFull.addColumn("Slider");
		modelFull.addColumn("ChangeUp");
		
		
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
		
				ArrayList<Double> ohoh = dbm.getPitchTendency(reportID,"0.0");
				Double[] objs1 = {ohoh.get(0), ohoh.get(1), ohoh.get(2), ohoh.get(3)};
				modelOhOh.addRow(objs1);
				ArrayList<Double> ohOne = dbm.getPitchTendency(reportID,"0.1");
				Double[] objs2 = {ohOne.get(0), ohOne.get(1), ohOne.get(2), ohOne.get(3)};
				modelOhOne.addRow(objs2);
				ArrayList<Double> ohTwo = dbm.getPitchTendency(reportID, "0.2");
				Double[] objs3 = {ohTwo.get(0), ohTwo.get(1), ohTwo.get(2), ohTwo.get(3)};
				modelOhTwo.addRow(objs3);
				ArrayList<Double> oneOh = dbm.getPitchTendency(reportID,"1.0");
				Double[] objs4 = {oneOh.get(0), oneOh.get(1), oneOh.get(2), oneOh.get(3)};
				modelOneOh.addRow(objs4);
				ArrayList<Double> oneOne = dbm.getPitchTendency(reportID,"1.1");
				Double[] objs5 = {oneOne.get(0), oneOne.get(1), oneOne.get(2), oneOne.get(3)};
				modelOneOne.addRow(objs5);
				ArrayList<Double> twoOh = dbm.getPitchTendency(reportID,"2.0");
				Double[] objs6 = {twoOh.get(0), twoOh.get(1), twoOh.get(2), twoOh.get(3)};
				modelTwoOh.addRow(objs6);
				ArrayList<Double> threeOh = dbm.getPitchTendency(reportID,"3.0");
				Double[] objs7 = {threeOh.get(0), threeOh.get(1), threeOh.get(2), threeOh.get(3)};
				modelThreeOh.addRow(objs7);
				ArrayList<Double> twoOne = dbm.getPitchTendency(reportID,"2.1");
				Double[] objs8 = {twoOne.get(0), twoOne.get(1), twoOne.get(2), twoOne.get(3)};
				modelTwoOne.addRow(objs8);
				ArrayList<Double> twoTwo = dbm.getPitchTendency(reportID,"2.2");
				Double[] objs9 = {twoTwo.get(0), twoTwo.get(1), twoTwo.get(2), twoTwo.get(3)};
				modelTwoTwo.addRow(objs9);
				ArrayList<Double> oneTwo = dbm.getPitchTendency(reportID,"1.2");
				Double[] objs10 = {oneTwo.get(0), oneTwo.get(1), oneTwo.get(2), oneTwo.get(3)};
				modelOneTwo.addRow(objs10);
				ArrayList<Double> threeTwo = dbm.getPitchTendency(reportID,"3.2");
				Double[] objs = {threeTwo.get(0), threeTwo.get(1), threeTwo.get(2), threeTwo.get(3)};
				modelFull.addRow(objs);
				ArrayList<Double> threeOne = dbm.getPitchTendency(reportID,"3.1");
				Double[] objs11 = {threeOne.get(0), threeOne.get(1), threeOne.get(2), threeOne.get(3)};
				modelThreeOne.addRow(objs11);
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