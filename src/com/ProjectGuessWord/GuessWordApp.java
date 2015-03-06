package com.ProjectGuessWord;

/* This class contains the functionality for the WordCountFrame class; 
 which is the user interface for the Count Word application.
 */

//Import all the classes needed from the APIs.
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GuessWordApp implements ActionListener {
	// --- Instance variables ---
	
	//Define and initialize the variables needed.
	private final String[] wordList = { "MEMORY", "COMPUTER", "PRINTER", "TROUSERS", "BUTTERCUP" }; //List of given words.	
	private String asterisks; //Variable to store the asterisks version of the word selected from the list.
	private String wordToGuess; //Variable to store the current word.
	private int counter = 0; //Variable to traverse through the word list.
	private int numGuessesLeft; //Variable to store the number of guesses a player has.
	
	//Create an object of GuessWordFrame class. 
	GuessWordFrame test;
	
	// --- Constructor ---
	
	//Define the constructor which takes an object of GuessWordFrame class as an parameter for the 
	//two-way communication between the two classes.
	public GuessWordApp(GuessWordFrame frame) {
		test = frame; //assign it to the variable test to access GuessWordFrame class variables.
	} //End of constructor.
	
	// --- 	Methods ---
	
	//Define actionPerformed method to provide the functionality to the button clicks.
	
	@Override
	public void actionPerformed(ActionEvent whichButtonClicked) {
		//Invoked when a button is clicked.
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", start = "START", answer = "ANSWER";
		String clickedButton = whichButtonClicked.getActionCommand(); //Store the reference of the button clicked in the clickedButton string.
		
		//Make a method call to startPlaying if start button is clicked.		
		if (start.equals(clickedButton)) {
			startPlaying();
		}
		//Make a method call to revealTheWord if any of the alphabets button is clicked.
		if (letters.indexOf(clickedButton) >= 0) {
			revealTheWord(clickedButton);
		}
		//Make a method call to startPlaying if start button is clicked.	
		if (answer.equals(clickedButton)) {
			displayAnswer();
		}
	} //End of actionPerformed method.
	
	/*This method selects a word sequentially from the word list
	  creats an asterisks version of the selected word and display it to the user
	  and enables the alphabet and answer buttons once the user hits the start button.
	  */
	private void startPlaying() {
		numGuessesLeft = 8; //Initialize the gusses remaining to 8.
		asterisks = ""; //Initialize asterisks string to empty to replace the null value.
		wordToGuess = wordList[(counter++) % wordList.length]; //Select a word from the list.
		
		//Using for loop create asterisks version of the selected word.
		for (int i = 0; i < wordToGuess.length(); i++) {
			asterisks = asterisks + "*";
		}
		test.guessWordTxt.setText(asterisks); //Set the asterisks version of the word selected to guessWordTxt field.
		test.guessRemTxt.setText("8"); //Set the gussess remaining to 8.
		
		//As user clicks on the start button enables all the buttons.
		for (int i = 0; i < 28; i++) {
			test.inputButtons[i].setEnabled(true);
		}
	} //End of startPlaying method.
	
	//Display the hidden or partially hidden word and clear the gusses remaining textfield
	//When the user clicks the 'ANSWER' button.
	private void displayAnswer() {
		test.guessWordTxt.setText(wordToGuess);
		test.guessRemTxt.setText("");
	} //End of displayAnswer method.
	
	/*This method gets the alphabet and then check it with the selected word
	  If the alphabet is present in the word then replaces it with the asterisks
	  Else decrement the gusses remaining by 1
	  If gusses remaining is equal to zero then display 'You Lose'
	  Else displays 'You Won'.
	  */
	private void revealTheWord(String clickedButton) {
		int index = wordToGuess.indexOf(clickedButton);
		char characterToReplace = clickedButton.charAt(0);
		String livesLeft = "";
		
		//If character is not present in the word.
		if (index == -1) {
			numGuessesLeft--;
			livesLeft = String.valueOf(numGuessesLeft);
			test.guessRemTxt.setText(livesLeft);
			if (numGuessesLeft == 0) {
				JLabel msgLabel = new JLabel("You Lose", JLabel.CENTER);
				msgLabel.setFont(new Font("Serif", Font.BOLD, 24));
				msgLabel.setForeground(Color.RED);
				JOptionPane.showMessageDialog(null, msgLabel, "", JOptionPane.PLAIN_MESSAGE);
				
				//After the 'You Lose' message is displayed only the start and answer buttons are enabled.
				for (int i = 0; i < 28; i++) {
					test.inputButtons[i].setEnabled(false);
				}
				test.inputButtons[26].setEnabled(true);
				test.inputButtons[27].setEnabled(true);
			}
		}
		else //If character is present in the word.
		{
			for (int i = 0; i < wordToGuess.length(); i++) {
				if (wordToGuess.charAt(i) == characterToReplace)
					asterisks = asterisks.substring(0, i) + characterToReplace + asterisks.substring(i + 1);
			}
			test.guessWordTxt.setText(asterisks);
			
			//Check if the whole word ie revealed and it matches the selected word.
			if (asterisks.equals(wordToGuess)) {
				JLabel msgLabel = new JLabel("You Won", JLabel.CENTER);
				msgLabel.setFont(new Font("Serif", Font.BOLD, 24));
				msgLabel.setForeground(Color.BLUE);
				JOptionPane.showMessageDialog(null, msgLabel, "", JOptionPane.PLAIN_MESSAGE);
				
				//After the 'You Lose' message is displayed only the start button is enabled.
				for (int i = 0; i < 28; i++) {
					test.inputButtons[i].setEnabled(false);
				}
				test.inputButtons[26].setEnabled(true);
			}
		}
	} //End of revealTheWord method.
} //End of GuessWordApp class. 