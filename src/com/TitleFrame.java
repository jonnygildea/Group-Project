package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JLabel;

class TitleFrame extends JFrame implements ActionListener
{
	final JTextField textField;
	final JTextField textField_1;
	JButton btnNewGame = new JButton("New Game");
	JButton btnSave = new JButton("Save");
	JButton btnLoad = new JButton("Load");
	JTextArea textArea = new JTextArea();
	JButton btnRules = new JButton("Rules");
	JScrollPane scrollPane = new JScrollPane(textArea);
	
	public TitleFrame() 
	{
		super();
		setTitle("THE GAME");
		getContentPane().setLayout(null);
		btnNewGame.setBounds(10, 11, 102, 23);
		getContentPane().add(btnNewGame);
		btnNewGame.addActionListener(this);  // First Action Listener
		
		btnSave.setBounds(11, 173, 66, 23);
		getContentPane().add(btnSave);
		btnLoad.setBounds(87, 173, 68, 23);
		getContentPane().add(btnLoad);
		scrollPane.setBounds(159, 43, 290, 177);
		getContentPane().add(scrollPane);
		
		JLabel lblXRow = new JLabel("X row");
		lblXRow.setBounds(10, 72, 46, 14);
		getContentPane().add(lblXRow);
		
		JLabel lblYRow = new JLabel("Y row");
		lblYRow.setBounds(10, 126, 46, 14);
		getContentPane().add(lblYRow);
		
		textField = new JTextField();
		textField.setBounds(46, 69, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);	
		textField.setText("5");
		
		textField_1 = new JTextField();
		textField_1.setBounds(46, 123, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText("5");
		
		
		btnRules.setBounds(151, 11, 89, 23);
		getContentPane().add(btnRules);
		btnRules.addActionListener(this);       // Second ActionListener
		
		JLabel label = new JLabel("(3 - 10) ");
		label.setBounds(66, 89, 46, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("(3 - 10) ");
		label_1.setBounds(66, 142, 46, 14);
		getContentPane().add(label_1);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(btnNewGame == e.getSource())
		{
			validator();
		}
		
		if(btnRules == e.getSource())
		{
			textArea.setText("The rules are as follows:\n"
					+ "\n 1. Two opponents are moving across the field "
					+ "\n one tile at a time, each of them gets "
					+ "\n 100 Health and 100 Stamina at the start.\n"
					+ "\n 2. Each move costs 5 Stamina, if the player"
					+ "\n stays in the same tile, he regenerates 10"
					+ "\n Stamina.\n"
					+ "\n 3. When opponents are adjacent, they "
					+ "\n can attack each other. Attack costs 10 "
					+ "\n Stamina points for attacker and inflicts 30"
					+ "\n health damage on the attacked. As long as "
					+ "\n stamina is above 0, attack is possible\n"
					+ "\n 4. When Health of one of opponents gets to 0, "
					+ "\n game ends");
		}
	}
	
	public void validator()
	{
		//int xRow=0;
		//int yRow=0;
		
		try
		{						
			String text = textField.getText();
			int xRow = Integer.parseInt(text);
			String text2 = textField_1.getText();
			int yRow = Integer.parseInt(text2);
			
			
			if (((xRow>2)&&(xRow<=10))&&((yRow>2)&&(yRow<=10)))
			{
				JFrame frame = new MainFrame(xRow,yRow);
				frame.setSize(1200, 700);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setVisible(false);
			}
			else
				throw new Exception();
		}
		catch (Exception e)
		{
			textArea.setText("EXCEPTION, couldn't parse the values\n or invalid range of values");
		}	
	}
}