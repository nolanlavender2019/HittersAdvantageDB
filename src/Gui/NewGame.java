package Gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import DAO.DatabaseManager;

import javax.swing.JLabel;
import java.sql.*;

public class NewGame {

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	MainMenu mainMenu;
	static Connection conn = null;
	static DbConnection connDB;
	public DatabaseManager dbm = new DatabaseManager();
	

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewGame window = new NewGame();
					window.frame.setVisible(true);
					connDB = new DbConnection();
					conn = connDB.dbConnector();
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(6, 6, 75, 29);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.newScreen1();
				frame.setVisible(false);
			}
		});
		
		textField = new JTextField();
		textField.setBounds(44, 79, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblOpponent = new JLabel("Opponent");
		lblOpponent.setBounds(44, 59, 75, 16);
		frame.getContentPane().add(lblOpponent);
		
		textField_1 = new JTextField();
		textField_1.setBounds(44, 131, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPitcher = new JLabel("Pitcher");
		lblPitcher.setBounds(44, 117, 61, 16);
		frame.getContentPane().add(lblPitcher);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(327, 243, 117, 29);
		frame.getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opponent = textField.getText();
				String pitcher = textField_1.getText();
				int teamID1 = -1;
				try{
				String query = "Select t.* from Opponents t where TeamName = ?";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.setString(1, opponent);
				ResultSet rs = pst.executeQuery();
				while(rs.next()){
					teamID1 = rs.getInt("opponentsID");
				}
				if(rs != null){
					try{
						System.out.println("hereaa");
						String query1 = "Select t.* from Pitchers t where PitcherName = ? and teamID = ?";
						PreparedStatement pst1 = conn.prepareStatement(query1);
						pst1.setString(1, pitcher);
						pst1.setInt(2, teamID1);
						ResultSet rs1 = pst.executeQuery();
				if(rs1 == null){
					//code here for new window
					
				}
				else{
					// code here for new window
					textField.setVisible(false);
					textField_1.setVisible(false);
					
				}
					}
					catch (Exception e2){
						e2.printStackTrace();
					
					}
					}
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
	}

}
