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
public class ScoreBoard {

    private Points 文化;
    private Points 文化生產;
    private Points 科技;
    private Points 科技生產;
    private Points 軍力;

    public Points get文化() {
        return 文化;
    }

    public Points get文化生產() {
        return 文化生產;
    }

    public Points get科技() {
        return 科技;
    }

    public Points get科技生產() {
        return 科技生產;
    }

    public Points get軍力() {
        return 軍力;
    }

    public ScoreBoard() {
        文化 = new Points();
        文化生產 = new Points();
        科技 = new Points();
        科技生產 = new Points();
        軍力 = new Points();
    }

    @Override
    public String toString() {
        return "   文化:" + 文化 + "\n   文化生產(當回合):" + 文化生產 + "\n   科技:" + 科技 + "\n   科技生產(當回合):" + 科技生產 + "\n   軍力:" + 軍力  ;
    }

}
