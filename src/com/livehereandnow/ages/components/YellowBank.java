/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livehereandnow.ages.components;

/**
 *
 * @author max
 */
public class YellowBank extends Points{
    HappyFaces  happy;
   

    public YellowBank() {
        happy =new HappyFaces();
    }

    
   
    @Override
    public String toString() {
        return "黃點:" + this.points + "\n   幸福指數:"+happy.getPoints();
    }
    
}
