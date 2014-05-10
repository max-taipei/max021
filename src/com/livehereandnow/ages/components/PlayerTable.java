/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.components;

import static com.livehereandnow.ages.components.CardType.事件;
import static com.livehereandnow.ages.components.CardType.內政;
import static com.livehereandnow.ages.components.CardType.戰術;
import static com.livehereandnow.ages.components.CardType.棕色;
import static com.livehereandnow.ages.components.CardType.橙色;
import static com.livehereandnow.ages.components.CardType.深紅色;
import static com.livehereandnow.ages.components.CardType.淺綠色;
import static com.livehereandnow.ages.components.CardType.灰色;
import static com.livehereandnow.ages.components.CardType.科技;
import static com.livehereandnow.ages.components.CardType.紅色;
import static com.livehereandnow.ages.components.CardType.藍色;
import static com.livehereandnow.ages.components.CardType.軍事;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mark
 */
public class PlayerTable extends Object {
//    private Card

    private LeaderDeck leader;
    private List<Card> 奇蹟待建區;
    private List<Card> 戰術執行區;

    public List<Card> get戰術執行區() {
        return 戰術執行區;
    }

    public void set戰術執行區(List<Card> x) {
        this.戰術執行區 = x;
    }
    private List<Card> 特殊科技區;
    private List<Card> 奇蹟完成區;

    public List<Card> get特殊科技區() {
        return 特殊科技區;
    }

    public void set特殊科技區(List<Card> 特殊科技區) {
        this.特殊科技區 = 特殊科技區;
    }
    private List<Card> 殖民領土;

    public List<Card> get殖民領土() {
        return 殖民領土;
    }

    public void set殖民領土(List<Card> 殖民領土) {
        this.殖民領土 = 殖民領土;
    }

    public List<Card> get奇蹟待建區() {
        return 奇蹟待建區;
    }

    public void set奇蹟待建區(List<Card> 奇蹟待建區) {
        this.奇蹟待建區 = 奇蹟待建區;
    }

    public List<Card> get奇蹟完成區() {
        return 奇蹟完成區;
    }

    public void set奇蹟完成區(List<Card> 奇蹟完成區) {
        this.奇蹟完成區 = 奇蹟完成區;
    }

//    public Card getLeaderDeck() {
//        return leader;
//    }
    private Card cards政府;

    public int getBuildingLimit() {
        //君主制,神權政治

        if (cards政府.get卡名().equals("君主制")) {
            return 3;
        }
        if (cards政府.get卡名().equals("神權政治")) {
            return 3;
        }

        return 2;
    }

    public List<Card> get5x4() {
        List<Card> list = new ArrayList<>();

        return list;
    }

    public List<Card> get當前板塊() {
        List<Card> list = new ArrayList<>();
        list.add(cards政府);
        if (leader.isLeaderInPlay()) {
            list.add(getLeader());
        }
        list.addAll(奇蹟完成區);
        list.addAll(other桌上的牌);
        return list;
    }

    public Card getCard政府() {
        return cards政府;
    }

    public int getOnHandLimit() {
        int k = 0;
        int white = 0;
        for (Card card : get當前板塊()) {
            white = card.getWhite().getPoints();
            if (white > 0) {
                k += white;
//                System.out.println("  ..." + card.toString(10));
            }
        }
        return k;
    }

    public void setCard政府(Card cards政府) {
        this.cards政府 = cards政府;
    }
    private Card[] cards實驗室;
    private Card[] cards神廟;
    private Card[] cards農場;
    private Card[] cards礦山;
    private Card[] cards步兵;
    private Card[][] cards;
    private List<Card> other桌上的牌;

    public List<Card> getOther桌上的牌() {
        return other桌上的牌;
    }

    public void showCardsOnTable___OTHERS() {
        System.out.println("Other Cards: ");
        for (int k = 0; k < other桌上的牌.size(); k++) {
            System.out.println("     " + k + other桌上的牌.get(k).toString(5));
        }
        System.out.println();
    }

    public Card getCard(int type, int age) {
        return cards[type][age];
    }

    /**
     *
     * @param card Card的物件
     * @param type
     * <br>1=>實驗室
     * <br>2=>神廟
     * <br>3=>農場
     * <br>4=>礦山
     * <br>5=>步兵
     *
     * @param age
     * <br>0=>A
     * <br>1=>I
     * <br>2=>II
     * <br>3=>III
     */
    public void setCard(Card card, int type, int age) {
        this.cards[type][age] = card;
    }

    public void addCardToOther(Card card) {
        other桌上的牌.add(card);
    }

//    public void setLeader(Card card) {
//        leader = card;
//    }
    /**
     *
     * @param type
     * <br>1=>實驗室
     * <br>2=>神廟
     * <br>3=>農場
     * <br>4=>礦山
     * <br>5=>步兵
     *
     * @param age
     * <br>0=>A
     * <br>1=>I
     * <br>2=>II
     * <br>3=>III
     *
     *
     * @param point
     */
    public void add黃點(int type, int age, int point) {
        cards[type][age].getYellowPoints().addPoints(point);
    }
//      public void upgrade黃點(int type, int ageFrom, int ageTo){筆記

    public void upgrade黃點(int type, int ageFrom, int ageTo) {
        add黃點(type, ageFrom, -1);
        add黃點(type, ageTo, 1);
    }

    public void show建造中的奇蹟() {
//        for (int k = 0; k < 桌上的牌.size(); k++) {
//            System.out.print(" " + 桌上的牌.get(k).toString(1));
        System.out.print("建造中的奇蹟 ");
        for (int k = 0; k < get奇蹟待建區().size(); k++) {
            System.out.print(" " + get奇蹟待建區().get(k).toString(3));

        }
        System.out.println("");

    }

