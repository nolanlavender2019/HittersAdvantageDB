package Tests;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.apache.derby.iapi.sql.PreparedStatement;
import org.apache.derby.jdbc.EmbeddedDriver;

import DAO.DatabaseManager;
import DAO.TeamDAO;
import Model.Players;
import Model.Team;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;


public class Gui extends JFrame{
	JButton button1;
	JButton button2;
	JButton button3;
	JButton backButton;
	JFrame mainMenu;
	DatabaseManager dbm;
	Driver driver = new EmbeddedDriver();
	DefaultTableModel model = new DefaultTableModel();
	JTable jtbl = new JTable(model);
	JScrollPane pg = new JScrollPane(jtbl);
	
	private final String url = "jdbc:derby:HittersAdvantageDB";
	
	public static void main(String[]args){
		
		new Gui();
		
	}
	
	public Gui(){
		
		this.setSize(400,400);
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2 ) - (this.getWidth()/2);
		int yPos = (dim.height/2 ) - (this.getHeight()/2);
		this.setLocation(xPos,yPos);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("HittersAdvantage");
		
		JPanel thePanel = new JPanel();
		
		//thePanel.setSize(this.getWidth(),this.getHeight());
		thePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
	
		
		
		
		
		button1 = new JButton("New Game");
		button2 = new JButton("Team");
		button3 = new JButton("Reports");
		backButton = new JButton("Back");
		

		
		ListenForButton lForButton = new ListenForButton();
		button1.addActionListener(lForButton);
		button2.addActionListener(lForButton);
		button3.addActionListener(lForButton);
		backButton.addActionListener(lForButton);
		
		
		thePanel.add(button1, gbc);
		thePanel.add(button2,gbc);
		thePanel.add(button3, gbc);
		this.add(thePanel);
		mainMenu = this;
		
		
		
		//java table
		model.addColumn("PlayerName");
		model.addColumn("Number");
		model.addColumn("Position");
		model.addColumn("BatingAverage");
		model.addColumn("OnBasePercentage");
		model.addColumn("SluggingPercentage");
		
		
		dbm.gettingPlayers(1);
		//int numPlayer = team1.size();
		for(int i = 0; i<0;i++){
			Players hello = dbm.findPlayer(i);
			String name = hello.getPlayerName();
			int num = hello.getNumber();
			String pos = hello.getPosition();
			Float ba = hello.getBattingAverage();
			Float obp = hello.getoBP();
			Float sp = hello.getSlugging();
			
			Object[] player = {name, num,pos,ba,obp,sp};
			
			model.addRow(player);
		}
		
		
		
		this.setVisible(true);
	}
	
	// implement listeners
	private class ListenForButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
		if (e.getSource() == button1){
			JFrame newGame = new JFrame();
			JPanel newGame1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			//newGame.setLayout();
			newGame.setSize(400,400);
			Toolkit tk = Toolkit.getDefaultToolkit();
			
			Dimension dim = tk.getScreenSize();
			int xPos = (dim.width/2 ) - (newGame.getWidth()/2);
			int yPos = (dim.height/2 ) - (newGame.getHeight()/2);
			newGame.setLocation(xPos,yPos);
			newGame.setResizable(false);
			
			newGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			newGame.setTitle("Game");
			
			newGame1.add(backButton);
			newGame.add(newGame1);
			
			
			newGame.setVisible(true);
			
		}
		if (e.getSource() == button2){
			JFrame team = new JFrame();
			JPanel team1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			team.setSize(400,400);
			Toolkit tk = Toolkit.getDefaultToolkit();
			
			Dimension dim = tk.getScreenSize();
			int xPos = (dim.width/2 ) - (team.getWidth()/2);
			int yPos = (dim.height/2 ) - (team.getHeight()/2);
			team.setLocation(xPos,yPos);
			team.setResizable(false);
			
			team.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			team.setTitle("Team");
			team1.add(backButton);
			team.add(team1);
			
			
			//java table
			/*DefaultTableModel model = new DefaultTableModel();
			JTable jtbl = new JTable(model);
			model.addColumn("PlayerName");
			model.addColumn("Number");
			model.addColumn("Position");
			model.addColumn("BatingAverage");
			model.addColumn("OnBasePercentage");
			model.addColumn("SluggingPercentage");
			
			for(int i = 0; i<100;i++){
				Players hello = dbm.findPlayer(i);
				String name = hello.getPlayerName();
				int num = hello.getNumber();
				String pos = hello.getPosition();
				Float ba = hello.getBattingAverage();
				Float obp = hello.getoBP();
				Float sp = hello.getSlugging();
				
				Object[] player = {name, num,pos,ba,obp,sp};
				
				model.addRow(player);
			}
			JScrollPane pg = new JScrollPane(jtbl);*/
			
			team1.add(pg);
			
			team.setVisible(true);
			
		}
		if (e.getSource() == button3){
			JFrame report = new JFrame();
			JPanel report1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			report.setSize(400,400);
			Toolkit tk = Toolkit.getDefaultToolkit();
			
			Dimension dim = tk.getScreenSize();
			int xPos = (dim.width/2 ) - (report.getWidth()/2);
			int yPos = (dim.height/2 ) - (report.getHeight()/2);
			report.setLocation(xPos,yPos);
			report.setResizable(false);
			
			report.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			report.setTitle("Report");
			report1.add(backButton);
			report.add(report1);
			report.setVisible(true);
			
		}
		if(e.getSource() == backButton){
			mainMenu.setVisible(true);
		}
		
		}
	
	}
	
	
	
	
	}

