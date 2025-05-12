package model;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards;
    private int numberOfDecks;
    
    public Deck() {
    	this(1);
    }

    // Constructor: Initialize the deck with multiple decks and shuffle it
    public Deck(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
        cards = new Stack<>();
        getNewDeck();  // Populate the deck
    }

    // Draw a card from the top of the deck
    public Card drawCard() {
    	if (cards.size() < (numberOfDecks * 52) * 0.25) {  // Reshuffle when 25% of the deck remains
            getNewDeck();
        }
        return cards.pop();
    }

    // Get the number of remaining cards
    public int getRemainingCards() {
        return cards.size();
    }

    // Shuffle the deck
    private void shuffleDeck() {
        Collections.shuffle(cards);
    }

    // Generate a new deck with the specified number of decks
    private void getNewDeck() {
        cards.clear();  // Clear old cards before adding new ones

        for (int i = 0; i < numberOfDecks; i++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    cards.push(new Card(suit, rank));
                }
            }
        }

        shuffleDeck();  // Shuffle after adding all decks
    }

    // Print all the cards in the deck (for debugging)
    public void printDeck() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
