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
 * @author max
 */
public class Card implements CardType {

    private Points bluePoints;
    private Points yellowPoints;

    //for Government Cards
    private Points whitePoints;
    private Points redPoints;
    private int round;

    public int getRound() {
        return round;
    }

    /**
     * Which round player take this card? Except for Wonder card, all cards must
     * be held on hand for at least one round
     *
     * @param round
     */
    public void setRound(int round) {
        this.round = round;
    }

    public void doProduction() {
        //  藍點 = 藍點 + 黃點;
        bluePoints.setPoints(bluePoints.getPoints() + yellowPoints.getPoints());
    }

    public Points getWhite() {
        return whitePoints;
    }

    public Points getRedPoints() {
        return redPoints;
    }

    public Points getBluePoints() {
        return bluePoints;
    }

    public Points getYellowPoints() {
        return yellowPoints;
    }

    public Card(int ID, String 卡名, int 時代, int 牌背, int 類型, int 顏色, String 右上, String 內容, String 建造成本) {

        this.set是否完全解析完畢(false);
        this.右上 = 右上;
        this.內容 = 內容;
        this.顏色 = 顏色;
        this.ID = ID;
        this.牌背 = 牌背;
        this.卡名 = 卡名;
        this.時代 = 時代;
        this.類型 = 類型;
//        this.建造成本 = 建造成本;
        wonderStage = new WonderStage(建造成本);
        whitePoints = new Points();
        redPoints = new Points();
        bluePoints = new Points();
        yellowPoints = new Points();

//        if (右上.equals("政府")) {
        // ver 0.60, not limited to 政府, apply to all
//        if (true) {
        if (true) {
//            boolean isDone = false;
            
            int todoCnt = 0;
            int doneCnt = 0;

            String cmd = 內容;
            String[] strTokens = cmd.split(";");// **it's in Chinese, 2 bytes***
//            System.out.println(strTokens);
            System.out.println("===================================================================");
            System.out.println("\n" + this.ID + " " + this.卡名 + "=>=>" + this.內容);
            for (String item : strTokens) {
                System.out.println(item);
                todoCnt++;
//                 System.out.println("--------------------------------------------------------------");

            }
            System.out.println("----------------------------已解析-----------------------------------");
            for (String item : strTokens) {//按每個句子解析，句子是按分號區隔開來的
                if (item.length() > 0) {
//                    String[] strTokens2 = item.split("[+]");
                    String[] strTokens2 = item.split("[:]");//以冒號隔開，左邊的為key，右邊的val

                    String key = strTokens2[0];//key是字符串
                    int val = -999;//val是整數，使用Integer的解析功能，如果不能解析成整數，系統會報錯
                    try {
                        val = Integer.parseInt(strTokens2[1]);//val是整數，使用Integer的解析功能，如果不能解析成整數，系統會報錯
                    } catch (Exception ex) {

                    }
                    if (key.equals("內政點數")) {
                        System.out.println("內政點數:" + val);
                        this.whitePoints.setPoints(val);
                        doneCnt++;
                    }
                    if (key.equals("軍事點數")) {
                        System.out.println("軍事點數:" + val);
//                        System.out.println("1234567");
                        this.redPoints.setPoints(val);
                        doneCnt++;
                    }
                    if (key.equals("建築上限")) {
                        System.out.println("建築上限:" + val);
                        doneCnt++;
                    }
                    if (key.equals("文化生產")) {
                        System.out.println("文化生產:" + val);
                        doneCnt++;
                    }
                    if (key.equals("科技生產")) {
                        System.out.println("文化生產:" + val);
                        doneCnt++;
                    }
                    if (key.equals("內政手牌上限")) {
                        System.out.println("內政手牌上限:" + val);
                        doneCnt++;
                    }

                    if (key.equals("軍事手牌上限")) {
                        System.out.println("軍事手牌上限:" + val);
                        doneCnt++;
                    }
                    if (key.equals("軍力")) {
                        System.out.println("軍力:" + val);
                        doneCnt++;
                    }
                    if (key.equals("每個玩家免費擴充人口")) {
                        System.out.println("每個玩家免費擴充人口:" + val);
                        doneCnt++;
                    }
                    if (key.equals("資源")) {
                        System.out.println("資源:" + val);
                        doneCnt++;
                    }
                    
                    if (key.equals("食物")) {
                        System.out.println("食物:" + val);
                        doneCnt++;
                    }
                    
                    if (key.equals("科技")) {
                        System.out.println("科技:" + val);
                        doneCnt++;
                    }
                    
                    if (key.equals("文化")) {
                        System.out.println("文化:" + val);
                        doneCnt++;
                    }
                    
                    if (key.equals("科技生產")) {
                        System.out.println("科技生產:" + val);
                        doneCnt++;
                    }
                    
                    if (key.equals("文化生產")) {
                        System.out.println("文化生產:" + val);
                        doneCnt++;
                    }
                    if (key.equals("黃點")) {
                        System.out.println("黃點:" + val);
                        doneCnt++;
                    }
                    if (key.equals("藍點")) {
                        System.out.println("藍點:" + val);
                        doneCnt++;
                    }
                }

            }
            System.out.println("----------------------------解析結果-----------------------------------");
            if (doneCnt == todoCnt) {
//                isDone = true;
                this.是否完全解析完畢=true;
                
            }
            System.out.println("是否全部解析完畢?" + 是否完全解析完畢);

            System.out.println("應該解析個數:" + todoCnt);

            System.out.println("已解析個數" + doneCnt);
        }
//        System.out.println("顯示幾張牌");
    }

