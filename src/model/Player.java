package model;

public class Player {
	private Hand hand = new Hand();
	private int wager;
	private int money;
	private int playerNumber;
	
	public Player() {
		setMoney(100);
	}
	
	public Player(int playerNumber) {
		this();
		setPlayerNumber(playerNumber);
	}
	
	public void addCardToHand(Card card) {
		this.hand.addCard(card);
	}
	
	public Hand getHand() {
		return this.hand;
	}
	
	public void setWager(int wager) {
		this.wager = wager;
	}
	
	public int getWager() {
		return this.wager;
	}
	
	private void setMoney(int money) {
		this.money = money;
	}
	
	public int getPlayerNumber() {
		return this.playerNumber;
	}
	
	private void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public int getPlayerTotal() {
		return this.getHand().total();
	}
}
