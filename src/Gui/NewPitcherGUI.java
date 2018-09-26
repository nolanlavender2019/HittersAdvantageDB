package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import DAO.DatabaseManager;
import DAO.OpponentsDAO;
import DAO.PitchDAO;
import DAO.PitchersDAO;
import Model.Pitchers;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class NewPitcherGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	NewGame newGame;
	public static DatabaseManager dbm;
	static Connection conn = null;
	static DbConnection connDB;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPitcherGUI window = new NewPitcherGUI();
					window.frame.setVisible(true);
					dbm = new DatabaseManager();
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
	public NewPitcherGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(260, 28, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Pitcher Name");
		lblNewLabel.setBounds(250, 11, 96, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(260, 70, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHandness = new JLabel("Handness");
		lblHandness.setBounds(250, 53, 70, 16);
		frame.getContentPane().add(lblHandness);
		
		textField_2 = new JTextField();
		textField_2.setBounds(260, 120, 130, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPitch = new JLabel("Pitch1");
		lblPitch.setBounds(250, 100, 61, 16);
		frame.getContentPane().add(lblPitch);
		
		textField_3 = new JTextField();
		textField_3.setBounds(260, 162, 130, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPitch_1 = new JLabel("Pitch2");
		lblPitch_1.setBounds(250, 146, 61, 16);
		frame.getContentPane().add(lblPitch_1);
		
		JLabel lblPitch_2 = new JLabel("Pitch3");
		lblPitch_2.setBounds(250, 186, 61, 16);
		frame.getContentPane().add(lblPitch_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(260, 238, 130, 26);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(260, 200, 130, 26);
		frame.getContentPane().add(textField_5);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(6, 249, 117, 29);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String hand = textField_1.getText();
				String pitch1 = textField_2.getText();
				String pitch2 = textField_3.getText();
				String pitch3 = textField_4.getText();
				String pitch4 = textField_5.getText();
				String opponent = textField_6.getText();
				int pitchID = -1;
				int teamID1 =-1;
				PitchersDAO pitch = new PitchersDAO(conn, dbm);
				for(int i = 0; i<1000; i++){
					System.out.println(pitch.find(i));
					if(pitch.find(i) == null){
						
						pitchID = i;
						 System.out.println("this is pitchID" + pitchID);
						break;
					}
				}
				
				
				try{
					System.out.println("get here");
					String query1 = "Select t.* from Opponents t where TeamName = ?";
					PreparedStatement pst = conn.prepareStatement(query1);
					pst.setString(1, opponent);
					ResultSet rs = pst.executeQuery();
					while(rs.next()){
						int teamID = rs.getInt("opponentsID");
						teamID1 = teamID;
						System.out.println(teamID1);
					}
				}catch(Exception e1){
						e1.printStackTrace();
				}
				/*try{
					pitch.addPitcher(me);
				}catch(Exception e3){
					e3.printStackTrace();
				}*/
				try{
					/*System.out.println("need it");
				String cmd = "insert into Pitchers(pitcherID, pitcherName, teamID, throw1, pitch1, pitch2, pitch3, pitch4)" + "values(?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(cmd);
				pstmt.setInt(1, pitchID);
				pstmt.setString(2, name);
				pstmt.setInt(3, teamID1);
				pstmt.setString(4,  hand);
				pstmt.setString(5, pitch1);
				pstmt.setString(6, pitch2);
				pstmt.setString(7, pitch3);
				pstmt.setString(8, pitch4);
				
				pstmt.execute();
				conn.commit();
				conn.close();*/
				
				dbm.insertPitchers(pitchID,name,teamID1,hand,pitch1,pitch2,pitch3,pitch4);
				dbm.commit();
				}catch(Exception e2){
					e2.printStackTrace();
				}
				//game Window
			
			}
	
		});
		frame.getContentPane().add(btnSubmit);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame.newScreen();
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(6, 6, 75, 29);
		frame.getContentPane().add(btnBack);
		
		JLabel lblPitch_3 = new JLabel("Pitch4");
		lblPitch_3.setBounds(250, 224, 61, 16);
		frame.getContentPane().add(lblPitch_3);
		textField_6 = new JTextField();
		textField_6.setBounds(44, 120, 130, 26);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblOpponentTeamName = new JLabel("Opponent Team Name");
		lblOpponentTeamName.setBounds(33, 100, 141, 16);
		frame.getContentPane().add(lblOpponentTeamName);
	
}
}

