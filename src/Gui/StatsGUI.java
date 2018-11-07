package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DAO.DatabaseManager;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

import java.lang.Math;

public class StatsGUI {

	private JFrame frame;
	MainMenu mainMenu;
	static Connection conn = null;
	static DbConnection connDB;
	private JTable table;
	AddPlayerGUI addPlayer;
	public static DatabaseManager dbm;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatsGUI window = new StatsGUI();
					window.frame.setVisible(true);
					connDB = new DbConnection();
					conn = connDB.dbConnector();
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
	public StatsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Stats");
		frame.setBounds(100, 100, 527, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.newScreen1();
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(6, 6, 75, 29);
		frame.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 74, 475, 204);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.setBounds(289, 6, 117, 29);
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "Select playerName, BattingAverage, OnBasePercentage, SluggingPercentage from Players";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		JButton btnUpdateStats = new JButton("Update Stats");
		btnUpdateStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					for(int i = 0; i < 100; i++){
						int atBats = 0;
						int plateApperances = 0;
						int totalBases = 0;
						int hits = 0;
						int onB = 0;
					String query = "Select a.* from AtBat a where playerID = ?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setInt(1,i);
					ResultSet rs = pst.executeQuery();
					System.out.println(i);
					while(rs.next()){
						String result = rs.getString("result");
						if(result.equals("Single")){
							atBats++;
							plateApperances++;
							totalBases++;
							hits++;
							onB++;
						}
						if(result.equals("Double")){
							atBats++;
							plateApperances++;
							totalBases= totalBases + 2;
							hits++;
							onB++;
						}
						if(result.equals("Triple")){
							atBats++;
							plateApperances++;
							totalBases= totalBases+3;
							hits++;
							onB++;
						}if(result.equals("HomeRun")){
							atBats++;
							plateApperances++;
							totalBases= totalBases + 4;
							hits++;
							onB++;
						}
						if(result.equals("Out")){
							atBats++;
							plateApperances++;
							
						}
						if(result.equals("Walk")){
							plateApperances++;
							onB++;
						}
						if(result.equals("HBP")){
							plateApperances++;
							onB++;
						}
						if(result.equals("Error")){
							atBats++;
							plateApperances++;
							
						}
						

					}
					float bA = Math.round((float)hits/atBats*1000);
					float onBasePercentage = Math.round((float)onB/plateApperances*1000);
					float sluggingPercentage = Math.round((float)totalBases/atBats*1000);
					dbm.updateStats(i,bA,onBasePercentage,sluggingPercentage);
					dbm.commit();
				}
				}
				catch (Exception e1){
					System.out.println("This error" + e1);
				}
			}
		});
		btnUpdateStats.setBounds(151, 6, 117, 29);
		frame.getContentPane().add(btnUpdateStats);
		frame.getContentPane().add(btnLoadData);
		
	}

	}


