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
import java.awt.event.*;


public class Gui extends JFrame{
	JButton button1;
	JButton button2;
	JButton button3;
	JButton backButton;
	JFrame mainMenu;
	
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
		
		
		
		
		
		
		
		this.setVisible(true);
	}
	
	// implement listeners
	private class ListenForButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
		if (e.getSource() == button1){
			JFrame newGame = new JFrame();
			JPanel newGame1 = new JPanel();
			newGame.setLayout(new GridBagLayout());
			newGame.setSize(400,400);
			Toolkit tk = Toolkit.getDefaultToolkit();
			
			Dimension dim = tk.getScreenSize();
			int xPos = (dim.width/2 ) - (newGame.getWidth()/2);
			int yPos = (dim.height/2 ) - (newGame.getHeight()/2);
			newGame.setLocation(xPos,yPos);
			newGame.setResizable(false);
			newGame1.setLayout(new GridBagLayout());
			GridBagConstraints gbc1 = new GridBagConstraints();
			gbc1.anchor = GridBagConstraints.NORTHWEST;
			newGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			newGame.setTitle("Game");
			newGame.add(backButton,gbc1);
		
			//newGame.add(newGame1,gbc1);
			
			
			newGame.setVisible(true);
			
		}
		if (e.getSource() == button2){
			JFrame team = new JFrame();
			team.setSize(400,400);
			Toolkit tk = Toolkit.getDefaultToolkit();
			
			Dimension dim = tk.getScreenSize();
			int xPos = (dim.width/2 ) - (team.getWidth()/2);
			int yPos = (dim.height/2 ) - (team.getHeight()/2);
			team.setLocation(xPos,yPos);
			team.setResizable(false);
			
			team.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			team.setTitle("Team");
			team.add(backButton);
			team.setVisible(true);
			
		}
		if (e.getSource() == button3){
			JFrame report = new JFrame();
			report.setSize(400,400);
			Toolkit tk = Toolkit.getDefaultToolkit();
			
			Dimension dim = tk.getScreenSize();
			int xPos = (dim.width/2 ) - (report.getWidth()/2);
			int yPos = (dim.height/2 ) - (report.getHeight()/2);
			report.setLocation(xPos,yPos);
			report.setResizable(false);
			
			report.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			report.setTitle("Report");
			report.add(backButton);
			report.setVisible(true);
			
		}
		if(e.getSource() == backButton){
			mainMenu.setVisible(true);
		}
		
		}
	
	}
	}

