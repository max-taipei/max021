/*
 === 需求 ===
 想要降低 在GameEngine裡面程式碼的
 玩家[當前玩家].get農業(0).set藍點(玩家[當前玩家].get農業(0).get藍點()+玩家[當前玩家].get農業(0).get黃點());


 */
package com.livehereandnow.ages.components;

import static com.livehereandnow.ages.components.CardType.事件;
import static com.livehereandnow.ages.components.CardType.內政;
import static com.livehereandnow.ages.components.CardType.棕色;
import static com.livehereandnow.ages.components.CardType.深綠色;
import static com.livehereandnow.ages.components.CardType.灰色;
import static com.livehereandnow.ages.components.CardType.科技;
import static com.livehereandnow.ages.components.CardType.紅色;
import static com.livehereandnow.ages.components.CardType.軍事;
import com.livehereandnow.ages.exception.AgesException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max
 */
public class Player {

    private Cards cards;
    private Counter civilCounter;
    private Counter militaryCounter;
    private Counter 建築上限;
    private Counter 內政手牌上限;
private Counter 殖民點數;

    public Counter get殖民點數() {
        return 殖民點數;
    }

    public void set殖民點數(Counter 殖民點數) {
        this.殖民點數 = 殖民點數;
    }

    public Counter get建築上限() {
        return 建築上限;
    }

    public void set建築上限(Counter 建築上限) {
        this.建築上限 = 建築上限;
    }

    public Counter get內政手牌上限() {
        return 內政手牌上限;
    }

    public void set內政手牌上限(Counter 內政手牌上限) {
        this.內政手牌上限 = 內政手牌上限;
    }

    public Counter get軍事手牌上限() {
        return 軍事手牌上限;
    }

    public void set軍事手牌上限(Counter 軍事手牌上限) {
        this.軍事手牌上限 = 軍事手牌上限;
    }
    private Counter 軍事手牌上限;
    private ScoreBoard scoreBoard;
    private Points workPool;
    private PlayerTable table;

//    private Card[] ages實驗室;
//    private Card[] ages神廟;
//    private Card[] ages農場;
//    private Card[] ages礦山;
//    private Card[] ages步兵;
    public Counter getCivilCounter() {
        return civilCounter;
    }

    public Counter getMilitaryCounter() {
        return militaryCounter;
    }

    private String name;

    private String 失敗原因;

    public String getName() {
        return name;
    }

    public String get失敗原因() {
        return 失敗原因;
    }

