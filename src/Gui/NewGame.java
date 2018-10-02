package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import DAO.DatabaseManager;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewGame {

	private JFrame frmNewGame;
	private JTextField textField;
	private JTextField textField_2;
	MainMenu mainMenu;
	public static DatabaseManager dbm;
	private JTextField pitch1;
	private JTextField pitch2;
	private JTextField pitch3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField pitch4;
	private JTextField hand;
	static GameGUI game;
	boolean buttonClick = false;
	int buttonClicked = 0;
	int teamID = -1;
	AddPitcherGUI pitcher;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewGame window = new NewGame();
					window.frmNewGame.setVisible(true);
					dbm = new DatabaseManager();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmNewGame = new JFrame();
		frmNewGame.setTitle("New Game");
		frmNewGame.setBounds(100, 100, 450, 300);
		frmNewGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmNewGame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.newScreen1();
				frmNewGame.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridwidth = 2;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		frmNewGame.getContentPane().add(btnBack, gbc_btnBack);
		
		JLabel lblOpponent = new JLabel("Opponent");
		GridBagConstraints gbc_lblOpponent = new GridBagConstraints();
		gbc_lblOpponent.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpponent.gridx = 2;
		gbc_lblOpponent.gridy = 2;
		frmNewGame.getContentPane().add(lblOpponent, gbc_lblOpponent);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 5;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 2;
		frmNewGame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPitcherName = new JLabel("Pitcher Name");
		GridBagConstraints gbc_lblPitcherName = new GridBagConstraints();
		gbc_lblPitcherName.insets = new Insets(0, 0, 5, 5);
		gbc_lblPitcherName.gridx = 2;
		gbc_lblPitcherName.gridy = 4;
		frmNewGame.getContentPane().add(lblPitcherName, gbc_lblPitcherName);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 5;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 6;
		gbc_textField_2.gridy = 4;
		frmNewGame.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblHand = new JLabel("Hand");
		GridBagConstraints gbc_lblHand = new GridBagConstraints();
		gbc_lblHand.insets = new Insets(0, 0, 5, 5);
		gbc_lblHand.gridx = 2;
		gbc_lblHand.gridy = 4;
		//frmNewGame.getContentPane().add(lblHand, gbc_lblHand);
		
		hand = new JTextField();
		hand.setColumns(10);
		GridBagConstraints gbc_hand = new GridBagConstraints();
		gbc_hand.gridwidth = 10;
		gbc_hand.insets = new Insets(0, 0, 5, 5);
		gbc_hand.fill = GridBagConstraints.HORIZONTAL;
		gbc_hand.gridx = 6;
		gbc_hand.gridy = 4;
		//frmNewGame.getContentPane().add(hand, gbc_hand);
		
		JLabel lblPitch = new JLabel("Pitch1");
		GridBagConstraints gbc_lblPitch = new GridBagConstraints();
		gbc_lblPitch.insets = new Insets(0, 0, 5, 5);
		gbc_lblPitch.gridx = 2;
		gbc_lblPitch.gridy = 5;
		//frmNewGame.getContentPane().add(lblPitch, gbc_lblPitch);
		
		pitch1 = new JTextField();
		GridBagConstraints gbc_pitch1 = new GridBagConstraints();
		gbc_pitch1.gridwidth = 11;
		gbc_pitch1.insets = new Insets(0, 0, 5, 5);
		gbc_pitch1.fill = GridBagConstraints.HORIZONTAL;
		gbc_pitch1.gridx = 6;
		gbc_pitch1.gridy = 5;
		//frmNewGame.getContentPane().add(pitch1, gbc_pitch1);
		pitch1.setColumns(10);
		
		JLabel lblPitch_1 = new JLabel("Pitch2");
		GridBagConstraints gbc_lblPitch_1 = new GridBagConstraints();
		gbc_lblPitch_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPitch_1.gridx = 2;
		gbc_lblPitch_1.gridy = 6;
		//frmNewGame.getContentPane().add(lblPitch_1, gbc_lblPitch_1);
		
		pitch2 = new JTextField();
		GridBagConstraints gbc_pitch2 = new GridBagConstraints();
		gbc_pitch2.gridwidth = 11;
		gbc_pitch2.insets = new Insets(0, 0, 5, 5);
		gbc_pitch2.fill = GridBagConstraints.HORIZONTAL;
		gbc_pitch2.gridx = 6;
		gbc_pitch2.gridy = 6;
		//frmNewGame.getContentPane().add(pitch2, gbc_pitch2);
		pitch2.setColumns(10);
		
		JLabel lblPitch_2 = new JLabel("Pitch3");
		GridBagConstraints gbc_lblPitch_2 = new GridBagConstraints();
		gbc_lblPitch_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPitch_2.gridx = 2;
		gbc_lblPitch_2.gridy = 7;
		//frmNewGame.getContentPane().add(lblPitch_2, gbc_lblPitch_2);
		
		pitch3 = new JTextField();
		pitch3.setColumns(10);
		GridBagConstraints gbc_pitch3 = new GridBagConstraints();
		gbc_pitch3.gridwidth = 11;
		gbc_pitch3.insets = new Insets(0, 0, 5, 5);
		gbc_pitch3.fill = GridBagConstraints.HORIZONTAL;
		gbc_pitch3.gridx = 6;
		gbc_pitch3.gridy = 7;
		//frmNewGame.getContentPane().add(pitch3, gbc_pitch3);
		
		JLabel lblPitch_3 = new JLabel("Pitch4");
		GridBagConstraints gbc_lblPitch_3 = new GridBagConstraints();
		gbc_lblPitch_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblPitch_3.gridx = 2;
		gbc_lblPitch_3.gridy = 8;
		//frmNewGame.getContentPane().add(lblPitch_3, gbc_lblPitch_3);
		
		pitch4 = new JTextField();
		GridBagConstraints gbc_pitch4 = new GridBagConstraints();
		gbc_pitch4.gridwidth = 10;
		gbc_pitch4.insets = new Insets(0, 0, 0, 5);
		gbc_pitch4.fill = GridBagConstraints.HORIZONTAL;
		gbc_pitch4.gridx = 6;
		gbc_pitch4.gridy = 8;
		//frmNewGame.getContentPane().add(pitch4, gbc_pitch4);
		pitch4.setColumns(10);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 0, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 9;
		gbc_textField_6.gridy = 8;
		//frmNewGame.getContentPane().add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 0, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 10;
		gbc_textField_5.gridy = 8;
		//frmNewGame.getContentPane().add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opponent = textField.getText();
				String pitcherName = textField_2.getText();
				int reportID = -2;
				int pitcherID = -3;
				//see if opponent is in DB
				int gameID = -4;
				teamID = dbm.getOpponentName(opponent);
				System.out.println("btn submit" + teamID);
				//if team is not recognized
			//if(buttonClicked == 0){
					//buttonClicked++;
				if(teamID == -1){
					for(int i =0; i<100;i++){
					if(dbm.findOpponents(i) == null)
					{
						System.out.println("btn submit2" + teamID);
						teamID = i;
						System.out.println("btn submit3" + teamID);
						break;
					}
				}
					dbm.insertOpponent(teamID, opponent);
					dbm.commit();
					pitcher.newScreen(teamID);
					frmNewGame.setVisible(false);
					
				}
				else{
					//teamID found
					System.out.println("pitcher name " + pitcherName + "teamID = " + teamID);
					pitcherID = dbm.getPitcherID(pitcherName, teamID);
					System.out.println(pitcherID);
					if(pitcherID == -1){
						pitcher.newScreen(teamID);
						frmNewGame.setVisible(false);
					}
					else{
					for(int i =0; i<10000;i++){
						if(dbm.findGame(i) == null)
							{
								gameID = i;
								break;
							}
						}
					dbm.insertGame(gameID,1,teamID);
					for(int i =0; i<10000;i++){
						if(dbm.findReport(i) == null)
							{
								reportID = i;
								break;
							}
						}
					dbm.insertReport(reportID, gameID,pitcherID);
					System.out.println("This is the pitcherID " + pitcherID);
					frmNewGame.setVisible(false);
					dbm.commit();
					System.out.println("This is the gameID " + gameID);
					game.newScreen(gameID, teamID,pitcherID);
					}
				}
				}

			
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 0;
		gbc_btnSubmit.gridy = 8;
		frmNewGame.getContentPane().add(btnSubmit, gbc_btnSubmit);
		
		
		
	/*JLabel lblHand = new JLabel("Hand");
	GridBagConstraints gbc_lblHand = new GridBagConstraints();
	gbc_lblHand.insets = new Insets(0, 0, 5, 5);
	gbc_lblHand.gridx = 2;
	gbc_lblHand.gridy = 4;
	//frmNewGame.getContentPane().add(lblHand, gbc_lblHand);
	
	hand = new JTextField();
	hand.setColumns(10);
	GridBagConstraints gbc_hand = new GridBagConstraints();
	gbc_hand.gridwidth = 10;
	gbc_hand.insets = new Insets(0, 0, 5, 5);
	gbc_hand.fill = GridBagConstraints.HORIZONTAL;
	gbc_hand.gridx = 6;
	gbc_hand.gridy = 4;
	//frmNewGame.getContentPane().add(hand, gbc_hand);
	
	JLabel lblPitch = new JLabel("Pitch1");
	GridBagConstraints gbc_lblPitch = new GridBagConstraints();
	gbc_lblPitch.insets = new Insets(0, 0, 5, 5);
	gbc_lblPitch.gridx = 2;
	gbc_lblPitch.gridy = 5;
	//frmNewGame.getContentPane().add(lblPitch, gbc_lblPitch);
	
	pitch1 = new JTextField();
	GridBagConstraints gbc_pitch1 = new GridBagConstraints();
	gbc_pitch1.gridwidth = 11;
	gbc_pitch1.insets = new Insets(0, 0, 5, 5);
	gbc_pitch1.fill = GridBagConstraints.HORIZONTAL;
	gbc_pitch1.gridx = 6;
	gbc_pitch1.gridy = 5;
	//frmNewGame.getContentPane().add(pitch1, gbc_pitch1);
	pitch1.setColumns(10);
	
	JLabel lblPitch_1 = new JLabel("Pitch2");
	GridBagConstraints gbc_lblPitch_1 = new GridBagConstraints();
	gbc_lblPitch_1.insets = new Insets(0, 0, 5, 5);
	gbc_lblPitch_1.gridx = 2;
	gbc_lblPitch_1.gridy = 6;
	//frmNewGame.getContentPane().add(lblPitch_1, gbc_lblPitch_1);
	
	pitch2 = new JTextField();
	GridBagConstraints gbc_pitch2 = new GridBagConstraints();
	gbc_pitch2.gridwidth = 11;
	gbc_pitch2.insets = new Insets(0, 0, 5, 5);
	gbc_pitch2.fill = GridBagConstraints.HORIZONTAL;
	gbc_pitch2.gridx = 6;
	gbc_pitch2.gridy = 6;
	//frmNewGame.getContentPane().add(pitch2, gbc_pitch2);
	pitch2.setColumns(10);
	
	JLabel lblPitch_2 = new JLabel("Pitch3");
	GridBagConstraints gbc_lblPitch_2 = new GridBagConstraints();
	gbc_lblPitch_2.insets = new Insets(0, 0, 5, 5);
	gbc_lblPitch_2.gridx = 2;
	gbc_lblPitch_2.gridy = 7;
	//frmNewGame.getContentPane().add(lblPitch_2, gbc_lblPitch_2);
	
	pitch3 = new JTextField();
	pitch3.setColumns(10);
	GridBagConstraints gbc_pitch3 = new GridBagConstraints();
	gbc_pitch3.gridwidth = 11;
	gbc_pitch3.insets = new Insets(0, 0, 5, 5);
	gbc_pitch3.fill = GridBagConstraints.HORIZONTAL;
	gbc_pitch3.gridx = 6;
	gbc_pitch3.gridy = 7;
	//frmNewGame.getContentPane().add(pitch3, gbc_pitch3);
	
	JLabel lblPitch_3 = new JLabel("Pitch4");
	GridBagConstraints gbc_lblPitch_3 = new GridBagConstraints();
	gbc_lblPitch_3.insets = new Insets(0, 0, 0, 5);
	gbc_lblPitch_3.gridx = 2;
	gbc_lblPitch_3.gridy = 8;
	//frmNewGame.getContentPane().add(lblPitch_3, gbc_lblPitch_3);
	
	pitch4 = new JTextField();
	GridBagConstraints gbc_pitch4 = new GridBagConstraints();
	gbc_pitch4.gridwidth = 10;
	gbc_pitch4.insets = new Insets(0, 0, 0, 5);
	gbc_pitch4.fill = GridBagConstraints.HORIZONTAL;
	gbc_pitch4.gridx = 6;
	gbc_pitch4.gridy = 8;
	//frmNewGame.getContentPane().add(pitch4, gbc_pitch4);
	pitch4.setColumns(10);
	
	textField_6 = new JTextField();
	GridBagConstraints gbc_textField_6 = new GridBagConstraints();
	gbc_textField_6.insets = new Insets(0, 0, 0, 5);
	gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField_6.gridx = 9;
	gbc_textField_6.gridy = 8;
	//frmNewGame.getContentPane().add(textField_6, gbc_textField_6);
	textField_6.setColumns(10);
	
	textField_5 = new JTextField();
	GridBagConstraints gbc_textField_5 = new GridBagConstraints();
	gbc_textField_5.insets = new Insets(0, 0, 0, 5);
	gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField_5.gridx = 10;
	gbc_textField_5.gridy = 8;
	//frmNewGame.getContentPane().add(textField_5, gbc_textField_5);
	textField_5.setColumns(10);*/
}
}
