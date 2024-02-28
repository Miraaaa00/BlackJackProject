/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *This class represents a deck of cards in a Blackjack game.
 *It is currently includes instance variables to store the cards and 
 *a constructor to initialize and empty deck.
 *Also have a method createFullDeck to populates 52 card deck by iterating through suit and value combination.
 *toString method generates string representation of deck.
 * @author Kristina/Jasmeen
 */
public class Deck {
    //Instance variables
    private ArrayList<Card> cards;
    
    //Constructor
    public Deck(){
        this.cards =new ArrayList<Card>();
    }
    
    public void createFullDeck(){
        //generate cards
        for(Suit cardSuit : Suit.values()){     //4 values
            for(Value cardValue :Value.values()){       //13 cards
                //add a new card to the mix
                this.cards.add(new Card(cardSuit,cardValue));
            }
        }
    }
     //Get a string representation of all the cards in the deck
    public String toString(){
        String cardListOutput ="";
        int i =0;
        //card value with index
        for(Card aCard : this.cards){
            cardListOutput += "\n" + i + "-" + aCard.toString();
            i++;
        }
        return cardListOutput;
    
    }
}
