/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgfinal.project;

/**
 *
 * @author 3sumi
 */
public class Card {
    private Value value;
    private Suit suit;

    // Constructor
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    // Getter for value
    public Value getValue() {
        return value;
    }

    // Getter for suit
    public Suit getSuit() {
        return suit;
    }

    // Method to get the card's rank (numeric value)
    public int getRank() {
        switch (value) {
            case ACE:
                return 11; // Typically 11, can be adjusted later for Ace value flexibility
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN: return 10;
            case JACK: return 10;
            case QUEEN: return 10;
            case KING: return 10;
            default: throw new IllegalArgumentException("Unknown card value");
        }
    }

    // String representation of the card (e.g., "ACE of SPADES")
    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
