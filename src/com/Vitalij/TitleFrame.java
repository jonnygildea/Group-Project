package com.Vitalij;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JTextArea textArea = new JTextArea("The rules are as follows:\n" + "1. Two opponents are moving across the field one tile at a time, each of them gets 100 Health and 100 Stamina at the start.\n" + "\n 2. Each move costs 5 Stamina, if the player stays in the same tile, he regenerates 10 Stamina.\n" + "\n 3. When opponents are adjacent, they can attack each other. Attack costs 10 Stamina points for attacker and inflicts 30 health damage on the attacked. As long as stamina is above 0, attack is possible\n" + "\n 4. When Health of one of opponents gets to 0, game ends");
	JScrollPane scrollPane = new JScrollPane(textArea);
	
	public TitleFrame() {
		super();
		setResizable(false);
		//setResizable(true);
		setSize(482, 313);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		setTitle("THE GAME");
		getContentPane().setLayout(null);
		btnNewGame.setBounds(10, 11, 122, 26);
		getContentPane().add(btnNewGame);
		btnNewGame.addActionListener(this);  // First Action Listener
		
		btnSave.setBounds(37, 192, 68, 23);
		getContentPane().add(btnSave);
		btnLoad.setBounds(37, 158, 68, 23);
		getContentPane().add(btnLoad);
		scrollPane.setBounds(142, 9, 317, 260);
		getContentPane().add(scrollPane);
		
		JLabel lblXRow = new JLabel("X row");
		lblXRow.setBounds(10, 51, 34, 14);
		getContentPane().add(lblXRow);
		
		JLabel lblYRow = new JLabel("Y row");
		lblYRow.setBounds(10, 79, 34, 14);
		getContentPane().add(lblYRow);
		
		textField = new JTextField();
		textField.setBounds(46, 48, 34, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText("5");
		
		textField_1 = new JTextField();
		textField_1.setBounds(46, 76, 34, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText("5");
		
		//btnRules.setBounds(151, 11, 89, 23);
		//getContentPane().add(btnRules);
		//btnRules.addActionListener(this);       // Second ActionListener
		
		JLabel label = new JLabel("(3 - 10) ");
		label.setBounds(86, 51, 46, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("(3 - 10) ");
		label_1.setBounds(86, 79, 46, 14);
		getContentPane().add(label_1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		validator();
	}
	
	public void validator() {
		try {
			String text = textField.getText();
			int xRow = Integer.parseInt(text);
			String text2 = textField_1.getText();
			int yRow = Integer.parseInt(text2);
			
			if (((xRow > 2) && (xRow <= 10)) && ((yRow > 2) && (yRow <= 10))) {
				JFrame frame = new MainFrame(xRow, yRow);
				frame.setSize(1200, 700);
				frame.setVisible(true);
				//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//this.setVisible(false);
				this.dispose();
			}
			else
				throw new Exception();
		}
		catch (Exception e) {
			textArea.setText("EXCEPTION, couldn't parse the values or invalid range of values");
		}
	}
}