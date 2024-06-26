/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;

/**
 *This Java class, named Deck, represents a deck of playing cards.
 *It includes methods to initialize a full deck, shuffle the cards, 
 *draw cards, and compute the total value of the cards in the deck. 
 *Additionally, it provides functionality to move all cards from 
 *one deck to another and manage the deck's size.
 * @author Maria /Jasmeen
 */
public class Deck {
    //Instance variables
    private ArrayList<Card> cards;
    
    //Constructor
    public Deck(){
        this.cards =new ArrayList<Card>();
    }
    
    public void moveAllTODeck(Deck moveTO){
        int thisDeckSize = this.cards.size();
        
        //put carads into moveTo deck
        for (int i = 0; i < thisDeckSize; i++){
            moveTO.addCard(this.getCard(i));
        }
        for(int i =0; i < thisDeckSize;  i++){
            this.removeCard(0);
        }
    }
    //putting acrd on the deck
    public void createFullDeck(){
        //generate cards
        for(Suit cardSuit : Suit.values()){     //4 values
            for(Value cardValue :Value.values()){       //13 cards
                //add a new card to the mix
                this.cards.add(new Card(cardSuit,cardValue));
            }
        }
    }
    
    //shuffle the cards
    public void shuffle(){
        ArrayList<Card> tempDeck = new ArrayList<>();
        //use random
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i++){
            randomCardIndex = random.nextInt((this.cards.size()-1 -0)+ 1) + 0;
            tempDeck.add(this.cards.get(randomCardIndex));
            //remove from original deck
            this.cards.remove(randomCardIndex);
        }
        //putting back tot he original deck
        this.cards = tempDeck;
    }
    
    //return string for  all of the card
    @Override
    public String toString(){
        String cardListOutput ="";
        
        //card value with index
        for(Card aCard : this.cards){
            cardListOutput += "\n" + aCard.toString();
        }
        return cardListOutput;
    }
    //remove index from the array of card
    public void removeCard(int i){
        this.cards.remove(i);
    }
    public Card getCard(int i){
        return this.cards.get(i);
    }
    public void addCard(Card addCard){
        this.cards.add(addCard);
    }
    
    //draws from the deck , move deck one deck to another
    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }
    
    public int deckSize(){
        return this.cards.size();
                
    }
    //return total vlaue of cards in deck
    public int cardsValue(){
        int totalValue = 0;
        int aces= 0;
        
        for(Card aCard : this.cards){
            switch(aCard.getvalue()){
                case TWO: totalValue += 2; break;
                case THREE : totalValue += 3; break;
                case FOUR: totalValue += 4; break;
                case FIVE : totalValue += 5; break;
                case SIX: totalValue += 6; break;
                case SEVEN : totalValue += 7; break;
                case EIGHT: totalValue += 8; break;
                case NINE : totalValue += 9; break;
                case TEN: totalValue += 10; break;
                case JACK : totalValue += 10; break;
                case QUEEN: totalValue += 10; break;
                case KING : totalValue += 10; break;
                case ACE: totalValue += 1; break;
                
            }
        }
        
        for (int i=0; i< aces; i++){
            if(totalValue > 10){
                totalValue += 1;
            }
            else{
                totalValue += 11;
            }
        }
        return totalValue;
    }
}
