package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import com.ProjectCountWord.CountWordFrame;
import com.ProjectGuessWord.GuessWordFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.ProjectCountWord.*;
import com.ProjectGuessWord.*;

public class launcher {
	
	private JFrame MainFrame;
	private JPanel CountWord;
	private JPanel GuessWord;
	private JPanel LauncherPanel;
	
	/**
	 * Launch the application.
	 */
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
	
	/**
	 * Create the application.
	 */
	public launcher() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainFrame = new JFrame();
		MainFrame.setBounds(100, 100, 450, 300);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(new CardLayout(0, 0));
		
		LauncherPanel = new JPanel();
		LauncherPanel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
			}
		});
		MainFrame.getContentPane().add(LauncherPanel, "name_6222441403297");
		LauncherPanel.setLayout(null);
		
		CountWord = new JPanel();
		
		MainFrame.getContentPane().add(CountWord, "name_6224301465803");
		CountWord.setLayout(null);
		
		JButton btnCountWordExit = new JButton("Return To Game Select");
		btnCountWordExit.setBounds(0, 0, 165, 23);
		CountWord.add(btnCountWordExit);
		btnCountWordExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CountWord.setVisible(false);
				LauncherPanel.setVisible(true);
			}
		});
		
		GuessWord = new JPanel();
		MainFrame.getContentPane().add(GuessWord, "name_6226473957573");
		GuessWord.setLayout(null);
		
		JButton btnGuessWordExit = new JButton("Return To Game Select");
		btnGuessWordExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LauncherPanel.setVisible(true);
				GuessWord.setVisible(false);
			}
		});
		btnGuessWordExit.setBounds(0, 0, 165, 23);
		GuessWord.add(btnGuessWordExit);
		
		JButton btnCountWordPan = new JButton("CountWord as panel");
		btnCountWordPan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LauncherPanel.setVisible(false);
				CountWord.setVisible(true);
			}
		});
		btnCountWordPan.setBounds(10, 11, 195, 85);
		LauncherPanel.add(btnCountWordPan);
		
		JButton btnGuessWordPan = new JButton("GuessWord as panel");
		btnGuessWordPan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LauncherPanel.setVisible(false);
				GuessWord.setVisible(true);
			}
		});
		
		JButton btnCountWordWin = new JButton("CountWord as window");
		btnCountWordWin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.setVisible(false);
				CountWordFrame aCountWordFrame = new CountWordFrame();
				aCountWordFrame.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
						MainFrame.setVisible(true);
					}
				});
				
			}
		});
		btnCountWordWin.setBounds(10, 107, 195, 85);
		LauncherPanel.add(btnCountWordWin);
		btnGuessWordPan.setBounds(229, 11, 195, 85);
		LauncherPanel.add(btnGuessWordPan);
		
		JButton btnGuessWordWin = new JButton("GuessWord as window");
		btnGuessWordWin.setBounds(229, 107, 195, 85);
		LauncherPanel.add(btnGuessWordWin);
		
		JLabel lblNewLabel = new JLabel("Please select a game");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(152, 220, 130, 14);
		LauncherPanel.add(lblNewLabel);
	}
}
