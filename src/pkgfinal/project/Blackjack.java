/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgfinal.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 3sumi
 */
public class Blackjack {

    private List<Card> deck;
    private List<Card> playerHand;
    private List<Card> dealerHand;

    public Blackjack() {
        this.deck = new ArrayList<Card>();
        this.playerHand = new ArrayList<Card>();
        this.dealerHand = new ArrayList<Card>();
        initializeDeck();
        shuffleDeck();
    }

    // Initialize the deck of 52 cards
    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                this.deck.add(new Card(value, suit));
            }
        }
    }

    // Shuffle the deck
    private void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    // Deal two cards to both the player and the dealer
    public void startGame() {
        this.playerHand.clear();
        this.dealerHand.clear();

        this.playerHand.add(deck.remove(deck.size() - 1));
        this.dealerHand.add(deck.remove(deck.size() - 1));
        this.playerHand.add(deck.remove(deck.size() - 1));
        this.dealerHand.add(deck.remove(deck.size() - 1));
    }

    // Get the total value of a hand
    public int getHandValue(List<Card> hand) {
        int value = 0;
        int aceCount = 0;

        for (Card card : hand) {
            value += card.getRank();
            if (card.getValue() == Value.ACE) {
                aceCount++;
            }
        }

        // Adjust for Aces (Ace can be 11 or 1)
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    public int getDealerHandValue() {
        return this.getHandValue(this.dealerHand);
    }

    public int getPlayerHandValue() {
        return this.getHandValue(this.playerHand);
    }

    // Check if either the player or the dealer has won
    public String determineWinner() {
        int playerValue = getHandValue(playerHand);
        int dealerValue = getHandValue(dealerHand);

        if (playerValue > 21) {
            return "Player busted! Dealer wins!";
        } else if (dealerValue > 21) {
            return "Dealer busted! Player wins!";
        } else if (playerValue > dealerValue) {
            return "Player wins!";
        } else if (dealerValue > playerValue) {
            return "Dealer wins!";
        } else {
            return "It's a tie!";
        }
    }

    // Display player and dealer hands
    public String getPlayerHand() {
        return "Player's hand: " + playerHand.toString() + " (Value: " + getHandValue(playerHand) + ")";
    }

    public String getDealerHand() {
        return "Dealer's hand: " + dealerHand.toString() + " (Value: " + getHandValue(dealerHand) + ")";
    }

    // Deal one card to the player
    public void dealToPlayer() {
        playerHand.add(deck.remove(deck.size() - 1));
    }

    // Deal one card to the dealer
    public void dealToDealer() {
        dealerHand.add(deck.remove(deck.size() - 1));
    }
}
