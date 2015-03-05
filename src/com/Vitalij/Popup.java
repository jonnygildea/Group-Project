package com.Vitalij;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Popup {

	public Popup(int a) {
		JFrame parent = new JFrame();
		if (a==1)
			JOptionPane.showMessageDialog(parent, "         GAME OVER \n Player 2 is the Winner");
	    if (a==2)
	    	JOptionPane.showMessageDialog(parent, "         GAME OVER \n Player 1 is the Winner");

	}

}
