package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import DAO.DatabaseManager;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPitcherGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public static DatabaseManager dbm;
	static int opponentID = -5;
	GameGUI game;
	/**
	 * Launch the application.
	 */
	public static void newScreen(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPitcherGUI window = new AddPitcherGUI();
					window.frame.setVisible(true);
					dbm = new DatabaseManager();
					opponentID = id;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddPitcherGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblPlayerName = new JLabel("Pitcher Name");
		GridBagConstraints gbc_lblPlayerName = new GridBagConstraints();
		gbc_lblPlayerName.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerName.gridx = 1;
		gbc_lblPlayerName.gridy = 1;
		frame.getContentPane().add(lblPlayerName, gbc_lblPlayerName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 1;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNumber = new JLabel("Hand");
		GridBagConstraints gbc_lblNumber = new GridBagConstraints();
		gbc_lblNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumber.gridx = 1;
		gbc_lblNumber.gridy = 2;
		frame.getContentPane().add(lblNumber, gbc_lblNumber);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 6;
		gbc_textField_1.gridy = 2;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPosition = new JLabel("Pitch 1");
		GridBagConstraints gbc_lblPosition = new GridBagConstraints();
		gbc_lblPosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosition.gridx = 1;
		gbc_lblPosition.gridy = 3;
		frame.getContentPane().add(lblPosition, gbc_lblPosition);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 6;
		gbc_textField_2.gridy = 3;
		frame.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblHit = new JLabel("Pitch 2");
		GridBagConstraints gbc_lblHit = new GridBagConstraints();
		gbc_lblHit.insets = new Insets(0, 0, 5, 5);
		gbc_lblHit.gridx = 1;
		gbc_lblHit.gridy = 4;
		frame.getContentPane().add(lblHit, gbc_lblHit);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 6;
		gbc_textField_3.gridy = 4;
		frame.getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblBattingAverage = new JLabel("Pitch 3");
		GridBagConstraints gbc_lblBattingAverage = new GridBagConstraints();
		gbc_lblBattingAverage.insets = new Insets(0, 0, 5, 5);
		gbc_lblBattingAverage.gridx = 1;
		gbc_lblBattingAverage.gridy = 5;
		frame.getContentPane().add(lblBattingAverage, gbc_lblBattingAverage);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 6;
		gbc_textField_4.gridy = 5;
		frame.getContentPane().add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblSlugging = new JLabel("Pitch 4");
		GridBagConstraints gbc_lblSlugging = new GridBagConstraints();
		gbc_lblSlugging.insets = new Insets(0, 0, 5, 5);
		gbc_lblSlugging.gridx = 1;
		gbc_lblSlugging.gridy = 6;
		frame.getContentPane().add(lblSlugging, gbc_lblSlugging);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 6;
		gbc_textField_5.gridy = 6;
		frame.getContentPane().add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);

		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String number =textField_1.getText();
				String position = textField_2.getText();
				String hit = textField_3.getText();
				String battingAverage = textField_4.getText();
				String slugging = textField_5.getText();
				
				int playerID = -1;
				int gameID = 0;
				int reportID = 0;
				for(int i = 0; i<1000;i++){
					if(dbm.findPitcher(i) == null)
					{
						playerID = i;
						System.out.println(playerID);
						break;
					}
				}
				
				dbm.insertPitchers(playerID, name, opponentID, number,position, hit, battingAverage,slugging);
				dbm.commit();
				frame.setVisible(false);
				for(int i =0; i<100;i++){
					if(dbm.findGame(i) == null)
						{
							 gameID = i;
							break;
						}
					}
				dbm.insertGame(gameID,1,opponentID);
				for(int i =0; i<100;i++){
					if(dbm.findReport(i) == null)
						{
							 reportID = i;
							break;
						}
					}
				dbm.insertReport(reportID, gameID,playerID);
				frame.setVisible(false);
				dbm.commit();
				
				game.newScreen();
				
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 4;
		gbc_btnSubmit.gridy = 8;
		frame.getContentPane().add(btnSubmit, gbc_btnSubmit);
	}

}