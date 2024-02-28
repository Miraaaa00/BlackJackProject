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
        // Introduction Message
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        
        System.out.println(playingDeck);
    }
    
}
