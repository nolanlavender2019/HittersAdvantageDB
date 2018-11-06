package Gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.DatabaseManager;


public class ReportsGUI {

	private JFrame frmGame;
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
	private JTextField textField;
	private JTextField textField_1;
	private static DatabaseManager dbm;
	MainMenu mainMenu;



	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportsGUI window = new ReportsGUI();
					window.frmGame.setVisible(true);
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
	public ReportsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGame = new JFrame();
		frmGame.setBounds(100, 100, 549, 613);
		frmGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGame.getContentPane().setLayout(null);
		
		
		JLabel lblTendency = new JLabel("Tendency");
		lblTendency.setBounds(10, 93, 79, 16);
		frmGame.getContentPane().add(lblTendency);
		
		JLabel label = new JLabel("0-0");
		label.setBounds(10, 120, 61, 16);
		frmGame.getContentPane().add(label);
		
		DefaultTableModel modelOhOh = new DefaultTableModel();
		table = new JTable(modelOhOh);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(10, 136, 211, 52);
		frmGame.getContentPane().add(js);
		//modelOhOh.addColumn("0-0");
		modelOhOh.addColumn("Fastball");
		modelOhOh.addColumn("Curveball");
		modelOhOh.addColumn("Slider");
		modelOhOh.addColumn("ChangeUp");
		
		JLabel label_1 = new JLabel("0-1");
		label_1.setBounds(10, 197, 61, 16);
		frmGame.getContentPane().add(label_1);
		
		DefaultTableModel modelOhOne = new DefaultTableModel();
		table_1 = new JTable(modelOhOne);
		JScrollPane js1 = new JScrollPane(table_1);
		js1.setBounds(10, 212, 211, 52);
		frmGame.getContentPane().add(js1);
		//modelOhOne.addColumn("0-1");
		modelOhOne.addColumn("Fastball");
		modelOhOne.addColumn("Curveball");
		modelOhOne.addColumn("Slider");
		modelOhOne.addColumn("ChangeUp");
		
		JLabel label_2 = new JLabel("1-2");
		label_2.setBounds(10, 266, 61, 16);
		frmGame.getContentPane().add(label_2);
		
		DefaultTableModel modelOneTwo = new DefaultTableModel();
		table_2 = new JTable(modelOneTwo);
		JScrollPane js2 = new JScrollPane(table_2);
		js2.setBounds(10, 283, 211, 52);
		frmGame.getContentPane().add(js2);
		//modelOneTwo.addColumn("1-2");
		modelOneTwo.addColumn("Fastball");
		modelOneTwo.addColumn("Curveball");
		modelOneTwo.addColumn("Slider");
		modelOneTwo.addColumn("ChangeUp");
		
		DefaultTableModel modelTwoOne = new DefaultTableModel();
		table_3 = new JTable(modelTwoOne);
		JScrollPane js3 = new JScrollPane(table_3);
		js3.setBounds(10, 364, 211, 52);
		frmGame.getContentPane().add(js3);
		//modelTwoOne.addColumn("2-1");
		modelTwoOne.addColumn("Fastball");
		modelTwoOne.addColumn("Curveball");
		modelTwoOne.addColumn("Slider");
		modelTwoOne.addColumn("ChangeUp");
		
		JLabel label_3 = new JLabel("2-1");
		label_3.setBounds(10, 341, 61, 16);
		frmGame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("3-0");
		label_4.setBounds(10, 422, 61, 16);
		frmGame.getContentPane().add(label_4);
		
		DefaultTableModel modelThreeOh = new DefaultTableModel();
		table_4 = new JTable(modelThreeOh);
		JScrollPane js4 = new JScrollPane(table_4);
		js4.setBounds(10, 440, 211, 52);
		frmGame.getContentPane().add(js4);
		//modelThreeOh.addColumn("3-0");
		modelThreeOh.addColumn("Fastball");
		modelThreeOh.addColumn("Curveball");
		modelThreeOh.addColumn("Slider");
		modelThreeOh.addColumn("ChangeUp");
		