    public String get右上() {
        return 右上;
    }

    public void set右上(String 右上) {
        this.右上 = 右上;
    }

    public String get內容() {
        return 內容;
    }
//    public String get解析結果() {
//        return 內容;
//    }

    public void set內容(String 內容) {
        this.內容 = 內容;
    }

    public int get顏色() {
        return 顏色;
    }

    public void set顏色(int 顏色) {
        this.顏色 = 顏色;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int get牌背() {
        return 牌背;
    }

    public void set牌背(int 牌背) {
        this.牌背 = 牌背;
    }

//    public String get建造成本() {
//        return 建造成本;
    public boolean is是否完全解析完畢() {
        return 是否完全解析完畢;
    }

    public void set是否完全解析完畢(boolean 是否完全解析完畢) {
        this.是否完全解析完畢 = 是否完全解析完畢;
    }
//    }
//
//    public void set建造成本(String 建造成本) {
//        this.建造成本 = 建造成本;
//    }
    private String 右上;
    private int 編號;
    private int 加權值;
    private String 內容;
    private boolean 是否完全解析完畢;
    private int 顏色;
    private int ID;
    private int 牌背;
    private int 時代;
    private String 卡名;
//    String 建造成本;
//    int[] 奇蹟建造成本=new int[5];//最多5個階段由階段0開始
//    int 奇蹟建造階段;//初值為0表示正在建造0階段 
    private int 類型;//0=領袖,1=奇蹟.2=黃牌
    private WonderStage wonderStage;
//    public int get奇蹟建造成本(int k) {
//        return 奇蹟建造成本[k];
//    }
//
//    public void set奇蹟建造成本(int k,int 奇蹟建造成本) {
//        this.奇蹟建造成本[k] = 奇蹟建造成本;
//    }
//
//    public int get奇蹟建造階段() {
//        return 奇蹟建造階段;
//    }
//
//    public void set奇蹟建造階段(int 奇蹟建造階段) {
//        this.奇蹟建造階段 = 奇蹟建造階段;
//    }

    public WonderStage getWonderStage() {
        return wonderStage;
    }

    public int get加權值() {
        return 加權值;
    }

    public void set加權值(int 加權值) {
        this.加權值 = 加權值;
    }

    /**
     * Basic info for initial 6 cards for each player
     *
     * @param 卡名
     * @param 時代
     * @param 右上
     */
    public Card(String 卡名, int 時代, String 右上) {
        this.卡名 = 卡名;
        this.時代 = 時代;
        this.右上 = 右上;
        yellowPoints = new Points();
        bluePoints = new Points();
        whitePoints = new Points();
        redPoints = new Points();

    }

    public Card(int 編號, String 卡名, int 時代, int 類型) {
        this.編號 = 編號;
        this.卡名 = 卡名;
        this.時代 = 時代;
        this.類型 = 類型;
    }

//    public Card(int 編號, String 卡名, int 時代, int 類型, int 加權值) {
//        this.編號 = 編號;
//        this.卡名 = 卡名;
//        this.時代 = 時代;
//        this.類型 = 類型;
//        this.加權值 = 加權值;
//    }
    public Card() {
    }

    public int get編號() {
        return 編號;
    }

    public void set編號(int 編號) {
        this.編號 = 編號;
    }

    public String get卡名() {
        return 卡名;
    }

    public void set卡名(String 卡名) {
        this.卡名 = 卡名;
    }

    public int get時代() {
        return 時代;
    }

    public void set時代(int 時代) {
        this.時代 = 時代;
    }

    public int get類型() {
        return 類型;
    }

    // ver 0.7, by Mark, 2014-4-16
    public String get類型Name() {
        return CardType.CARD_TYPE_NAME[類型];
    }

    // ver 0.7, by Mark, 2014-4-16
    public String get卡名and類型Name() {
        return "[" + 卡名 + "-" + CardType.CARD_TYPE_NAME[類型] + "] ";
    }
//    待理解，時代為什麼可以這麼明確　2014-4-19 MAX

    public String get時代名() {
        String[] 時代名 = {"時代A", "時代I", "時代II", "時代III"};
        return 時代名[時代];
    }

    public String getSimple時代名() {
        String[] 時代名 = {"A", "I", "II", "III"};
        return 時代名[時代];
    }

    public String get牌背名() {
        String[] 牌背名 = {"內政", "軍事"};
        return 牌背名[牌背];
    }

    public void set類型(int 類型) {
        this.類型 = 類型;
    }

    //String 卡名;
    @Override
    public String toString() {
        return "[" + 卡名 + "]";
    }

    public String getWhiteRedString() {
        StringBuilder sb = new StringBuilder();
        //   sb.append(" ");
        if (whitePoints.getPoints() > 0) {
            sb.append(whitePoints).append("W");
        }
        if (redPoints.getPoints() > 0) {
            sb.append(whitePoints).append("R");
        }
        if (sb.toString().length() > 0) {
            sb.insert(0, " *");
            sb.append("*");
        }
        return sb.toString();
    }

    /**
     * FOR-MAX
     *
     * @param k
     * <br>5=>[I-灌溉-科技-農場-建造成本:3/3]
     * <br>6=>[A-Philosophy--實驗室 黃點:0 藍點:0]
     * <br>9 for Leader card,
     * @return
     */
    public String toString(int k) {
        switch (k) {
            case 0://
                //  Value 1: 0[時代A內政-荷馬-領袖] 1[] 2[時代A內政-凱薩-領袖] 3[時代A內政-空中花園-奇蹟] 4[時代A內政-農業-科技] 
                if (卡名.equalsIgnoreCase("")) {

                    return "[] ";
                }
                return "[" + get卡名() + "]";

            case 1://
                //  Value 1: 0[時代A內政-荷馬-領袖] 1[] 2[時代A內政-凱薩-領袖] 3[時代A內政-空中花園-奇蹟] 4[時代A內政-農業-科技] 
                if (卡名.equalsIgnoreCase("")) {

                    return "[] ";
                }
                return "[" + get時代名() + get牌背名() + "-" + get卡名() + "-" + get右上() + "] ";

            case 11://
                //  Value 1: 0[時代A內政-荷馬-領袖] 1[] 2[時代A內政-凱薩-領袖] 3[時代A內政-空中花園-奇蹟] 4[時代A內政-農業-科技] 
                if (卡名.equalsIgnoreCase("")) {

                    return "[] ";
                }
                return "[" + getSimple時代名() + "-" + get卡名() + "-" + get右上() + "] ";

            case 2://[A內政-荷馬-領袖]
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + getSimple時代名() + get牌背名() + "-" + get卡名() + "-" + get類型Name() + "] ";
            case 3://奇蹟  [I內政-泰姬陵-奇蹟-建造成本:2,4,2]
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + getSimple時代名() + get牌背名() + "-" + get卡名() + "-" + get類型Name() + "-建造成本:" + wonderStage + "] ";
            //"-"+this.奇蹟待建區.get().建造成本
            case 4://奇蹟  [I內政-泰姬陵-奇蹟-建造成本:*,4,2] *表示該段建造完成
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + getSimple時代名() + get牌背名() + "-" + get卡名() + "-" + get類型Name() + "-建造成本:" + wonderStage + "] ";
            case 5://  [I-灌溉-科技-農場-建造成本:3/3]，因為要確認右上的字
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + getSimple時代名() + "-" + get卡名() + "-" + get類型Name() + "-" + get右上() + "-建造成本:" + wonderStage + "] ";
            case 15:// including Round# [I-灌溉-科技-農場-建造成本:3/3]，因為要確認右上的字
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[round#" + getRound() + "-" + getSimple時代名() + "-" + get卡名() + "-" + get類型Name() + "-" + get右上() + "-建造成本:" + wonderStage + "] ";

            case 6://  0[A-Philosophy--實驗室  黃點:0 藍點:0]
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + getSimple時代名() + "-" + get卡名() + "-" + "-" + get右上() + "  黃點:" + yellowPoints + " 藍點:" + bluePoints + "] ";
            case 7:// for Government card, 
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + getSimple時代名() + "-" + get卡名() + "-" + "-" + get右上() + "  白點:" + whitePoints + " 紅點:" + redPoints + "] ";

            case 8://for govt card
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + getSimple時代名() + get牌背名() + "-" + get卡名() + " " + get內容() + " 建造成本:" + wonderStage + "] ";

            case 9://for leader
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + getSimple時代名() + get牌背名() + "-" + get卡名() + " " + get內容() + "] ";
            case 10://to show    內政點數 and  軍事點數 
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + getSimple時代名() + get牌背名() + "-" + get卡名() + " " + get內容() + getWhiteRedString() + "] ";

            default:
                return toString();
        }
    }

//        System.out.print(k + "[" + cardRow.get(k).get時代名()+cardRow.get(k).get牌背名() + "-" + cardRow.get(k).get卡名() + "-" + cardRow.get(k).get類型Name() + "] ");
}
