package Tests;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class Gui extends JFrame{
	
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
		JLabel label1 = new JLabel("Main Menu");
		
		thePanel.add(label1);
		this.add(thePanel);
		
		JButton button1 = new JButton("New Game");
		JButton button2 = new JButton("Team");
		JButton button3 = new JButton("Reports");
		
		
		
		
		thePanel.add(button1);
		thePanel.add(button2);
		thePanel.add(button3);
		
		
		
		
		
		
		
		this.setVisible(true);
	}

}
