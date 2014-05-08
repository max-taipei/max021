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
public class History {
    private int currentRound;
    private String currentPlayer;
    private int currentActSeq;
    private List<HistoryRecord> records;

//    public List<HistoryRecord> getRecords() {
//        return records;
//    }

    public void addRecord(int round, String player,String cmd, String note){
        HistoryRecord rec=new HistoryRecord(round, player, cmd, note);
        if (currentPlayer.equals(player)){
            currentActSeq++;
        }else{
            currentPlayer=player;
            currentActSeq=1;
        }
        rec.setActSeq(currentActSeq);
        records.add(rec);
        
    }
    
    public History() {
        records=new ArrayList<>();
        
        currentPlayer="<none>";
        currentRound=0;
        currentActSeq=0;
    }
    public void show(){
        for (HistoryRecord rec:records){
            System.out.println(" "+rec);
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for (HistoryRecord rec:records){
            sb.append(" ").append(rec).append("\n");
//            System.out.println(" "+rec);
        }
        return sb.toString();
    }
}

