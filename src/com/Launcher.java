package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.ProjectCountWord.*;
import com.ProjectGuessWord.*;
import javax.swing.ImageIcon;

public class Launcher {
	
	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Launcher();
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
	
	// Initialise the contents of the frame.
	private void initialize() {
		// Define the main Jframe 
		JFrame MainFrame = new JFrame();
		MainFrame.setBounds(100, 100, 466, 475);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(new CardLayout(0, 0));
		// Center the frame on screen
		MainFrame.setLocationRelativeTo(null);
		// Set the main window to be visible
		MainFrame.setVisible(true);
		
		// Declare content panel
		JPanel LauncherPanel = new JPanel();
		MainFrame.getContentPane().add(LauncherPanel, "LauncherPanel JPanel");
		// Set layout to absolute
		LauncherPanel.setLayout(null);
		
		// Declare the button to launch the CountWord game
		JButton btnCountWordWindow = new JButton("CountWord");
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
		btnCountWordWindow.setBounds(235, 244, 195, 150);
		LauncherPanel.add(btnCountWordWindow);
		
		// Declare the button to launch the GuessWord game
		JButton btnGuessWordWindow = new JButton("GuessWord");
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
		btnGuessWordWindow.setBounds(20, 244, 195, 150);
		LauncherPanel.add(btnGuessWordWindow);
		
		// Set the label to instruct the user to choose a game
		JLabel lblGameSelect = new JLabel("Please select a game");
		// Align the text to be center aligned
		lblGameSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameSelect.setBounds(160, 413, 130, 14);
		// add the label to the main content panel
		LauncherPanel.add(lblGameSelect);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Launcher.class.getResource("/com/logo.png")));
		lblLogo.setBounds(0, 0, 450, 233);
		LauncherPanel.add(lblLogo);
	}
}
