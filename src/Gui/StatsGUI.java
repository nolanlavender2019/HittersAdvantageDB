package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class StatsGUI {

	private JFrame frame;
	MainMenu mainMenu;
	static Connection conn = null;
	static DbConnection connDB;
	private JTable table;
	AddPlayerGUI addPlayer;

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
		frame.getContentPane().add(btnLoadData);
		
	}

	}


