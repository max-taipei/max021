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
public class HistoryRecord {
    int round;
    String player;
    int actSeq;
    String cmd;
    String note;

    public HistoryRecord(int round, String player, int actSeq, String cmd, String note) {
        this.round = round;
        this.player = player;
        this.actSeq = actSeq;
        this.cmd = cmd;
        this.note = note;
    }

    public int getActSeq() {
        return actSeq;
    }

    public void setActSeq(int actSeq) {
        this.actSeq = actSeq;
    }

    public HistoryRecord(int round, String player, String cmd, String note) {
        this.round = round;
        this.player = player;
        this.cmd = cmd;
        this.note = note;
        
    }

    @Override
    public String toString() {
        return "HistoryRecord{" + "round#" + round + ", " + player + ", seq:" + actSeq + ", " + cmd + ", note: " + note + '}';
    }

  
    
    
}
