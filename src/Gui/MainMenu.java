package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	private JFrame frame;
	NewGame game;
	ReportsGUI reports;
	TeamGUI team;
	StatsGUI stats;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					NewGame game = new NewGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void newScreen1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					NewGame game = new NewGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public MainMenu() {
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
		
		JButton btnReports = new JButton("Reports");
		btnReports.setBounds(171, 136, 117, 29);
		frame.getContentPane().add(btnReports);
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reports.newScreen();
				frame.setVisible(false);
			}
		});
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.newScreen();
				frame.setVisible(false);
			}
		});
		btnNewGame.setBounds(171, 95, 117, 29);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnTeam = new JButton("Team");
		btnTeam.setBounds(171, 177, 117, 29);
		frame.getContentPane().add(btnTeam);
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				team.newScreen();
				frame.setVisible(false);
			}
		});
		JButton btnStats = new JButton("Stats");
		btnStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stats.newScreen();
			}
		});
		btnStats.setBounds(171, 213, 117, 29);
		frame.getContentPane().add(btnStats);
		
		JLabel lblHittersadvantage = new JLabel("HittersAdvantage");
		lblHittersadvantage.setBounds(171, 20, 117, 16);
		frame.getContentPane().add(lblHittersadvantage);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setBounds(193, 48, 73, 16);
		frame.getContentPane().add(lblMainMenu);
		frame.setVisible(true);
		
		
		
	}
}
