package com.ProjectGuessWord;

/* This class contains the functionality for the WordCountFrame class; 
 which is the user interface for the Count Word application.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class GuessWordApp implements ActionListener {
	private final String[] wordList = { "MEMORY", "COMPUTER", "PRINTER", "TROUSERS", "BUTTERCUP" };
	private String asterisks, wordToGuess = "";
	private int counter = 0, numGuessesLeft = 8;
	
	GuessWordFrame test;
	
	public GuessWordApp(GuessWordFrame frame) {
		test = frame;
		
	}
	
	public void actionPerformed(ActionEvent whichButtonClicked) {
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", start = "START", answer = "ANSWER";
		String clickedButton = whichButtonClicked.getActionCommand();
		
		if (letters.indexOf(clickedButton) >= 0)
			revealTheWord(clickedButton);
		// System.out.println(whichButtonClicked.getActionCommand());
		
		if (start.equals(clickedButton))
			startPlaying();
		// System.out.println(whichButtonClicked.getActionCommand());
		
		if (answer.equals(clickedButton))
			displayAnswer();
		// System.out.println(whichButtonClicked.getActionCommand());
		// test.guessWordTxt.setText(wordList[rndIndex.nextInt(5)]);
		
	}
	
	private void startPlaying() {
		asterisks = "";
		wordToGuess = wordList[(counter++) % wordList.length];
		for (int i = 0; i < wordToGuess.length(); i++) {
			asterisks = asterisks + "*";
		}
		test.guessWordTxt.setText(asterisks);
		test.guessRemTxt.setText("8");
	}
	
	private void displayAnswer() {
		test.guessWordTxt.setText(wordToGuess);
		test.guessRemTxt.setText("0");
	}
	
	private void revealTheWord(String clickedButton) {
		
		int index = wordToGuess.indexOf(clickedButton);
		char characterToReplace = clickedButton.charAt(0);
		String livesLeft = "";
		
		if (index == -1) {
			numGuessesLeft--;
			livesLeft = String.valueOf(numGuessesLeft);
			test.guessRemTxt.setText(livesLeft);
			if (numGuessesLeft == 0)
				JOptionPane.showMessageDialog(null, "You Lose");
		}
		else {
			for (int i = 0; i < wordToGuess.length(); i++) {
				if (wordToGuess.charAt(i) == characterToReplace)
					asterisks = asterisks.substring(0, i) + characterToReplace + asterisks.substring(i + 1);
				
			}
			test.guessWordTxt.setText(asterisks);
			
			if (asterisks.equals(wordToGuess))
				JOptionPane.showMessageDialog(null, "You Won");
		}
		
	}
}