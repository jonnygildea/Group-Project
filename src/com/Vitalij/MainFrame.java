package com.Vitalij;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	int xRow = 10;
	int yRow = 10;
	
	JPanel detailsPanel;
	JPanel actionPanel;
	JPanel textPanel;
	//JTextField textField = new JTextField(10);
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	
	// ActionPanel stuff
	JButton[][] button;
	int count = 0;
	int sign = 0;
	
	Location p1;
	Location p1last;
	Location p2;
	Location p2last;
	
	Player player1;
	Player player2;
	
	JLabel p1LabelHealth = new JLabel("Player 1 Health");
	JLabel p1LabelStamina = new JLabel("Player 1 Stamina");
	JTextField p1TextHealth = new JTextField(10);
	JTextField p1TextStamina = new JTextField(10);
	
	JLabel p2LabelHealth = new JLabel("Player 2 Health");
	JLabel p2LabelStamina = new JLabel("Player 2 Stamina");
	JTextField p2TextHealth = new JTextField(10);
	JTextField p2TextStamina = new JTextField(10);
	
	Color originalP1TextHealthColor;
	
	public MainFrame(int x, int y) {
		super();
		xRow = x;
		yRow = y;
		
		button = new JButton[xRow][yRow];
		
		p1 = new Location(xRow - 1, 0);
		p1last = new Location(xRow - 1, 0);
		p2 = new Location(0, yRow - 1);
		p2last = new Location(0, yRow - 1);
		
		player1 = new Player();
		player2 = new Player();
		
		textArea.setEditable(false);		                                              ////////// mah shit
		
		detailsPanel = new JPanel();
		actionPanel = new JPanel();
		textPanel = new JPanel();
		
		// DetailsPanel setup
		Dimension size = getPreferredSize();
		size.width = 250;
		detailsPanel.setPreferredSize(size);
		detailsPanel.setBorder(BorderFactory.createTitledBorder("STATS"));
		
		detailsPanel.add(p1LabelHealth);
		detailsPanel.add(p1TextHealth);
		p1TextHealth.setText(Integer.toString(player1.getHealth()));
		
		detailsPanel.add(p1LabelStamina);
		detailsPanel.add(p1TextStamina);
		p1TextStamina.setText(Integer.toString(player1.getStamina()));
		
		detailsPanel.add(p2LabelHealth);
		detailsPanel.add(p2TextHealth);
		p2TextHealth.setText(Integer.toString(player2.getHealth()));
		
		detailsPanel.add(p2LabelStamina);
		detailsPanel.add(p2TextStamina);
		p2TextStamina.setText(Integer.toString(player2.getStamina()));
		
		originalP1TextHealthColor = p1TextHealth.getBackground();
		
		// textPanel setup
		Dimension size2 = getPreferredSize();
		size.width = 250;
		textPanel.setPreferredSize(size);
		textPanel.setBorder(BorderFactory.createTitledBorder("STATS"));
		textArea.append("GAME STARTED\n \n");
		
		textPanel.setLayout(new BorderLayout());
		//textPanel.add(textArea);
		textPanel.add(scrollPane);
		
		// ActionPanel setup
		actionPanel.setBorder(BorderFactory.createTitledBorder("GAME AREA"));
		actionPanel.setLayout(new GridLayout(xRow, yRow));
		
		for (int i = 0; i < xRow; i++) {
			for (int j = 0; j < yRow; j++) {
				button[i][j] = new JButton();
				//button[i][j].setIcon(new ImageIcon("G:\\PROJECT\\blank.png"));
				actionPanel.add(button[i][j]);
				button[i][j].setEnabled(false);
				button[i][j].addActionListener(this);
				
			}
			
		}
		actionPanel.setVisible(true);
		
		button[xRow - 1][0].setText("Player 1");
		//button[2][0].setIcon(new ImageIcon("G:\\PROJECT\\Player1.png"));
		button[0][yRow - 1].setText("Player 2");
		//button[2][4].setIcon(new ImageIcon("G:\\PROJECT\\Player2.png"));
		
		displayMovementArea(p1last);
		
		// Setup Panels on a frame
		setLayout(new BorderLayout());
		Container c = getContentPane();
		c.add(textPanel, BorderLayout.EAST);
		c.add(actionPanel, BorderLayout.CENTER);
		c.add(detailsPanel, BorderLayout.WEST);
		this.pack(); // WTF does this do ???
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (player1.getHealth() <= 75)
			p1TextHealth.setBackground(Color.YELLOW);
		if (player1.getHealth() <= 50)
			p1TextHealth.setBackground(Color.ORANGE);
		if (player1.getHealth() > 75)
			p1TextHealth.setBackground(originalP1TextHealthColor);
		//if (player1.getHealth()==0)
		//	p1TextHealth.setBackground(Color.RED);					// Currently set in check method
		
		if (player1.getStamina() <= 75)
			p1TextStamina.setBackground(Color.YELLOW);
		if (player1.getStamina() <= 50)
			p1TextStamina.setBackground(Color.ORANGE);
		if (player1.getStamina() > 75)
			p1TextStamina.setBackground(originalP1TextHealthColor);
		//if (player1.getStamina()==0)
		//	p1TextStamina.setBackground(Color.RED);					// Currently set in check method
		
		if (player2.getHealth() <= 75)
			p2TextHealth.setBackground(Color.YELLOW);
		if (player2.getHealth() <= 50)
			p2TextHealth.setBackground(Color.ORANGE);
		if (player2.getHealth() > 75)
			p2TextHealth.setBackground(originalP1TextHealthColor);
		//if (player2.getHealth()==0)
		//	p2TextHealth.setBackground(Color.RED);					// Currently set in check method
		
		if (player2.getStamina() <= 75)
			p2TextStamina.setBackground(Color.YELLOW);
		if (player2.getStamina() <= 50)
			p2TextStamina.setBackground(Color.ORANGE);
		if (player2.getStamina() > 75)
			p2TextStamina.setBackground(originalP1TextHealthColor);
		//if (player2.getStamina()==0)
		//	p2TextStamina.setBackground(Color.RED);                 // Currently set in check method
		
		for (int i = 0; i < xRow; i++) {
			for (int j = 0; j < yRow; j++) {
				if (button[i][j] == e.getSource()) {
					if (sign % 2 == 0) {
						if ((i == p2.getX()) && (j == p2.getY())) {
							player2.setHealth(player2.getHealth() - 30);
							player1.setStamina(player1.getStamina() - 10);
							p2TextHealth.setText(Integer.toString(player2.getHealth()));
							p1TextStamina.setText(Integer.toString(player1.getStamina()));
							
							displayMovementArea(p2);
							textArea.append("Player 1 attacks for 30 HP,\n PLAYER 2 TURN\n \n");
							check();
						}
						else if ((i == p1.getX()) && (j == p1.getY())) {
							player1.setStamina(player1.getStamina() + 10);
							p1TextStamina.setText(Integer.toString(player1.getStamina()));
							
							displayMovementArea(p2);
							textArea.append("Player 1 stays,\n PLAYER 2 TURN\n \n");
							check();
						}
						else {
							button[i][j].setText("Player 1");
							//button[i][j].setIcon(new ImageIcon("G:\\PROJECT\\Player1.png"));
							button[i][j].setEnabled(false);
							p1last = p1;
							p1 = new Location(i, j);
							button[p1last.getX()][p1last.getY()].setText("");
							//button[p1last.getX()][p1last.getY()].setIcon(null);
							
							player1.setStamina(player1.getStamina() - 5);
							p1TextStamina.setText(Integer.toString(player1.getStamina()));
							
							displayMovementArea(p2);
							textArea.append("Player 1 moved,\n PLAYER 2 TURN\n \n");
							check();
						}
					}
					else {
						if ((i == p1.getX()) && (j == p1.getY())) {
							player1.setHealth(player1.getHealth() - 30);
							player2.setStamina(player2.getStamina() - 10);
							p1TextHealth.setText(Integer.toString(player1.getHealth()));
							p2TextStamina.setText(Integer.toString(player2.getStamina()));
							
							displayMovementArea(p1);
							textArea.append("Player 2 attacks for 30HP, \nPLAYER 1 TURN\n \n");
							check();
						}
						else if ((i == p2.getX()) && (j == p2.getY())) {
							player2.setStamina(player2.getStamina() + 10);
							p2TextStamina.setText(Integer.toString(player2.getStamina()));
							
							displayMovementArea(p1);
							textArea.append("Player 2 stays,\nPLAYER 1 TURN\n \n");
							check();
						}
						else {
							button[i][j].setText("Player 2");
							//button[i][j].setIcon(new ImageIcon("G:\\PROJECT\\Player2.png"));
							button[i][j].setEnabled(false);
							p2last = p2;
							p2 = new Location(i, j);
							button[p2last.getX()][p2last.getY()].setText("");
							//button[p2last.getX()][p2last.getY()].setIcon(null);
							
							player2.setStamina(player2.getStamina() - 5);
							p2TextStamina.setText(Integer.toString(player2.getStamina()));
							
							displayMovementArea(p1);
							textArea.append("Player 2 moved,\n PLAYER 1 TURN\n \n");
							check();
						}
					}
					sign++;
					count++;
				}
			}
		}
	}
	
	// method calculating the movement area
	public void displayMovementArea(Location l) {
		int x = l.getX();
		int y = l.getY();
		
		if ((sign % 2 != 0) && (player1.getStamina() == 0)) {
			//textArea.append("Player 1 has no stamina left,\n can only stay\n \n");
			for (int i = 0; i < xRow; i++) {
				for (int j = 0; j < yRow; j++) {
					if ((i == x) && (j == y)) {
						button[i][j].setEnabled(true);
					}
					else {
						button[i][j].setEnabled(false);
					}
				}
			}
			
		}
		else if ((sign % 2 == 0) && (player2.getStamina() == 0)) {
			//textArea.append("Player 2 has no stamina left,\n can only stay\n \n");
			for (int i = 0; i < xRow; i++) {
				for (int j = 0; j < yRow; j++) {
					if ((i == x) && (j == y)) {
						button[i][j].setEnabled(true);
					}
					else {
						button[i][j].setEnabled(false);
					}
				}
			}
		}
		else {
			for (int i = 0; i < xRow; i++) {
				for (int j = 0; j < yRow; j++) {
					if (((i == x - 1) && (j == y - 1)) | ((i == x - 1) && (j == y)) | ((i == x - 1) && (j == y + 1)) | ((i == x) && (j == y - 1)) | ((i == x) && (j == y)) | ((i == x) && (j == y + 1)) | ((i == x + 1) && (j == y - 1)) | ((i == x + 1) && (j == y)) | ((i == x + 1) && (j == y + 1))) {
						button[i][j].setEnabled(true);
					}
					else
						button[i][j].setEnabled(false);
				}
			}
		}
	}
	
	// Checks if anyone won yet
	public void check() {
		if ((sign % 2 != 0) && (player1.getStamina() == 0))
			textArea.append("Player 1 has no stamina left,\n can only stay\n \n");
		if ((sign % 2 == 0) && (player2.getStamina() == 0))
			textArea.append("Player 2 has no stamina left,\n can only stay\n \n");
		
		if (player1.getHealth() <= 0) {
			//textArea.setText("Game Over, Player 2 won");
			textArea.append("GAME OVER,\n Player 2 won\n \n");
			p1TextHealth.setBackground(Color.RED);
			gameOver();
		}
		else {
			if (player2.getHealth() <= 0) {
				//textArea.setText("Game Over, Player 2 won");
				textArea.append("GAME OVER,\n Player 1 won\n \n");
				p2TextHealth.setBackground(Color.RED);
				gameOver();
			}
		}
	}
	
	// Finishes game, disabling buttons
	public void gameOver() {
		for (int i = 0; i < xRow; i++) {
			for (int j = 0; j < yRow; j++) {
				button[i][j].setEnabled(false);
			}
		}
	}
}