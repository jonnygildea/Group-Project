package com;

/* This class contains the functionality for the WordCountFrame class; 
This class handles the event generated by the WordCountFrame class
which includes the Find Word, Clear and Word Count buttons
*/

//Import all the classes needed from the APIs.
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.BadLocationException;

public class WordCountApp implements ActionListener {
	
	// --- Instance variables ---
	
		//Create an object of WordCountFrame class.
		WordCountFrame test;
		
		 
		// --- Constructor ---
		
		//Define the constructor which takes an object of WordCountFrame class as an parameter for the 
		//two-way communication between the two classes.
		public WordCountApp(WordCountFrame frame)
		{
			test = frame; //assign it to the variable test to access GuessWordFrame class variables.		
		} //End of constructor.
		
		// --- 	Methods ---
		
		//Define actionPerformed method to provide the functionality to the button clicks.
		
		@Override
		public void actionPerformed(ActionEvent whichButtonClicked)
		{
			String findWordBtn = "Find Word", clearBtn = "Clear", wordCountBtn = "Word Count";
			String clickedButton = whichButtonClicked.getActionCommand(); //Store the reference of the button clicked in the clickedButton string.
			
			//Make a method call to findTheWord if 'Find Word' button is clicked.
			if(findWordBtn.equals(clickedButton))
			{
				//Check it there is any text in the textfield and the textarea
				//Before calling the findTheWord method.
				if(test.enterTextArea.getText().equals("") || test.enterWordTxt.getText().equals(""))
				{
					test.statusTxt.setText("");	
				} else
					findTheWord();
			}
			
			//Make a method call to clearAllFields if 'Clear' button is clicked.
			if(clearBtn.equals(clickedButton))
			{
				clearAllFields();
			}
			
			//Make a method call to countAll if 'Word Count' button is clicked.
			if(wordCountBtn.equals(clickedButton))
			{
				countAll();
			}
		} //End of actionPerformed method.
		
		/*This method retrieves the text from the 'wordToFind' textfield and 
		  checks if its present in the text area, if present it displays the text
		  word found at index and highlights the word in the textarea. 
		  If the word is not found then it displays the message 'word not found'
		  */
		private void findTheWord()
		{
			String textAreaString = test.enterTextArea.getText().toLowerCase();
			String wordToFind = test.enterWordTxt.getText().trim().toLowerCase();
			int startIndex = 0, endIndex = 0;
			
			startIndex = textAreaString.indexOf(wordToFind);
			endIndex = startIndex + wordToFind.length();
			test.enterTextArea.getHighlighter().removeAllHighlights();
			
			if(startIndex != -1)
			{
				test.statusTxt.setForeground(Color.BLUE);
				test.statusTxt.setText("Word found at: " + startIndex);
				
				//Exception handling for the highlighter method.
				try
				{
	        		test.enterTextArea.getHighlighter().addHighlight(startIndex, endIndex, DefaultHighlighter.DefaultPainter);
	    		}
	    		catch(BadLocationException ble)
	    		{
		    		ble.printStackTrace();
	    		}
			} else
			{
				test.statusTxt.setForeground(Color.RED);
				test.statusTxt.setText("Word not found");
			}
		} //End of findTheWord method. 
		
		//This method clears all the fields When user clicks the clear button.
		private void clearAllFields()
		{
			test.enterTextArea.setText("");
			test.numWordsTxt.setText("");
			test.numCharsInSpacesTxt.setText("");
			test.numCharsExSpacesTxt.setText("");
			test.numParaTxt.setText("");
			test.enterWordTxt.setText("");
			test.statusTxt.setText("");
		} //End of clearAllFields method.
		
		/*This method calculates the number of words, number of characters with spaces,
		  number of characters without spaces and number of paragraphs in the textarea.
		  */
		private void countAll()
		{
			String textAreaString = test.enterTextArea.getText();
			String numTotalChars = "", numTotalWords = "", numTotalPara = "", numTotalCharsNoSpace = "";
			int totalWords = 0, totalCharsNoSpaces = 0, totalChars = 0;
			
			//Count number of words in the textarea.
			String [] numWords; 
			numWords = textAreaString.split("\\s+");
			totalWords = numWords.length;
			numTotalWords += totalWords;
			
			//Count number of paragraphs in the textarea.
			String [] numParagraphs;
			numParagraphs = textAreaString.split("\n");
			numTotalPara += numParagraphs.length;
			
			//Count number of characters excluding the spaces in the textarea.
			for(int i = 0; i < numWords.length; i++)
			{
				totalCharsNoSpaces += numWords[i].length();
			}
			numTotalCharsNoSpace += totalCharsNoSpaces;
			
			//Count number of characters including the spaces in the textarea.
			totalChars = textAreaString.length() - numParagraphs.length + 1;
			numTotalChars += totalChars;
			
			// if text area is empty set all the textfields to empty
			if(textAreaString.equals("")) 
			{	
				test.numWordsTxt.setText("");
				test.numCharsInSpacesTxt.setText("");
				test.numCharsExSpacesTxt.setText("");
				test.numParaTxt.setText(""); 
			}else
			{	//Set the textfields with the appropriate values calculated above
				test.numWordsTxt.setText(numTotalWords);
				test.numCharsInSpacesTxt.setText(numTotalChars);	
				test.numCharsExSpacesTxt.setText(numTotalCharsNoSpace);
				test.numParaTxt.setText(numTotalPara);
			}
		} //End of countAll method.

}