		JLabel label_5 = new JLabel("0-2");
		label_5.setBounds(10, 501, 61, 16);
		frmGame.getContentPane().add(label_5);
		
		DefaultTableModel modelOhTwo = new DefaultTableModel();
		table_5 = new JTable(modelOhTwo);
		JScrollPane js5 = new JScrollPane(table_5);
		js5.setBounds(10, 521, 211, 52);
		frmGame.getContentPane().add(js5);
		//modelOhTwo.addColumn("0-2");
		modelOhTwo.addColumn("Fastball");
		modelOhTwo.addColumn("Curveball");
		modelOhTwo.addColumn("Slider");
		modelOhTwo.addColumn("ChangeUp");
		
		DefaultTableModel modelOneOh = new DefaultTableModel();
		table_6 = new JTable(modelOneOh);
		JScrollPane js6 = new JScrollPane(table_6);
		js6.setBounds(310, 136, 211, 52);
		frmGame.getContentPane().add(js6);
		//modelOneOh.addColumn("1-0");
		modelOneOh.addColumn("Fastball");
		modelOneOh.addColumn("Curveball");
		modelOneOh.addColumn("Slider");
		modelOneOh.addColumn("ChangeUp");
		
		DefaultTableModel modelOneOne = new DefaultTableModel();
		table_7 = new JTable(modelOneOne);
		JScrollPane js7 = new JScrollPane(table_7);
		js7.setBounds(310, 212, 211, 52);
		frmGame.getContentPane().add(js7);
		//modelOneOne.addColumn("1-1"); 
		modelOneOne.addColumn("Fastball");
		modelOneOne.addColumn("Curveball");
		modelOneOne.addColumn("Slider");
		modelOneOne.addColumn("ChangeUp");
		
		DefaultTableModel modelTwoTwo = new DefaultTableModel();
		table_8 = new JTable(modelTwoTwo);
		JScrollPane js8 = new JScrollPane(table_8);
		js8.setBounds(310, 282, 211, 52);
		frmGame.getContentPane().add(js8);
		//modelTwoTwo.addColumn("2-2");
		modelTwoTwo.addColumn("Fastball");
		modelTwoTwo.addColumn("Curveball");
		modelTwoTwo.addColumn("Slider");
		modelTwoTwo.addColumn("ChangeUp");
		
		DefaultTableModel modelThreeOne = new DefaultTableModel();
		table_9 = new JTable(modelThreeOne);
		JScrollPane js9 = new JScrollPane(table_9);
		js9.setBounds(310, 364, 211, 52);
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
		js10.setBounds(310,440,211,52);
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
		js11.setBounds(310, 521, 211, 52);
		frmGame.getContentPane().add(js11);
		modelFull.addColumn("Fastball");
		modelFull.addColumn("Curveball");
		modelFull.addColumn("Slider");
		modelFull.addColumn("ChangeUp");
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(6, 6, 117, 29);
		frmGame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.newScreen1();
				frmGame.setVisible(false);
			}
		});
		textField = new JTextField();
		textField.setBounds(16, 55, 130, 26);
		frmGame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(174, 55, 130, 26);
		frmGame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblOpponentName = new JLabel("Opponent Name");
		lblOpponentName.setBounds(16, 33, 108, 16);
		frmGame.getContentPane().add(lblOpponentName);
		
		JLabel lblPitcherName = new JLabel("Pitcher Name");
		lblPitcherName.setBounds(164, 33, 91, 16);
		frmGame.getContentPane().add(lblPitcherName);
		
		JButton btnCalculateTendency = new JButton("Calculate Tendency");
		btnCalculateTendency.setBounds(333, 55, 148, 29);
		btnCalculateTendency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pName = textField_1.getText();
				String teamName = textField.getText();
				int teamID = dbm.getOpponentName(teamName);
				int pID = dbm.getPitcherID(pName, teamID);
				ArrayList<Integer> reports = dbm.getReports(pID);
				
				int i = 0;
				while(i <reports.size()){
				int reportID = reports.get(i);
				System.out.println(reportID);
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
				i++;
				}
			}
		});
		frmGame.getContentPane().add(btnCalculateTendency);
		
		
	}
}
