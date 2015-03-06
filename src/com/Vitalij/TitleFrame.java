package com.Vitalij;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TitleFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	final JTextField textField;
	final JTextField textField_1;
	JButton btnNewGame = new JButton("New Game");
	JButton btnSave = new JButton("Save");
	JButton btnLoad = new JButton("Load");
	JTextArea textArea = new JTextArea("The rules are as follows:\n\n" + "1. Two opponents are moving across the field one tile at a time, each of them gets 100 Health and 100 Stamina at the start.\n" + "\n 2. Each move costs 5 Stamina, if the player stays in the same tile, he regenerates 10 Stamina.\n" + "\n 3. When opponents are adjacent, they can attack each other. Attack costs 10 Stamina points for attacker and inflicts 30 health damage on the attacked. As long as stamina is above 0, attack is possible\n" + "\n 4. When Health of one of opponents gets to 0, game ends");
	JScrollPane scrollPane = new JScrollPane();
	
	public TitleFrame() {
		super();
		setResizable(false);
		setTitle("THE GAME");
		getContentPane().setLayout(null);
		btnNewGame.setBounds(10, 11, 131, 23);
		getContentPane().add(btnNewGame);
		btnNewGame.addActionListener(this);  // First Action Listener
		
		btnLoad.setBounds(10, 165, 131, 47);
		getContentPane().add(btnLoad);
		btnLoad.addActionListener(this);
		
		scrollPane.setBounds(151, 9, 324, 203);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		
		JLabel lblXRow = new JLabel("X row");
		lblXRow.setBounds(10, 48, 46, 14);
		getContentPane().add(lblXRow);
		
		JLabel lblYRow = new JLabel("Y row");
		lblYRow.setBounds(10, 101, 46, 14);
		getContentPane().add(lblYRow);
		
		textField = new JTextField();
		textField.setBounds(46, 45, 30, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText("5");
		
		textField_1 = new JTextField();
		textField_1.setBounds(46, 98, 30, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText("5");
		
		JLabel label = new JLabel("(3 - 10) ");
		label.setBounds(86, 48, 46, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("(3 - 10) ");
		label_1.setBounds(86, 101, 46, 14);
		getContentPane().add(label_1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnNewGame == e.getSource()) {
			NewGame();
		}
		if (btnLoad == e.getSource()) {
			rootPane = getRootPane();
			FileOperations.load(rootPane);
			this.setVisible(false);
		}
	}
	
	public void NewGame() {
		String text = textField.getText();
		int xRow = Integer.parseInt(text);
		String text2 = textField_1.getText();
		int yRow = Integer.parseInt(text2);
		
		if (((xRow > 2) && (xRow <= 10)) && ((yRow > 2) && (yRow <= 10))) {
			//System.out.println(xRow + " " + yRow);
			MainFrame frame = new MainFrame(xRow, yRow);
			frame.setSize(1200, 700);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setVisible(false);
			//this.dispose();
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent ev) {
					rootPane.getTopLevelAncestor().setVisible(true);
				}
			});
		}
		else {
			System.out.println("row size too big");
			System.exit(1);
		}
	}
}