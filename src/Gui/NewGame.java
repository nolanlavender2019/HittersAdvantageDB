package Gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class NewGame {

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	MainMenu mainMenu;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewGame window = new NewGame();
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
	}

}
