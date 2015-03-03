package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.ProjectCountWord.*;
import com.ProjectGuessWord.*;

public class launcher {
	
	private JFrame MainFrame;
	private JPanel LauncherPanel;
	
	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					launcher window = new launcher();
					window.MainFrame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	//Create the application.
	public launcher() {
		initialize();
	}
	
	// Initialize the contents of the frame.
	private void initialize() {
		MainFrame = new JFrame();
		MainFrame.setBounds(100, 100, 450, 300);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(new CardLayout(0, 0));
		MainFrame.setLocationRelativeTo(null);
		
		LauncherPanel = new JPanel();
		MainFrame.getContentPane().add(LauncherPanel, "LauncherPanel JPanel");
		LauncherPanel.setLayout(null);
		
		JButton btnCountWordWindow = new JButton("CountWord");
		btnCountWordWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.setVisible(false);
				CountWordFrame aCountWordFrame = new CountWordFrame();
				aCountWordFrame.setLocationRelativeTo(null);
				aCountWordFrame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent ev) {
						MainFrame.setVisible(true);
						aCountWordFrame.dispose();
					}
				});
			}
		});
		btnCountWordWindow.setBounds(10, 11, 195, 181);
		LauncherPanel.add(btnCountWordWindow);
		
		JButton btnGuessWordWindow = new JButton("GuessWord");
		btnGuessWordWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.setVisible(false);
				GuessWordFrame aGuessWordFrame = new GuessWordFrame();
				aGuessWordFrame.setLocationRelativeTo(null);
				aGuessWordFrame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent ev) {
						MainFrame.setVisible(true);
						aGuessWordFrame.dispose();
					}
				});
			}
		});
		btnGuessWordWindow.setBounds(229, 11, 195, 181);
		LauncherPanel.add(btnGuessWordWindow);
		
		JLabel lblGameSelect = new JLabel("Please select a game");
		lblGameSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameSelect.setBounds(152, 220, 130, 14);
		LauncherPanel.add(lblGameSelect);
	}
}
