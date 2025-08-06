/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkgfinal.project;

import java.util.Scanner;

/**
 *
 * @author 3sumi
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Blackjack game = new Blackjack();

        System.out.println("Welcome to Blackjack!");
        game.startGame();
        System.out.println(game.getPlayerHand());
        System.out.println(game.getDealerHand().split(",")[0] + ", [hidden card]");

        // Player's turn
        while (game.getPlayerHandValue() < 21) {
            System.out.println("\nDo you want to (h)it or (s)tand?");
            String action = scanner.nextLine().toLowerCase();

            if (action.equals("h")) {
                game.dealToPlayer();
                System.out.println(game.getPlayerHand());
            } else if (action.equals("s")) {
                break;
            } else {
                System.out.println("Invalid choice, please enter 'h' to hit or 's' to stand.");
            }
        }

        // Dealer's turn
        System.out.println("\nDealer's turn: " + game.getDealerHand());

        while (game.getDealerHandValue() < 17) {
            System.out.println("Dealer hits!");
            game.dealToDealer();
            System.out.println(game.getDealerHand());
        }

        if (game.getDealerHandValue() > 21) {
            System.out.println("Dealer busted! Player wins!");
        } else {
            System.out.println("\n" + game.determineWinner());
        }

        scanner.close();
    }
    
}
