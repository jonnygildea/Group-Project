package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.ProjectCountWord.*;
import com.ProjectGuessWord.*;
import com.Vitalij.TitleFrame;

import javax.swing.ImageIcon;

public class Launcher {
	static Launcher aLauncher;
	
	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aLauncher = new Launcher();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Create the application.
	public Launcher() {
		initialize();
	}
	
	public Launcher getLauncher() {
		return aLauncher;
	}
	
	// Initialise the contents of the frame.
	private void initialize() {
		// Define the main Jframe 
		JFrame MainFrame = new JFrame();
		MainFrame.setResizable(false);
		MainFrame.setBounds(100, 100, 497, 481);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Center the frame on screen
		MainFrame.setLocationRelativeTo(null);
		// Set the main window to be visible
		MainFrame.setVisible(true);
		MainFrame.getContentPane().setLayout(null);
		
		// Declare content panel
		JPanel LauncherPanel = new JPanel();
		LauncherPanel.setBounds(-10003, -10025, 491, 470);
		MainFrame.getContentPane().add(LauncherPanel);
		LauncherPanel.setLayout(null);
		
		// Declare the button to launch the CountWord game
		JButton btnCountWordWindow = new JButton("CountWord");
		btnCountWordWindow.setBounds(336, 265, 145, 135);
		MainFrame.getContentPane().add(btnCountWordWindow);
		
		// Declare the button to launch the GuessWord game
		JButton btnGuessWordWindow = new JButton("GuessWord");
		btnGuessWordWindow.setBounds(10, 265, 135, 135);
		MainFrame.getContentPane().add(btnGuessWordWindow);
		
		JButton btnVitalijGame = new JButton("VitalijGame");
		btnVitalijGame.setBounds(175, 265, 140, 135);
		MainFrame.getContentPane().add(btnVitalijGame);
		
		// Set the label to instruct the user to choose a game
		JLabel lblGameSelect = new JLabel("Please select a game");
		lblGameSelect.setBounds(173, 423, 145, 14);
		MainFrame.getContentPane().add(lblGameSelect);
		// Align the text to be center aligned
		lblGameSelect.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Blank label to use for the logo 
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(10, 11, 471, 243);
		MainFrame.getContentPane().add(lblLogo);
		// use the class resource logo.png 
		lblLogo.setIcon(new ImageIcon(Launcher.class.getResource("/com/logo.png")));
		
		btnVitalijGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Hide the main window so only one window is visible at a time
				MainFrame.setVisible(false);
				// Launch the GuessWord game
				TitleFrame VitalijGame = new TitleFrame();
				VitalijGame.setSize(490, 250);
				VitalijGame.setVisible(true);
				VitalijGame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				// Center the window on screen
				VitalijGame.setLocationRelativeTo(null);
				// Define an action listener that runs when the game window is closed
				VitalijGame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent ev) {
						// Mark the game window to release all its resources 
						VitalijGame.dispose();
						// Set the main window visible again
						MainFrame.setVisible(true);
					}
				});
			}
		});
		
		// Launch the GuessWord game on button press
		btnGuessWordWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Hide the main window so only one window is visible at a time
				MainFrame.setVisible(false);
				// Launch the GuessWord game
				GuessWordFrame aGuessWordFrame = new GuessWordFrame();
				// Center the window on screen
				aGuessWordFrame.setLocationRelativeTo(null);
				// Define an action listener that runs when the game window is closed
				aGuessWordFrame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent ev) {
						// Mark the game window to release all its resources 
						aGuessWordFrame.dispose();
						// Set the main window visible again
						MainFrame.setVisible(true);
					}
				});
			}
		});
		
		// Launch the CountWord game on button press
		btnCountWordWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Hide the main window so only one window is visible at a time
				MainFrame.setVisible(false);
				// Launch the CountWord game
				CountWordFrame aCountWordFrame = new CountWordFrame();
				// Center the window on screen
				aCountWordFrame.setLocationRelativeTo(null);
				// Define an action listener that runs when the game window is closed
				aCountWordFrame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent ev) {
						// Mark the game window to release all its resources 
						aCountWordFrame.dispose();
						// Set the main window visible again
						MainFrame.setVisible(true);
					}
				});
			}
		});
	}
}
