/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Kristina
 */
public class Deck {
    //instance vars
    private ArrayList<Card> cards;
    
    //construct
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
     //return string for  all of the card
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
