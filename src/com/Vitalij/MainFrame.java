package com.Vitalij;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	JLabel p1LabelHealth = new JLabel("Player 1 Health");
	JLabel p1LabelStamina = new JLabel("Player 1 Stamina");
	JTextField p1TextHealth = new JTextField(10);
	JTextField p1TextStamina = new JTextField(10);
	
	Player player2;
	JLabel p2LabelHealth = new JLabel("Player 2 Health");
	JLabel p2LabelStamina = new JLabel("Player 2 Stamina");
	JTextField p2TextHealth = new JTextField(10);
	JTextField p2TextStamina = new JTextField(10);
	
	Color originalP1TextHealthColor;
	
	JButton saveButton;
	
	JLabel tile = new JLabel();
	JLabel p1label = new JLabel();
	JLabel p2label = new JLabel();
	
	/////////////////////////////////////////////////////////////////////////////////
	
	String player1icon = "/com/Vitalij/player1.png";
	String player2icon = "/com/Vitalij/player2.png";
	String tile1icon = "/com/Vitalij/tile1.png";
	
	///////////////////////////////////////////////////////////////////////////////
	
	public MainFrame(Record r) {
		this(r.getxRow(), r.getyRow());
		
		p1 = new Location(r.getPlayer1CurrentLocationX(), r.getPlayer1CurrentLocationY());
		p1last = new Location(r.getPlayer1LastLocationX(), r.getPlayer1LastLocationY());
		p2 = new Location(r.getPlayer2CurrentLocationX(), r.getPlayer2CurrentLocationY());
		p2last = new Location(r.getPlayer2LastLocationX(), r.getPlayer2LastLocationY());
		
		player1.setCurrent(p1);
		player1.setLast(p1last);
		player2.setCurrent(p2);
		player2.setLast(p2last);
		
		player1.setHealth(r.getP1Health());
		player1.setStamina(r.getP1Stamina());
		player2.setHealth(r.getP2Health());
		player2.setStamina(r.getP2Stamina());
		
		sign = r.getSign();
		
		p1TextHealth.setText(Integer.toString(player1.getHealth()));
		p1TextStamina.setText(Integer.toString(player1.getStamina()));
		p2TextHealth.setText(Integer.toString(player2.getHealth()));
		p2TextStamina.setText(Integer.toString(player2.getStamina()));
		
		button[xRow - 1][0].setIcon(new ImageIcon(MainFrame.class.getResource(tile1icon)));
		button[0][yRow - 1].setIcon(new ImageIcon(MainFrame.class.getResource(tile1icon)));
		
		button[player1.getCurrent().getX()][player1.getCurrent().getY()].setIcon(new ImageIcon(MainFrame.class.getResource(player1icon)));
		button[player2.getCurrent().getX()][player2.getCurrent().getY()].setIcon(new ImageIcon(MainFrame.class.getResource(player2icon)));
		
		if (sign % 2 == 0) {
			displayMovementArea(p1);
		}
		else {
			displayMovementArea(p2);
		}
		
		setTextColor();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				rootPane.getTopLevelAncestor().setVisible(true);
			}
		});
	}
	
	public MainFrame(int x, int y) {
		super();
		xRow = x;
		yRow = y;
		
		button = new JButton[xRow][yRow];
		
		player1 = new Player();
		player2 = new Player();
		
		p1 = new Location(xRow - 1, 0);
		player1.setCurrent(p1);
		
		p1last = new Location(xRow - 1, 0);
		player1.setLast(p1last);
		
		p2 = new Location(0, yRow - 1);
		player2.setCurrent(p2);
		
		p2last = new Location(0, yRow - 1);
		player2.setLast(p2last);
		
		textArea.setEditable(false);
		
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
		
		// Adding Save Button
		saveButton = new JButton("SAVE");
		detailsPanel.add(saveButton);
		saveButton.addActionListener(this);
		
		// textPanel setup
		size.width = 250;
		textPanel.setPreferredSize(size);
		textPanel.setBorder(BorderFactory.createTitledBorder("STATS"));
		textArea.append("GAME STARTED\n\n");
		
		textPanel.setLayout(new BorderLayout());
		textPanel.add(scrollPane);
		
		// ActionPanel setup
		actionPanel.setBorder(BorderFactory.createTitledBorder("GAME AREA"));
		actionPanel.setLayout(new GridLayout(xRow, yRow));
		
		///////////////////////////////////////////////////////////////////////////////
		tile.setIcon(new ImageIcon(tile1icon));
		tile.setVisible(true);
		p1label.setIcon(new ImageIcon(player1icon));
		tile.setVisible(true);
		p2label.setIcon(new ImageIcon(player2icon));
		tile.setVisible(true);
		////////////////////////////////////////////////////////////////////////////////
		
		for (int i = 0; i < xRow; i++) {
			for (int j = 0; j < yRow; j++) {
				button[i][j] = new JButton();
				button[i][j].setIcon(new ImageIcon(MainFrame.class.getResource(tile1icon)));
				
				button[i][j].setBorderPainted(false);
				button[i][j].setContentAreaFilled(false);
				
				actionPanel.add(button[i][j]);
				button[i][j].setEnabled(false);
				button[i][j].addActionListener(this);
			}
			
		}
		actionPanel.setVisible(true);
		
		button[xRow - 1][0].setIcon(new ImageIcon(MainFrame.class.getResource(player1icon)));
		
		button[0][yRow - 1].setIcon(new ImageIcon(MainFrame.class.getResource(player2icon)));
		
		displayMovementArea(p1last);
		
		// Setup Panels on a frame
		getContentPane().setLayout(new BorderLayout());
		Container c = getContentPane();
		c.add(textPanel, BorderLayout.EAST);
		c.add(actionPanel, BorderLayout.CENTER);
		c.add(detailsPanel, BorderLayout.WEST);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				rootPane.getTopLevelAncestor().setVisible(true);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (saveButton == e.getSource()) {
			FileOperations.save(this);
		}
		else {
			setTextColor();
			
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
								textArea.append("Player 1 attacks for 30 HP,\n PLAYER 2 TURN\n\n");
								check();
							}
							else if ((i == p1.getX()) && (j == p1.getY())) {
								player1.setStamina(player1.getStamina() + 10);
								p1TextStamina.setText(Integer.toString(player1.getStamina()));
								
								displayMovementArea(p2);
								textArea.append("Player 1 stays,\n PLAYER 2 TURN\n\n");
								check();
							}
							else {
								button[i][j].setIcon(new ImageIcon(MainFrame.class.getResource(player1icon)));
								
								p1last = p1;
								player1.setLast(p1last);
								
								p1 = new Location(i, j);
								player1.setCurrent(p1);
								
								button[p1last.getX()][p1last.getY()].setIcon(new ImageIcon(MainFrame.class.getResource(tile1icon)));
								
								player1.setStamina(player1.getStamina() - 5);
								p1TextStamina.setText(Integer.toString(player1.getStamina()));
								
								displayMovementArea(p2);
								textArea.append("Player 1 moved,\n PLAYER 2 TURN\n\n");
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
								textArea.append("Player 2 attacks for 30HP, \nPLAYER 1 TURN\n\n");
								check();
							}
							else if ((i == p2.getX()) && (j == p2.getY())) {
								player2.setStamina(player2.getStamina() + 10);
								p2TextStamina.setText(Integer.toString(player2.getStamina()));
								
								displayMovementArea(p1);
								textArea.append("Player 2 stays,\nPLAYER 1 TURN\n\n");
								check();
							}
							else {
								button[i][j].setIcon(new ImageIcon(MainFrame.class.getResource(player2icon)));
								button[i][j].setEnabled(false);
								
								p2last = p2;
								player2.setLast(p2last);
								
								p2 = new Location(i, j);
								player2.setCurrent(p2);
								
								button[p2last.getX()][p2last.getY()].setIcon(new ImageIcon(MainFrame.class.getResource(tile1icon)));
								
								player2.setStamina(player2.getStamina() - 5);
								p2TextStamina.setText(Integer.toString(player2.getStamina()));
								
								displayMovementArea(p1);
								textArea.append("Player 2 moved,\n PLAYER 1 TURN\n\n");
								check();
							}
						}
						sign++;
						count++;
					}
				}
			}
		}
	}
	
	// method calculating the movement area
	public void displayMovementArea(Location l) {
		int x = l.getX();
		int y = l.getY();
		
		if ((sign % 2 != 0) && (player1.getStamina() == 0)) {
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
					else {
						button[i][j].setEnabled(false);
					}
				}
			}
		}
	}
	
	// Checks if anyone won yet
	@SuppressWarnings("unused")
	public void check() {
		if ((sign % 2 != 0) && (player1.getStamina() == 0)) {
			textArea.append("Player 1 has no stamina left,\n can only stay\n\n");
		}
		if ((sign % 2 == 0) && (player2.getStamina() == 0)) {
			textArea.append("Player 2 has no stamina left,\n can only stay\n\n");
		}
		
		if (player1.getHealth() <= 0) {
			textArea.append("GAME OVER,\nPlayer 2 won\n\n");
			p1TextHealth.setBackground(Color.RED);
			gameOver();
			Popup gameover = new Popup(1);
		}
		else {
			if (player2.getHealth() <= 0) {
				textArea.append("GAME OVER,\nPlayer 1 won\n\n");
				p2TextHealth.setBackground(Color.RED);
				gameOver();
				Popup gameover = new Popup(2);
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
	
	public void setTextColor() {
		if (player1.getHealth() <= 75)
			p1TextHealth.setBackground(Color.YELLOW);
		if (player1.getHealth() <= 50)
			p1TextHealth.setBackground(Color.ORANGE);
		if (player1.getHealth() > 75)
			p1TextHealth.setBackground(originalP1TextHealthColor);
		
		if (player1.getStamina() <= 75)
			p1TextStamina.setBackground(Color.YELLOW);
		if (player1.getStamina() <= 50)
			p1TextStamina.setBackground(Color.ORANGE);
		if (player1.getStamina() > 75)
			p1TextStamina.setBackground(originalP1TextHealthColor);
		
		if (player2.getHealth() <= 75)
			p2TextHealth.setBackground(Color.YELLOW);
		if (player2.getHealth() <= 50)
			p2TextHealth.setBackground(Color.ORANGE);
		if (player2.getHealth() > 75)
			p2TextHealth.setBackground(originalP1TextHealthColor);
		
		if (player2.getStamina() <= 75)
			p2TextStamina.setBackground(Color.YELLOW);
		if (player2.getStamina() <= 50)
			p2TextStamina.setBackground(Color.ORANGE);
		if (player2.getStamina() > 75)
			p2TextStamina.setBackground(originalP1TextHealthColor);
		
	}
	
	public Location getP1() {
		return p1;
	}
	
	public void setP1(Location p1) {
		this.p1 = p1;
	}
	
	public Location getP1last() {
		return p1last;
	}
	
	public void setP1last(Location p1last) {
		this.p1last = p1last;
	}
	
	public Location getP2() {
		return p2;
	}
	
	public void setP2(Location p2) {
		this.p2 = p2;
	}
	
	public Location getP2last() {
		return p2last;
	}
	
	public void setP2last(Location p2last) {
		this.p2last = p2last;
	}
	
	public int getSign() {
		return sign;
	}
	
	public int getxRow() {
		return xRow;
	}
	
	public void setxRow(int xRow) {
		this.xRow = xRow;
	}
	
	public int getyRow() {
		return yRow;
	}
	
	public void setyRow(int yRow) {
		this.yRow = yRow;
	}
}