package com;

//Guessing game application framework.

//Import all the required classes from APIs
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/*import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;*/

public class GuessWordFrame extends JFrame 
{
	//Create the object of GuessWordApp class and pass the object of 'this' class 
	//to create the link between the two classes
	GuessWordApp app = new GuessWordApp(this);
	
	//Setup top part of the frame for displaying the guessed word and guesses remaining
	//Row1 is guess word label and guessWord text area
	JPanel row1 = new JPanel();
	JLabel guessWordLbl = new JLabel("GUESS THE WORD", JLabel.CENTER);
	JTextField guessWordTxt = new JTextField(24);
	
	//Row2 for gusses remaining label and text area
	JPanel row2 = new JPanel();
	JLabel guessRemLbl = new JLabel("Gusses Remaining ", JLabel.LEFT);
	JTextField guessRemTxt = new JTextField(3);
	
	//Row3 for the input buttons also including the start and answer
	JPanel row3 = new JPanel();
	JButton[] inputButtons = new JButton[28];
	String[] title = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
					  "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "START", "ANSWER"}; 
	
	//Define the constructor
	public GuessWordFrame()
	{
		
		//Main frame layout 
		super("Applet");
		setLookAndFeel();
		setSize(550, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout frameLayout = new FlowLayout();
		setLayout(frameLayout);
		
		
		//Layout and add row1 panel to the frame
		GridLayout layoutRow1 = new GridLayout(2, 1, 0, 0);
		row1.setLayout(layoutRow1);
		guessWordTxt.setHorizontalAlignment(JTextField.RIGHT);
		guessWordTxt.setEditable(false);
		row1.add(guessWordLbl);
		guessWordLbl.setForeground(Color.RED);
		row1.add(guessWordTxt);
		row1.setBorder(new EmptyBorder(50, 120, 0, 40));
		add(row1);
		
		//Layout and add row2 to the frame
		FlowLayout layoutRow2 = new FlowLayout(FlowLayout.RIGHT);
		row2.setLayout(layoutRow2);
		guessRemTxt.setEditable(false);
		guessRemTxt.setHorizontalAlignment(JTextField.RIGHT);
		guessRemLbl.setForeground(Color.RED);
		row2.add(guessRemLbl);
		row2.add(guessRemTxt);
		row2.setBorder(new EmptyBorder(0, 200, 0, 5));
		add(row2);
		
		//Layout and add row3 panel to the frame
		GridLayout layoutRow3 = new GridLayout(4, 1, -5, 5);
		row3.setLayout(layoutRow3);
		for(int i = 0; i < 28; i++)
		{
			inputButtons[i] = new JButton(title[i]);
			inputButtons[i].addActionListener(app);
			row3.add(inputButtons[i]);
		}
		
		row3.setBorder(new EmptyBorder(20, 20, 40, 20));
		add(row3);
		
		setResizable(false);
		setVisible(true);
	}
	
	private void setLookAndFeel()
	{
		//Exception handling block.
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception exc) {
		}
	}
	
}