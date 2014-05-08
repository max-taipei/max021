/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livehereandnow.ages.components;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mark
 */
public class CardDeck {
    private List<Card> list;

    public List<Card> getList() {
        return list;
    }

    public int getCardCount(){
        return list.size();
    }
    public CardDeck() {
        list=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "牌數:" + list.size();
    }
    
}
