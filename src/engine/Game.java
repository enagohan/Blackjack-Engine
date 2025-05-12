package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Deck;
import model.Player;

public class Game {
	private final Deck deck;
	private final Scanner scanner;
	private final List<Player> players;
	private final Player dealer;
	private final int BLACKJACK = 21;
	
	public Game(int numberOfPlayers) {
		this.deck = new Deck();
		this.scanner = new Scanner(System.in);
		this.dealer = new Player();
		players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(i+1));
        }
	}
	
	public Game() {
		this(1);
	}
	
	public void start() {
		dealInitialCards();
		printGameState();		
		boolean gameOn = true;
		for(Player player:players) {
			gameOn = checkForWin(player);
		}
		
		while(gameOn) {
			for(Player player:players) {				
				System.out.println("What would you like to do Player " + player.getPlayerNumber()
				+ ":\nPress 1 for hit\nPress 2 for stand");
				if(scanner.hasNextInt()) {
					if(scanner.nextInt() == 1)
						player.addCardToHand(deck.drawCard());
				}				
				printGameState();
				gameOn = checkForWin(player);
				
			}
			if(dealer.getPlayerTotal() < 17) {
				dealer.addCardToHand(deck.drawCard());
				printGameState();
			}
		}
		
	}
	
	private void dealInitialCards() {
		dealer.addCardToHand(deck.drawCard());
		dealer.addCardToHand(deck.drawCard());
		for(Player player:players) {
			player.addCardToHand(deck.drawCard());
			player.addCardToHand(deck.drawCard());
		}
	}
	
	private void printGameState() {
		System.out.println("Dealers cards:");
		System.out.println(dealer.getHand());
		for(Player player:players) {
			System.out.println("Player " +  player.getPlayerNumber() + "'s cards:");
			System.out.println(player.getHand());
		}
	}
	

	private boolean checkForWin(Player player) {
		boolean on = true;
		if(player.getPlayerTotal() > BLACKJACK) {
			System.out.println("you lose!");
			on = false;
		}
		
		if(player.getPlayerTotal() == BLACKJACK && dealer.getPlayerTotal() != BLACKJACK) {
			System.out.println("you win!");
			on = false;
		}
		
		if(player.getPlayerTotal() == BLACKJACK && dealer.getPlayerTotal() == BLACKJACK) {
			System.out.println("you lose!");
			on = false;
		}
		return on;
	}
	
	
}
