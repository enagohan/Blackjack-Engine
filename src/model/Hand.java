package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private int currentTotal = 0;
	private int aceCount = 0;	
	private List<Card> cardsInHand;
	private final int BLACKJACK = 21;

	public Hand() {
	    cardsInHand = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		this.cardsInHand.add(card);
		currentTotal += card.rank().getValue();
		if(card.rank() == Rank.ACE)
			aceCount++;
		if(currentTotal > BLACKJACK) {
			while(currentTotal > BLACKJACK && aceCount > 0) {
				currentTotal -= 10;	
				aceCount--;
			}
		}			
	}
	
	public int total() {
		return this.currentTotal;
	}
	
	@Override
	public String toString() {
		String printString = "";
		for(Card c: cardsInHand) {
			printString += c.toString() + ", ";
		}
		printString += "total: " + total();
		return printString;
	}
}