    public void show已完成的奇蹟() {
//        for (int k = 0; k < 桌上的牌.size(); k++) {
//            System.out.print(" " + 桌上的牌.get(k).toString(1));
        System.out.print("已完成的奇蹟 ");

        for (int k = 0; k < get奇蹟完成區().size(); k++) {
            System.out.print(" " + get奇蹟完成區().get(k).toString(2));

        }
        System.out.println("");
        //   System.out.println();
    }

    public void show殖民領土() {
//        for (int k = 0; k < 桌上的牌.size(); k++) {
//            System.out.print(" " + 桌上的牌.get(k).toString(1));
        System.out.print("殖民領土區 ");

        for (int k = 0; k < get殖民領土().size(); k++) {
            System.out.print(" " + get殖民領土().get(k).toString(2));

        }
        System.out.println("");
        //   System.out.println();
    }
        public void show戰術() {
//        for (int k = 0; k < 桌上的牌.size(); k++) {
//            System.out.print(" " + 桌上的牌.get(k).toString(1));
        System.out.print("戰術 ");
        for (int k = 0; k < get戰術執行區().size(); k++) {
            System.out.print(" " + get戰術執行區().get(k).toString(3));

        }
        System.out.println("");

    }
              public void show特殊科技區() {
//        for (int k = 0; k < 桌上的牌.size(); k++) {
//            System.out.print(" " + 桌上的牌.get(k).toString(1));
        System.out.print("特殊科技區 ");
        for (int k = 0; k < get特殊科技區().size(); k++) {
            System.out.print(" " + get特殊科技區().get(k).toString(3));

        }
        System.out.println("");

    }

    public LeaderDeck getLeaderDeck() {
        return leader;
    }

    public Card getLeader() {
        return leader.getCard();
    }

    public PlayerTable() {
        殖民領土 = new ArrayList<Card>();
        奇蹟待建區 = new ArrayList<Card>();
        戰術執行區 = new ArrayList<Card>();
        奇蹟完成區 = new ArrayList<Card>();
        特殊科技區 = new ArrayList<Card>();
        殖民領土.add(new Card(82, "歷史悠久之地", 1, 軍事, 事件, 淺綠色, "領土", "笑臉+1，文化+6", "0"));
        戰術執行區.add(new Card(100, "中世紀軍隊", 1, 軍事, 戰術, 深紅色, "戰術", "步馬+2", "0"));
        特殊科技區.add(new Card(45, "製圖術", 1, 內政, 科技, 藍色, "殖民", "軍力+1，殖民點數+2", "4"));
        leader = new LeaderDeck();
        Card NOCARD = new Card(999, "", -1, CardType.EMPTY);
//        leader = NOCARD;
//        leader.setCard(NOCARD);
        cards = new Card[6][];
        other桌上的牌 = new ArrayList<>();
        //---------------------
//        cards政府 = new Card[4];
        cards實驗室 = new Card[4];
        cards神廟 = new Card[4];
        cards農場 = new Card[4];
        cards礦山 = new Card[4];
        cards步兵 = new Card[4];
//        cards[0] = cards政府;
        cards[1] = cards實驗室;
        cards[2] = cards神廟;
        cards[3] = cards農場;
        cards[4] = cards礦山;
        cards[5] = cards步兵;

//        cards政府[0] = new Card(10, "專制", 0, 內政, 科技, 橙色, "政府", "內政點數+4，軍事點數+2", "0");
        cards政府 = new Card(10, "專制", 0, 內政, 科技, 橙色, "政府", "內政點數+4，軍事點數+2", "0");

        cards實驗室[0] = new Card(13, "哲學", 0, 內政, 科技, 灰色, "實驗室", "科技生產+1", "3");
        cards神廟[0] = new Card(11, "宗教", 0, 內政, 科技, 灰色, "神廟", "笑臉+1，文化生產+1", "3");
        cards農場[0] = new Card(12, "農業", 0, 內政, 科技, 棕色, "農場", "食物生產+1", "2");
        cards礦山[0] = new Card(15, "青銅", 0, 內政, 科技, 棕色, "礦山", "資源生產+1", "2");
        cards步兵[0] = new Card(14, "戰士", 0, 內政, 科技, 紅色, "步兵", "軍力+1", "2");

    }

    private void showAgesX5() {

        showAgesX5("  1.實驗室", cards實驗室);
        showAgesX5("  2.神廟", cards神廟);
        showAgesX5("  3.農場", cards農場);
        showAgesX5("  4.礦山", cards礦山);
        showAgesX5("  5.步兵", cards步兵);

    }

    private void show領袖() {
        System.out.println("    領袖 " + leader.toString());

    }

//    private void showAges政府(String title, Card[] ages) {
//        System.out.print("  " + title);
//        for (int k = 0; k < 4; k++) {
//            try {
//                System.out.print(" " + ages[k].toString(7));
//            } catch (Exception e) {
//            }
//        }
//        System.out.print(" ONLY TO SEE LATEST ONE!!!");
//        System.out.println("  ");
//
//    }
    private void show政府() {
        System.out.print("    政府 " + cards政府.toString(7) + " Building Number limit: " + getBuildingLimit());

    }

    private void showAgesX5(String title, Card[] ages) {
        System.out.print("  " + title);
        for (int k = 0; k < 4; k++) {
            try {
                System.out.print(" " + ages[k].toString(6));
            } catch (Exception e) {
            }
        }
        System.out.println("  ");

    }

    public void show(String title) {
        System.out.println(title);
        show();
    }

    public void show() {
        show領袖();
        show政府();
        System.out.println("");
        showAgesX5();

        showCardsOnTable___OTHERS();
        show建造中的奇蹟();
        show已完成的奇蹟();
        show殖民領土();
        show戰術();
        show特殊科技區();
    }
}
