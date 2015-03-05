package com.Vitalij;

import java.io.Serializable;

public class Record implements Serializable {
	private static final long serialVersionUID = 1L;
	int xRow;
	int yRow;
	
	int p1Health;
	int p1Stamina;
	int p2Health;
	int p2Stamina;
	
	int player1CurrentLocationX;
	int player1CurrentLocationY;
	int player1LastLocationX;
	int player1LastLocationY;
	
	int player2CurrentLocationX;
	int player2CurrentLocationY;
	int player2LastLocationX;
	int player2LastLocationY;
	
	int sign;
	int recordNumber;
	
	Record(MainFrame m) {
		this(m.player1, m.player2, m);
	}
	
	Record(Player p1, Player p2, MainFrame m) {
		this(p1.getHealth(), p1.getStamina(), p2.getHealth(), p2.getStamina(),
		
		p1.getCurrent().getX(), p1.getCurrent().getY(), p1.getLast().getX(), p1.getLast().getY(), p2.getCurrent().getX(), p2.getCurrent().getY(), p2.getLast().getX(), p2.getLast().getY(), m.getSign(), m.getxRow(), m.getyRow());
	}
	
	Record(int p1Health, int p1Stamina, int p2Health, int p2Stamina, int player1CurrentLocationX, int player1CurrentLocationY, int player1LastLocationX, int player1LastLocationY, int player2CurrentLocationX, int player2CurrentLocationY, int player2LastLocationX, int player2LastLocationY, int sign, int xRow, int yRow) {
		this.p1Health = p1Health;
		this.p1Stamina = p1Stamina;
		this.p2Health = p2Health;
		this.p2Stamina = p2Stamina;
		
		this.player1CurrentLocationX = player1CurrentLocationX;
		this.player1CurrentLocationY = player1CurrentLocationY;
		this.player1LastLocationX = player1LastLocationX;
		this.player1LastLocationY = player1LastLocationY;
		
		this.player2CurrentLocationX = player2CurrentLocationX;
		this.player2CurrentLocationY = player2CurrentLocationY;
		this.player2LastLocationX = player2LastLocationX;
		this.player2LastLocationY = player2LastLocationY;
		
		this.sign = sign;
		
		this.xRow = xRow;
		this.yRow = yRow;
	}
	
	public int getP1Health() {
		return p1Health;
	}
	
	public int getP1Stamina() {
		return p1Stamina;
	}
	
	public int getP2Health() {
		return p2Health;
	}
	
	public int getP2Stamina() {
		return p2Stamina;
	}
	
	public int getPlayer1CurrentLocationX() {
		return player1CurrentLocationX;
	}
	
	public int getPlayer1CurrentLocationY() {
		return player1CurrentLocationY;
	}
	
	public int getPlayer1LastLocationX() {
		return player1LastLocationX;
	}
	
	public int getPlayer1LastLocationY() {
		return player1LastLocationY;
	}
	
	public int getPlayer2CurrentLocationX() {
		return player2CurrentLocationX;
	}
	
	public int getPlayer2CurrentLocationY() {
		return player2CurrentLocationY;
	}
	
	public int getPlayer2LastLocationX() {
		return player2LastLocationX;
	}
	
	public int getPlayer2LastLocationY() {
		return player2LastLocationY;
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