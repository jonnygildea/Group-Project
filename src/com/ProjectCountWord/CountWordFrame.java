package com.ProjectCountWord;

//Word Count application framework.

//Import all the required classes from APIs
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class CountWordFrame extends JFrame {
	
	// --- Instance variables ---
	
	// Cerate the object of WordCountApp class and pass the object of 'this' class.
	// to create the link between the two classes.
	CountWordApp app = new CountWordApp(this);
	
	// Create main panel with border layout which contains
	// the left panel and the right panel
	JPanel mainPanel = new JPanel();
	
	// left panel contains 2 panels topleft and bottomleft panels
	JPanel leftPanel = new JPanel();
	
	// Setup topLeftPanel which contains the label 'Enter text'
	// and the text area
	JPanel topLeftPanel = new JPanel();
	JLabel enterTextLbl = new JLabel("Enter text", JLabel.CENTER);
	JTextArea enterTextArea = new JTextArea(8, 10);
	
	// Setup bottomLeftPanel which contains btLeftTitle panel
	// btLeftResult panel
	JPanel bottomLeftPanel = new JPanel();
	
	// Setup btLeftTitle panel which consists of the 'count of words and chars' label
	JPanel btLeftTitle = new JPanel();
	JLabel countWordsNCharsLbl = new JLabel("Count of words and characters", JLabel.CENTER);
	
	// Setup btLeftResult panel which consists of btLeftResultLbls and btLeftResultTxts panels
	JPanel btLeftResult = new JPanel();
	
	// Setup btLeftResultLbls panel which consists of the numWords, numChars and numPara lables
	JPanel btLeftResultLbls = new JPanel();
	JLabel numWordsLbl = new JLabel("Number of words", JLabel.LEFT);
	JLabel numCharsInSpacesLbl = new JLabel("Number of characters including spaces", JLabel.LEFT);
	JLabel numCharsExSpacesLbl = new JLabel("Number of characters without spaces", JLabel.LEFT);
	JLabel numParaLbl = new JLabel("Number of paragraphs", JLabel.LEFT);
	
	// Setup btLeftResultTxts panel which consists of the numWords, numChars and numPara textfields
	JPanel btLeftResultTxts = new JPanel();
	JTextField numWordsTxt = new JTextField(6);
	JTextField numCharsInSpacesTxt = new JTextField(6);
	JTextField numCharsExSpacesTxt = new JTextField(6);
	JTextField numParaTxt = new JTextField(6);
	
	// Setup right panel which consists of topright and top bottom panel
	JPanel rightPanel = new JPanel();
	
	// Setup topRightPanel which consists of topRightLblPanel and topRightBtnPanel
	JPanel topRightPanel = new JPanel();
	
	// Setup topRightRow1 which consists 'enter word' label and textfield
	JPanel topRightRow1 = new JPanel();
	JLabel enterWordLbl = new JLabel("Enter word", JLabel.LEFT);
	JTextField enterWordTxt = new JTextField(10);
	
	// Setup topRightRow2 which consists 'status' label and textfield
	JPanel topRightRow2 = new JPanel();
	JLabel statusLbl = new JLabel("Status", JLabel.LEFT);
	JTextField statusTxt = new JTextField(10);
	
	// Setup topRightRow3 which consists 'find word' and 'clear' buttons
	JPanel topRightRow3 = new JPanel();
	JButton findWordButton = new JButton("Find Word");
	JButton clearButton = new JButton("Clear");
	
	// Setup bottomRightPanel which consists 'word count' button
	JPanel bottomRightPanel = new JPanel();
	JButton wordCountButton = new JButton("Word Count");
	
	// Define the constructor
	public CountWordFrame() {
		// Main frame layout
		super("Applet");
		setLookAndFeel();
		setBackground(Color.LIGHT_GRAY);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout frameLayout = new GridLayout(1, 1);
		setLayout(frameLayout);
		
		// Define layout for leftPanel
		GridLayout leftPanelLayout = new GridLayout(2, 1);
		leftPanel.setLayout(leftPanelLayout);
		leftPanel.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(topLeftPanel);
		leftPanel.add(bottomLeftPanel);
		
		// Layout and add topLeftPanel
		BorderLayout topLeftPanelLayout = new BorderLayout();
		topLeftPanel.setLayout(topLeftPanelLayout);
		topLeftPanel.setBackground(Color.LIGHT_GRAY);
		topLeftPanel.add(enterTextLbl, BorderLayout.NORTH);
		enterTextLbl.setFont(new Font("Serif", Font.BOLD, 14));
		enterTextArea.setLineWrap(true);
		enterTextArea.setWrapStyleWord(true);
		JScrollPane noScrolls = new JScrollPane(enterTextArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		topLeftPanel.add(noScrolls, BorderLayout.CENTER);
		topLeftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// Layout bottomLeftPanel and add btLeftTitle and btLeftResult
		// add countWordsNCharsLbl to the btLeftTitle panel
		BorderLayout bottomLeftPanelLayout = new BorderLayout();
		bottomLeftPanel.setLayout(bottomLeftPanelLayout);
		bottomLeftPanel.setBackground(Color.LIGHT_GRAY);
		bottomLeftPanel.add(btLeftTitle, BorderLayout.NORTH);
		bottomLeftPanel.add(btLeftResult, BorderLayout.CENTER);
		btLeftTitle.setBackground(Color.LIGHT_GRAY);
		btLeftTitle.add(countWordsNCharsLbl);
		countWordsNCharsLbl.setFont(new Font("Serif", Font.BOLD, 16));
		
		// Layout and add btLeftResult panel
		// add btLeftResultLbls and btLeftResultTxts panels to btLeftResult
		BorderLayout btLeftResultLayout = new BorderLayout();
		btLeftResult.setLayout(btLeftResultLayout);
		btLeftResult.setBackground(Color.LIGHT_GRAY);
		btLeftResult.add(btLeftResultLbls, BorderLayout.WEST);
		btLeftResult.add(btLeftResultTxts, BorderLayout.EAST);
		btLeftResult.setBorder(new EmptyBorder(20, 10, 10, 10));
		
		// Define layout for btLeftResultLbls
		// add numWords, numChars and numPara lables
		GridLayout btLeftResultLblsLayout = new GridLayout(4, 1);
		btLeftResultLbls.setLayout(btLeftResultLblsLayout);
		btLeftResultLbls.setBackground(Color.LIGHT_GRAY);
		btLeftResultLbls.add(numWordsLbl);
		btLeftResultLbls.add(numCharsInSpacesLbl);
		btLeftResultLbls.add(numCharsExSpacesLbl);
		btLeftResultLbls.add(numParaLbl);
		
		// Define layout for btLeftResultTxts
		// add numWords, numChars and numPara textfields
		BoxLayout btLeftResultTxtsLayout = new BoxLayout(btLeftResultTxts, BoxLayout.Y_AXIS);
		btLeftResultTxts.setLayout(btLeftResultTxtsLayout);
		btLeftResultTxts.setBackground(Color.LIGHT_GRAY);
		btLeftResultTxts.add(numWordsTxt);
		numWordsTxt.setEditable(false);
		btLeftResultTxts.add(numCharsInSpacesTxt);
		numCharsInSpacesTxt.setEditable(false);
		btLeftResultTxts.add(numCharsExSpacesTxt);
		numCharsExSpacesTxt.setEditable(false);
		numParaTxt.setEditable(false);
		btLeftResultTxts.add(numParaTxt);
		btLeftResultTxts.setBorder(new EmptyBorder(0, 100, 0, 0));
		
		// Define layout for rightPanel
		// add top and bottom panels to it
		GridLayout rightPanelLayout = new GridLayout(2, 1);
		rightPanel.setLayout(rightPanelLayout);
		rightPanel.setBackground(Color.LIGHT_GRAY);
		rightPanel.add(topRightPanel);
		rightPanel.add(bottomRightPanel);
		
		// Define layout for topRightPanel
		// add topRightRow1, topRightRow2, topRightRow3 panels to it
		GridLayout topRightPanelLayout = new GridLayout(3, 1);
		topRightPanel.setLayout(topRightPanelLayout);
		topRightPanel.setBackground(Color.LIGHT_GRAY);
		topRightPanel.add(topRightRow1);
		topRightPanel.add(topRightRow2);
		topRightPanel.add(topRightRow3);
		topRightPanel.setBorder(new EmptyBorder(30, 10, 0, 20));
		
		// Define layout for topRightRow1 panel
		// add 'enter word' label and textfield
		BorderLayout topRightRow1Layout = new BorderLayout();
		topRightRow1.setLayout(topRightRow1Layout);
		topRightRow1.setBackground(Color.LIGHT_GRAY);
		topRightRow1.add(enterWordLbl, BorderLayout.NORTH);
		topRightRow1.add(enterWordTxt, BorderLayout.CENTER);
		enterWordLbl.setFont(new Font("Serif", Font.BOLD, 14));
		topRightRow1.setBorder(new EmptyBorder(0, 0, 10, 0));
		
		// Define layout for topRightRow2 panel
		// add 'status' label and textfield
		BorderLayout topRightRow2Layout = new BorderLayout();
		topRightRow2.setLayout(topRightRow2Layout);
		topRightRow2.setBackground(Color.LIGHT_GRAY);
		topRightRow2.add(statusLbl, BorderLayout.NORTH);
		topRightRow2.add(statusTxt, BorderLayout.CENTER);
		statusLbl.setFont(new Font("Serif", Font.BOLD, 14));
		statusTxt.setEditable(false);
		topRightRow2.setBorder(new EmptyBorder(0, 0, 10, 0));
		
		// Define layout for topRightRow3 panel
		// add 'status' label and textfield
		GridLayout topRightRow3Layout = new GridLayout(1, 2, 20, 45);
		topRightRow3.setLayout(topRightRow3Layout);
		topRightRow3.setBackground(Color.LIGHT_GRAY);
		findWordButton.addActionListener(app);
		findWordButton.setBackground(Color.LIGHT_GRAY);
		topRightRow3.add(findWordButton);
		clearButton.addActionListener(app);
		clearButton.setBackground(Color.LIGHT_GRAY);
		topRightRow3.add(clearButton);
		topRightRow3.setBorder(new EmptyBorder(10, 0, 10, 0));
		
		// Define layout for bottomRightPanel
		// add wordCount button
		BorderLayout bottomRightPanelLayout = new BorderLayout();
		bottomRightPanel.setLayout(bottomRightPanelLayout);
		bottomRightPanel.setBackground(Color.LIGHT_GRAY);
		wordCountButton.setBackground(Color.LIGHT_GRAY);
		wordCountButton.addActionListener(app);
		bottomRightPanel.add(wordCountButton, BorderLayout.CENTER);
		bottomRightPanel.setBorder(new EmptyBorder(80, 50, 40, 60));
		
		// Define layout for main panel and add left and right panels and
		// add it to the main frame
		BorderLayout mainPanelLayout = new BorderLayout();
		mainPanel.setLayout(mainPanelLayout);
		mainPanel.add(leftPanel, BorderLayout.CENTER);
		mainPanel.add(rightPanel, BorderLayout.EAST);
		mainPanel.setBackground(Color.LIGHT_GRAY);
		add(mainPanel);
		
		pack(); // Displays the contents of in the minimum size required.
		setLocationRelativeTo(null); // Centers the application window on the screen.
		setResizable(false); // Stops the user to expand/contract the application window.
		setVisible(true);
	} // End of constructor.
	
	// --- Methods ---
	
	// This method set the 'Nimbus' look and feel to the components.
	private void setLookAndFeel() {
		// Exception handling block.
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}// End of setLookAndFeel method.
	
}
