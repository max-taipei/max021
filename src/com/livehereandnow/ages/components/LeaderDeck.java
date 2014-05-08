/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.components;

/**
 *
 * @author mark
 */
public class LeaderDeck {

    private boolean[] taken = new boolean[4];// for 4 ages, to check when get given age's leader's card
    private boolean[] played = new boolean[4];// 
    private Card card;

    public boolean isLeaderInPlay(){
        for (int k = 0; k < 4; k++) {
            if (played[k]) {
               return true;
            }
        }
        return false;
    }
    
    public Card getCard() {
        return card;
    }

    public void setCard(Card c) {
        int age=c.get時代();
        System.out.println(" ???"+c.toString(10));
        
        played[age]=true;
        card = c;
    }

    public LeaderDeck() {
        super();
        taken[0] = false;
        taken[1] = false;
        taken[2] = false;
        taken[3] = false;
        played[0] = false;
        played[1] = false;
        played[2] = false;
        played[3] = false;

    }

    /**
     *
     * @param k age number, 0:A, 1:I, 2:II, 3:III
     * @return true: got this age's leader's before
     */
    public boolean isTaken(int k) {
        return taken[k];
    }

    public void setTaken(int k) {
        taken[k] = true;
    }

    public boolean isPlayed(int k) {
        return played[k];
    }

    public void setPlayed(int k) {
        played[k] = true;
    }

    @Override
    public String toString() {
     
        
        StringBuilder sb = new StringBuilder();
        sb.append(" taken:");
        for (int k = 0; k < 4; k++) {
            if (taken[k]) {
                sb.append("*");
            } else {
                sb.append(k);
            }
        }
        sb.append(" played:");
        for (int k = 0; k < 4; k++) {
            if (played[k]) {
                sb.append("*");
            } else {
                sb.append(k);
            }
        }
        if (!isLeaderInPlay()){
            return sb.toString();
        }   
        return card.toString(9) + sb.toString();
    }

}
