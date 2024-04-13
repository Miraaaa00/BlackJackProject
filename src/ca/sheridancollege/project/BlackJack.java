/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *This Class implements the main functionality of the Blackjack game.
 *Current codes will test and print all the 52 cards.
 * @author Kristina / Jasmeen
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to Blackjack!");

        // Prompt the user to enter their name
        System.out.println("Please enter your name:");
        String playerName = userInput.nextLine();

        // Create decks for playing, player, and dealer
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        // Player starts with $100
        double playerMoney = 100.0;

        // Game loop
        while (playerMoney > 0) {
            // Prompt the user to place a bet
            System.out.println("You have $" + playerMoney + ", how much would you like to bet?");
            double playerBet = userInput.nextDouble();

            // Check if the bet exceeds the player's money balance
            if (playerBet > playerMoney) {
                System.out.println("You cannot bet more than you have. Please enter a valid bet.");
                continue; // Continue to the next iteration of the loop
            }

            // Deal cards to the player and dealer
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            boolean endRound = false;
            boolean playerStand = false;
            boolean dealerStand = false;

            // Player's turn
            while (!playerStand) {
                // Display player's hand and value
                System.out.println("Your hand:");
                System.out.println(playerDeck.toString());
                System.out.println("Your hand is valued at: " + playerDeck.cardsValue());

                // Display dealer's hand with one card hidden
                System.out.println("Dealer Hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]");

                // Ask the player to hit or stand
                System.out.println("Would you like to (1) Hit or (2) Stand?");
                int response = userInput.nextInt();
                if (response == 1) {
                    // Player chooses to hit
                    playerDeck.draw(playingDeck);
                    System.out.println("You draw a: " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
                    // Check if player busts
                    if (playerDeck.cardsValue() > 21) {
                        System.out.println("Bust. Currently valued at: " + playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        playerStand = true;
                    }
                } else if (response == 2) {
                    // Player chooses to stand
                    playerStand = true;
                }
            }

            // Dealer's turn
            while (!dealerStand && !endRound) {
                System.out.println("Dealer Hand: " + dealerDeck.toString());
                System.out.println("Dealer's Hand is valued at: " + dealerDeck.cardsValue());
                // Dealer draws until hand value is at least 17
                if (dealerDeck.cardsValue() < 17) {
                    dealerDeck.draw(playingDeck);
                    System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
                } else {
                    dealerStand = true;
                }
            }

            // Determine the winner
            int playerScore = playerDeck.cardsValue();
            int dealerScore = dealerDeck.cardsValue();
            if (!endRound) {
                if (playerScore > dealerScore || dealerScore > 21) {
                    System.out.println("You win the hand!");
                    playerMoney += playerBet;
                } else if (playerScore < dealerScore) {
                    System.out.println("Dealer beats you!");
                    playerMoney -= playerBet;
                } else {
                    System.out.println("Push");
                }
            }

            // Move all cards back to the playing deck
            playerDeck.moveAllTODeck(playingDeck);
            dealerDeck.moveAllTODeck(playingDeck);
            System.out.println("End of hand");
        }

        System.out.println("Game Over! You are out of money.");
    }
    
}