    public void set失敗原因(String 失敗原因) {
        this.失敗原因 = 失敗原因;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean doFarm() throws AgesException {
        // draft by Mark, 
        // 2014-4-25 17:11
        System.out.println("   === draft by Mark (start)");

//        this.init牌.get(2).getYellowPoints().addPoints(1);
        this.人力庫.addPoints(-1);
        System.out.println("   === draft by Mark (end)");
        //

        //
        System.out.println("玩家的DOFarm");
        System.out.println("工人區" + 人力庫.getPoints());
        this.人力庫.addPoints(-1);
        System.out.println("工人區" + 人力庫.getPoints());
//        System.out.println("農場0黃" + this.農場[0].get黃點());
//        this.農場[0].set黃點(this.農場[0].get黃點() + 1);
//        System.out.println("農場0黃" + this.農場[0].get黃點());
        return true;
    }

    public boolean isAnyGovernmentCardOnHand() {
        for (Card card : 手上的內政牌) {
            if (card.get右上().equals("政府")) {
                return true;
            }
        }
        return false;
    }

    public int getIndexOfGovernmentCardOnHand() {
        int k = -1;
        for (Card card : 手上的內政牌) {
            k++;
            if (card.get右上().equals("政府")) {
                return k;
            }
        }
        return k;
    }

    public boolean doGovernment() throws AgesException {
        System.out.println("99996647221245()");
        System.out.println("DOING... Player.doRevolution()");
        System.out.println("1. Do I have Govt card on hand?");
        if (isAnyGovernmentCardOnHand()) {
            System.out.println("   Yes, I have.");
            System.out.println("2. What is the card number on hand?");
            int cardIndex = getIndexOfGovernmentCardOnHand();
            System.out.println("The index is " + cardIndex);
            Card newGovt = 手上的內政牌.get(cardIndex);
            System.out.println("3. Now, to replace the Govt with " + newGovt);
//            this.government = newGovt;
            table.setCard政府(newGovt);
            System.out.println("*** NOT TO ALLOW MORE THAN ONE GOVT CARD ON HAND ??? *** ");

            return true;
        } else {
            System.out.println("   No, I don't.");
            return false;
        }
    }

    public boolean doIncreasePolutaion() throws AgesException {
        System.out.println(" ... only to perform: transfer yellow token from YellowBank to WorkPool");
        this.人力庫.addPoints(-1);
        this.workPool.addPoints(+1);
        return true;
    }

    public boolean doRevolution() throws AgesException {
        System.out.println("99996647221245()");
        System.out.println("DOING... Player.doRevolution()");
        System.out.println("1. Do I have Govt card on hand?");
        if (isAnyGovernmentCardOnHand()) {
            System.out.println("   Yes, I have.");
            System.out.println("2. What is the card number on hand?");
            int cardIndex = getIndexOfGovernmentCardOnHand();
            System.out.println("The index is " + cardIndex);
            Card newGovt = 手上的內政牌.get(cardIndex);
            System.out.println("3. Now, to replace the Govt with " + newGovt);
            //ver 0.49
            //this.government = newGovt;           
            table.setCard(newGovt, 0, newGovt.get時代());

//            System.out.println("*** NOT TO ALLOW MORE THAN ONE GOVT CARD ON HAND ??? *** ");
            return true;
        } else {
            System.out.println("   No, I don't.");
            return false;
        }
    }

    public boolean doStartRound() throws AgesException {//ver 0.41
//        System.out.println("玩家的回合開始，補充內政和軍事點數---從政府牌補充");
//        System.out.println("玩家的回合開始，補充內政和軍事點數---除了政府牌以外，A領袖 漢模拉比 ，A奇蹟 金字塔 ，II特殊科技-內政，II特殊科技-內政，III特殊科技-內政");

        getCivilCounter().setPoint(table.getCard政府().getWhite().getPoints());
        getMilitaryCounter().setPoint(table.getCard政府().getRedPoints().getPoints());

        return true;
    }

    public boolean doChangeGovernment() throws AgesException {
        System.out.println("DOING... Player.doChangeGovernment()和平轉移政權");
        System.out.println("99996647221245()");
        System.out.println("DOING... Player.doRevolution()");
        System.out.println("1. Do I have Govt card on hand?我有沒有政府牌在手上");
        if (isAnyGovernmentCardOnHand()) {
            System.out.println("   Yes, I have.");
            System.out.println("2. What is the card number on hand?");
            int cardIndex = getIndexOfGovernmentCardOnHand();
            System.out.println("The index is " + cardIndex);
            Card newGovt = 手上的內政牌.get(cardIndex);
            System.out.println("3. Now, to replace the Govt with " + newGovt);

            //ver 0.49
            //this.government = newGovt;           
            table.setCard(newGovt, 0, newGovt.get時代());

            //System.out.println("*** NOT TO ALLOW MORE THAN ONE GOVT CARD ON HAND ??? *** ");
            return true;
        } else {
            System.out.println("   No, I don't.");
            return false;
        }
//        return true;
    }

    public boolean doConstructWonder() throws AgesException {
        if (table.get奇蹟待建區().size() == 0) {
            System.out.println("你沒有奇蹟");
            return false;

        }

        boolean result = table.get奇蹟待建區().get(0).getWonderStage().addStageDoneCnt();
        if (result) {
            System.out.println("第" + table.get奇蹟待建區().get(0).getWonderStage().getStageDoneCnt() + "階段建造成功");
            if (table.get奇蹟待建區().get(0).getWonderStage().getStageDoneCnt() == table.get奇蹟待建區().get(0).getWonderStage().stageMaxCnt) {
                table.get奇蹟完成區().add(table.get奇蹟待建區().get(0));
                table.get奇蹟待建區().remove(0);
                System.out.println("奇蹟待建區=" + table.get奇蹟待建區().size());
            }
        } else {
            System.out.println("程式出錯了");
        }

        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    YellowBank 人力庫;
    BlueBank blueBank;

    public BlueBank getBlueBank() {
        return blueBank;
    }

    public YellowBank get人力庫() {
        return 人力庫;
    }

    public List<Card> get手上的內政牌() {
        return 手上的內政牌;
    }

    public void set手上的內政牌(List<Card> x) {
        this.手上的內政牌 = x;
    }

    public List<Card> get手上的軍事牌() {
        return 手上的軍事牌;
    }

    public void set手上的軍事牌(List<Card> 手上的軍事牌) {
        this.手上的軍事牌 = 手上的軍事牌;
    }

    private List<Card> 手上的內政牌;
    private List<Card> 手上的軍事牌;

    /**
     * 當想要拿科技牌時，檢查手上和桌上是不是有同卡名的牌 有的話，回是 .true 沒有的話，回不是 .false
     *
     * 特例 當對方打出科技戰爭時會導致，藍色科技被拿走，可能無法使用上面的判斷
     *
     * @param card
     * @return
     */
    public boolean is已拿過該科技牌(Card card) {//是不是拿過這張科技牌
//     * 當想要拿科技牌時，檢查手上和桌上是不是有同卡名的
//        想要拿的科技牌:card
//        手上的內政牌
//        桌上的牌
//        System.out.println("想要拿取 " + card.toString(1));

        for (int k = 0; k < this.get手上的內政牌().size(); k++) {
//            System.out.println("這是目前手上的牌 " + k + " " + this.get手上的內政牌().get(k).toString(1));
            if (card.get卡名() == this.get手上的內政牌().get(k).get卡名()) {
                return true;
            }

        }
//        for (int k = 0; k < this.get桌上的牌().size(); k++) {
//            System.out.println("這是目前桌上的牌 " + k + " " + this.get桌上的牌().get(k).toString(1));
//            if (card.get卡名() == this.get桌上的牌().get(k).get卡名()) {
//                return true;
//            }
//
//        }

//        this.get
        return false;//DEBUG,假設沒拿過該張科技牌
    }

//    public boolean isSameAgeLeaderOnHand已拿取時代領袖(Card card) {//是不是拿過這張科技牌
//        if (card.get右上().equals("領袖")) {
//            for (int k = 0; k < this.get手上的內政牌().size(); k++) {
//                System.out.println(" isSameAgeLeaderOnHande已拿取時代領袖...這是目前手上的牌 " + k + " " + this.get手上的內政牌().get(k).toString(1));
//                if (card.get時代() == this.get手上的內政牌().get(k).get時代()) {
//                    return true;
//                }
//            }
//        }
//        System.out.println(" ... on hande, checked, clean");
//        return false;
//    }
//
//    public boolean isSameAgeLeaderOnTable(Card card) {
//        if (card.get右上().equals("領袖")) {
//
//            if (table.getLeaderDeck().get時代() == card.get時代()) {
//                System.out.println(" on table, current leader is" + table.getLeaderDeck().toString(9));
//
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean is有沒有奇蹟待建(Card card) {//是不是拿過這張科技牌
//     * 當想要拿科技牌時，檢查手上和桌上是不是有同卡名的
//        想要拿的科技牌:card
//        手上的內政牌
//        桌上的牌
//        System.out.println("想要拿取 " + card.toString(1));

        if (table.get奇蹟待建區().size() != 0) {
            System.out.println("尚有待建的奇蹟 ");
            return true;
        }
        return false;//DEBUG,假設沒拿過該時代領袖牌
    }

//    public void set已拿取時代領袖(int k) {//標示已拿過該時代的領袖牌
//        this.已拿取時代領袖[k] = true;
//    }
    public PlayerTable getTable() {
        return table;
    }

    //起始設定
    public Player() {
//        實例
        殖民點數 =new Counter();
        
        內政手牌上限 =new Counter();
        軍事手牌上限 =new Counter();
        建築上限 =new Counter();
        workPool = new Points();
        scoreBoard = new ScoreBoard();
        blueBank = new BlueBank();
        table = new PlayerTable();
        civilCounter = new Counter();
        militaryCounter = new Counter();
        手上的內政牌 = new ArrayList<Card>();
        手上的軍事牌 =new ArrayList<Card>();
        手上的軍事牌.add(new Card(29, "市場的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家資源+2", "0"));
        
        人力庫 = new YellowBank();
//      設定初值
        scoreBoard.get科技生產().setPoints(1);
        scoreBoard.get軍力().setPoints(1);
        table.add黃點(1, 0, 1);
        table.add黃點(2, 0, 0);
        table.add黃點(3, 0, 2);
        table.add黃點(4, 0, 2);
        table.add黃點(5, 0, 1);
        workPool.setPoints(1);
        blueBank.setPoints(18);
        人力庫.setPoints(18);
    }

    public void 執行生產() {
//        System.out.println("   ...執行生產");
        for (int k = 0; k < 4; k++) {
            //
//            get農場(k).set藍點(get農場(k).get藍點() + get農場(k).get黃點());
//            get礦山(k).set藍點(get礦山(k).get藍點() + get礦山(k).get黃點());
//            get農場(k).doProduction();
//            get礦山(k).doProduction();
            try {
                table.getCard(3, k).doProduction();
                table.getCard(4, k).doProduction();
            } catch (Exception ex) {
//                System.out.println("   no cards on age " + k);
            }
        }
    }

    public boolean doPlayCardWithRoundNumber(int cardNum, int roundNum) throws AgesException {
        //
        // 
        //
        if ((cardNum + 1) > this.get手上的內政牌().size()) {
            System.out.println("... index of cards-on-hand should be from 0 to " + (this.get手上的內政牌().size() - 1));

            return false;
        }

        //
        //
        //
        Card card = this.get手上的內政牌().get(cardNum);
        //
        // card must stay on hand for at least one round
        //

//        ver 0.65    1. ###BUG### 我拿了一張農場牌，但是不能當回合打出，[時代I內政-灌溉-農場]...you cannot play this card this round 
//          把此區塊暫時抑制
//        if (card.getRound() == roundNum) {//當這張牌是這回合拿的牌
//            System.out.println("... you cannot play this card this round ");
//
//            return false;
//        }
        //this.get桌上的牌().add(this.get手上的內政牌().get(cardNum));
//        System.out.print(" ...這張牌, 類型=" + this.get手上的內政牌().get(cardNum).get類型());
        //        當打出科技牌的時候
//        灌溉為例
//        System.out.println(" 右上=" + this.get手上的內政牌().get(cardNum).get右上());
//        if (this.get手上的內政牌().get(cardNum).get類型() == CardType.科技) {
        if (card.get類型() == CardType.領袖) {
//          
//            table.get
            table.getLeaderDeck().setCard(card);
//            table.getLeaderDeck().
        } else if (card.get類型() == CardType.科技) {
//            System.out.println("123");
            switch (this.get手上的內政牌().get(cardNum).get右上()) {
                case "政府":
                    table.setCard政府(card);

//                    ages農場[card.get時代()] = card;
                    break;

//                case "農場": {
//                    System.out.println("準備設定已打出");
//                    this.農場[this.get手上的內政牌().get(cardNum).get時代()].set打出(true);
//                    System.out.println("打出了嗎?" + this.農場[this.get手上的內政牌().get(cardNum).get時代()].is打出());
//                }
                // ver 0.44 農場 [A-農業--農場  黃點:0 藍點:0] 
                case "實驗室":
                    table.setCard(card, 1, card.get時代());

//                    /ages實驗室[card.get時代()] = card;
                    break;
                case "神廟":
//                    ages神廟[card.get時代()] = card;
                    table.setCard(card, 2, card.get時代());
                    break;
                case "農場":
                    table.setCard(card, 3, card.get時代());

//                    ages農場[card.get時代()] = card;
                    break;
                case "礦山":
                    table.setCard(card, 4, card.get時代());

//                    ages農場[card.get時代()] = card;
                    break;
                case "步兵":
                    table.setCard(card, 5, card.get時代());

//                    ages農場[card.get時代()] = card;
                    break;

                default:
                    table.getOther桌上的牌().add(card);
//                    System.out.println("  ...to Other桌上的牌() for a while");
            }

        } else {
            //
            // eventually we will find proper location for different types of cards
            //
//            this.get桌上的牌().add(this.get手上的內政牌().get(cardNum));
            // ver 0.48
            System.out.println("... DO AS WE CAN DO TO PUT IT TO PROPER GROUP!!!");
            table.addCardToOther(card);

        }

        this.get手上的內政牌().remove(cardNum);

        return true;
    }

    public boolean doPlayCard革命(int cardNum, int roundNum) throws AgesException {
        //
        // 
        //
        if ((cardNum + 1) > this.get手上的內政牌().size()) {
            System.out.println("... index of cards-on-hand should be from 0 to " + (this.get手上的內政牌().size() - 1));

            return false;
        }

        //
        //
        //
        Card card = this.get手上的內政牌().get(cardNum);
        //
        // card must stay on hand for at least one round
        //

//        ver 0.65    1. ###BUG### 我拿了一張農場牌，但是不能當回合打出，[時代I內政-灌溉-農場]...you cannot play this card this round 
//          把此區塊暫時抑制
//        if (card.getRound() == roundNum) {//當這張牌是這回合拿的牌
//            System.out.println("... you cannot play this card this round ");
//
//            return false;
//        }
        //this.get桌上的牌().add(this.get手上的內政牌().get(cardNum));
//        System.out.print(" ...這張牌, 類型=" + this.get手上的內政牌().get(cardNum).get類型());
        //        當打出科技牌的時候
//        灌溉為例
//        System.out.println(" 右上=" + this.get手上的內政牌().get(cardNum).get右上());
//        if (this.get手上的內政牌().get(cardNum).get類型() == CardType.科技) {
        if (card.get類型() == CardType.領袖) {
//          
//            table.get
            table.getLeaderDeck().setCard(card);
//            table.getLeaderDeck().
        } else if (card.get類型() == CardType.科技) {
//            System.out.println("123");
            switch (this.get手上的內政牌().get(cardNum).get右上()) {
                case "政府":
                    table.setCard政府(card);

//                    ages農場[card.get時代()] = card;
                    break;

//                case "農場": {
//                    System.out.println("準備設定已打出");
//                    this.農場[this.get手上的內政牌().get(cardNum).get時代()].set打出(true);
//                    System.out.println("打出了嗎?" + this.農場[this.get手上的內政牌().get(cardNum).get時代()].is打出());
//                }
                // ver 0.44 農場 [A-農業--農場  黃點:0 藍點:0] 
                case "實驗室":
                    table.setCard(card, 1, card.get時代());

//                    /ages實驗室[card.get時代()] = card;
                    break;
                case "神廟":
//                    ages神廟[card.get時代()] = card;
                    table.setCard(card, 2, card.get時代());
                    break;
                case "農場":
                    table.setCard(card, 3, card.get時代());

//                    ages農場[card.get時代()] = card;
                    break;
                case "礦山":
                    table.setCard(card, 4, card.get時代());

//                    ages農場[card.get時代()] = card;
                    break;
                case "步兵":
                    table.setCard(card, 5, card.get時代());

//                    ages農場[card.get時代()] = card;
                    break;

                default:
                    table.getOther桌上的牌().add(card);
//                    System.out.println("  ...to Other桌上的牌() for a while");
            }

        } else {
            //
            // eventually we will find proper location for different types of cards
            //
//            this.get桌上的牌().add(this.get手上的內政牌().get(cardNum));
            // ver 0.48
            System.out.println("... DO AS WE CAN DO TO PUT IT TO PROPER GROUP!!!");
            table.addCardToOther(card);

        }

        this.get手上的內政牌().remove(cardNum);

        return true;
    }

    public boolean doBuild(int category, int age) throws AgesException {
        table.getCard(category, age).getYellowPoints().addPoints(1);
        workPool.addPoints(-1);

        return true;
    }

    public boolean doDestroy(int category, int age) throws AgesException {
        table.getCard(category, age).getYellowPoints().addPoints(-1);
        workPool.addPoints(1);

        return true;
    }

    public boolean doUpgrade(int category, int ageFrom, int ageTo) throws AgesException {
        table.getCard(category, ageTo).getYellowPoints().addPoints(1);
        table.getCard(category, ageFrom).getYellowPoints().addPoints(-1);
        return true;
    }

    /**
     * 三個字的指令率先實施打政府牌
     *
     * @param cardNum
     * @param type 0=和平 1=革命
     * @return
     * @throws AgesException
     */
    public boolean doPlayCard(int cardNum, int type) throws AgesException {
        Card card = this.手上的內政牌.get(cardNum);
        System.out.println("DOING...打政府牌" + card);
        System.out.println("DOING...打政府牌" + card.get右上());

//        if (this.手上的內政牌.get(cardNum).get類型() == CardType.政府) {
        if (this.手上的內政牌.get(cardNum).get右上().equals("政府")) {

            if (type == 0) {
                System.out.println("和平方式");
            }
            if (type == 1) {
                System.out.println("革命方式");
            }
        } else {
            System.out.println("這個指令只支援政府牌使用");
        }

        return true;
    }

    /**
     * 玩家拿牌，基本規則可查詢，http://www.livehereandnow.com/?page_id=2259 1.1.1.2.1
     * 拿過領袖的記錄，在Player 設定一個boolean 領袖牌[k] k為時代 1.1.1.3.1
     * 當拿取領袖牌的時候，先檢測是否拿過該時代的領袖牌 1.1.1.3.1.1 如果沒有拿過，則依照該領袖牌的時代，在玩家數據內做拿過的記錄
     * 1.1.1.3.1.2 如果拿過，則提示已經拿過，並否決玩家的行動 不能拿拿過的科技牌 不能拿同時
     *
     * @param cost
     * @param card
     * @return true:表示拿牌成功
     */
    public boolean doTakeCard(int cost, Card card) throws AgesException {
        //TODO check any not allowed...
        this.set失敗原因("無失敗紀錄");

//        //ver 0.56
//        if (card.get類型() != CardType.奇蹟) {
//            if (手上的內政牌.size() >= table.getCard政府().getWhite().getPoints()) {
//                this.set失敗原因("Maximun onhand card count is " + table.getCard政府().getWhite().getPoints() + " based on Government's white!");
//                return false;
//            }
//        }

//        if (!civilCounter.isEnoughToPay(cost)) {//如果內政點數不夠支付的話
//            this.set失敗原因("NOT ENOUGH CIVIL POINTS TO PAY THIS CARD," + card.get卡名());
//            return false;
//        }

        switch (card.get類型()) {
            case CardType.奇蹟: {
                if (this.is有沒有奇蹟待建(card)) {
                    this.set失敗原因("還有尚未完成的奇蹟" + card.get卡名());
                    return false;
                } else {
//                    手上的內政牌.add(card);
                    table.get奇蹟待建區().add(card);
                }
                break;
            }
//            case CardType.領袖: {//當拿取領袖牌的時候，
//
//                if (this.isSameAgeLeaderOnHand已拿取時代領袖(card.時代)) {//先檢測是否拿過該時代的領袖牌
//
//                    this.set失敗原因("已經拿過" + card.時代 + "時代的領袖牌");
////                    System.out.println("已經拿過" + card.時代 + "時代的領袖牌");//          如果拿過，則提示已經拿過， 
//                    return false;//並否決玩家的行動，以return false告知調用的程序，這次拿牌沒有成功
//                } else {
////                     System.out.println("還沒拿過"+card.時代+"時代的領袖牌");
//                    set已拿取時代領袖(card.時代);//          如果沒有拿過，則依照該領袖牌的時代，在玩家數據內做拿過的記錄
//
//                    手上的內政牌.add(card);
//                }
//                break;
//            }
            case CardType.領袖: {
//                System.out.println(" DOING...  ... NEED TO CHECH IF ANY LEADER CARD ON HAND OR ON TABLE");
                if (table.getLeaderDeck().isTaken(card.get時代())) {
                    System.out.println("   ... this age is checked, you cannot get this age's leader card any more!");
                } else {

                    手上的內政牌.add(card);
                    table.getLeaderDeck().setTaken(card.get時代());
                }
                break;
            }
//            當拿取科技牌的時候，
//            先檢測是否拿過
            case CardType.科技: {
//                System.out.println("   ... NEED TO CHECH IF ANY 科技 CARD ON HAND OR ON TABLE");

                手上的內政牌.add(card);

                break;
            }
            case CardType.行動: {
//                System.out.println("   ... NEED TO PERFORM 行動 ...");

                手上的內政牌.add(card);
                break;
            }
            default:
        }
        //拿牌扣點
//        set內政點數(get內政點數() - cost);

//        getCivilCounter().payPoint(cost);
        return true;
    }
//
//    public void showAgesX5() {
//        for (int k = 0; k < 4; k++) {
//            try {
//                System.out.print(" " + ages農場[k].toString(7));
//            } catch (Exception e) {
//
//            }
//        }
//    }
//
//    public void showAgesX5() {
//        showAgesX5("  實驗室", ages實驗室);
//        showAgesX5("  神廟", ages神廟);
//        showAgesX5("  農場", ages農場);
//        showAgesX5("  礦山", ages礦山);
//        showAgesX5("  步兵", ages步兵);
//
//    }
//
//    public void showAgesX5(String title, Card[] ages) {
//        System.out.print("  " + title);
//        for (int k = 0; k < 4; k++) {
//            try {
//                System.out.print(" " + ages[k].toString(6));
//            } catch (Exception e) {
//            }
//        }
//        System.out.println("  ");
//
//    }

    public void showPoints() {
//        System.out.println("\n   " + get點數());
        System.out.println("   內政點數 白點:" + getCivilCounter().getPoint());
        System.out.println("   軍事點數 紅點:" + getMilitaryCounter().getPoint());
        System.out.println("   建築上限　:"+get建築上限().getPoint());
        System.out.println("   內政手牌上限　:"+get內政手牌上限().getPoint());
        System.out.println("   軍事手牌上限　:"+get軍事手牌上限().getPoint());
        System.out.println("   殖民點數　:"+get殖民點數().getPoint());
        System.out.println(scoreBoard);

    }

    public void showStatus() {
        showPoints();
        showBanksAndPool();
        showCards();

//        System.out.println("    人力庫:"+  人力庫.toString());
//        show農場礦山實驗室神廟步兵();
    }

//            礦山 實驗室 神廟  步兵
//    public void show農場礦山實驗室神廟步兵() {
//        String strAges[] = {"A", "I", "II", "III"};
//
//        System.out.print("   農場 (Ages)黃點=>藍點, ");
//        for (int k = 3; k >= 0; k--) {
//            if (this.農場[k].is打出() == true) {
//                System.out.print(" (" + strAges[k] + ")" + get農場(k).toString(1));
//            }
//        }
//
//        System.out.print("\n   礦山 (Ages)黃點=>藍點, ");
//        for (int k = 3; k >= 0; k--) {
//            if (this.礦山[k].is打出() == true) {
//                System.out.print(" (" + strAges[k] + ")" + get礦山(k).toString(1));
//            }
//        }
//        System.out.print("\n   實驗室 (Ages)黃點=>藍點, ");
//        for (int k = 3; k >= 0; k--) {
//            if (this.實驗室[k].is打出() == true) {
//                System.out.print(" (" + strAges[k] + ")" + get實驗室(k).toString(2));
//            }
//        }
//        System.out.print("\n   神廟 (Ages)黃點=>藍點, ");
//        for (int k = 3; k >= 0; k--) {
//            if (this.神廟[k].is打出() == true) {
//                System.out.print(" (" + strAges[k] + ")" + get神廟(k).toString(2));
//            }
//        }
//        System.out.print("\n   步兵 (Ages)黃點=>藍點, ");
//        for (int k = 3; k >= 0; k--) {
//            if (this.步兵[k].is打出() == true) {
//                System.out.print(" (" + strAges[k] + ")" + get步兵(k).toString(2));
//            }
//        }
//        System.out.println("");
//    }
    public void showBanksAndPool() {
        System.out.println("--------------------------");
        System.out.println("   資源庫 " + getBlueBank());
        System.out.println("   人力庫 " + this.get人力庫());
        System.out.println("   工人區 黃點:" + this.workPool);

    }

    public void showCards() {
        System.out.println("--------------------------");
//        showGovernmentCard();
//        showInitCards();
        table.show();

        System.out.print("\n手牌內政牌");
        showCardsOnHand();
        System.out.print("\n手牌軍事牌");
        show手上的軍事牌();
        System.out.println("");
    }

//    public void showInitCards() {
////        System.out.println();
//        for (int k = 0; k < init牌.size(); k++) {
//            System.out.println("     " + k + init牌.get(k).toString(6));
//        }
//
//    }
//    public void showGovernmentCard() {
//        System.out.println("   Govt: " + government.toString(7));
//
//    }
    public void showCardsOnHand() {

        for (int k = 0; k < 手上的內政牌.size(); k++) {
            System.out.print(" " + k + 手上的內政牌.get(k).toString(15));
        }
        System.out.println();
    }
     public void show手上的軍事牌() {

        for (int k = 0; k < 手上的軍事牌.size(); k++) {
            System.out.print(" " + k + 手上的軍事牌.get(k).toString(15));
        }
        System.out.println();
    }

//    public void showCardsOnTable___OTHERS() {
//        for (int k = 0; k < 桌上的牌.size(); k++) {
//            System.out.print(" " + k + 桌上的牌.get(k).toString(5));
//        }
//        //   System.out.println();
//    }
//
//    public void show() {
//        System.out.print(" 手上的內政牌 ");
//        show手上的牌();
//        System.out.print("  礦場=" + 礦山);
//        System.out.print("  神廟=" + 神廟);
//        System.out.print("  實驗室=" + 實驗室);
//        System.out.print("  戰士=" + 步兵);
//        System.out.print("  人力庫=" + 人力庫);
//        System.out.println("  " + toString());
//
//    }
    @Override
    public String toString() {
        return "   ....TODO ...";
    }

}
