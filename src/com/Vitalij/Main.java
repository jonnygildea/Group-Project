package com.Vitalij;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new TitleFrame();
				frame.setSize(480, 260);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}