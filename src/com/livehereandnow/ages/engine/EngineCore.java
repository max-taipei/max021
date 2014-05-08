/*
 遊戲按人數可分為2.3.4人
 按難度，可分為簡易.標準.完整
 先不考慮變型，有9種玩法
 我們先以2人完整遊戲開發這個程式
 紙盒打開後預計有4個時代的185內政牌，155張軍事牌
 2人完整遊戲，拿掉所有的條約牌，以及右上角顯示3+跟4+的牌
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.engine;

import com.livehereandnow.ages.components.Card;
import com.livehereandnow.ages.components.CardDeck;
import com.livehereandnow.ages.components.CardRow;
import com.livehereandnow.ages.components.CardType;
import com.livehereandnow.ages.components.Cards;
import com.livehereandnow.ages.components.History;
import com.livehereandnow.ages.components.HistoryRecord;
import com.livehereandnow.ages.components.Player;
import com.livehereandnow.ages.exception.AgesException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author chenp_000
 */
public class EngineCore {
//注意
//class名稱一律大寫開頭
//   變量一律小寫開頭,第二個英文字要大寫開頭,例如cardRow
//    常量一律全大寫,例如NOCARD,並加上修飾詞final

//    int[] CARD_POINT = {1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
//    private List<Card> ageA內政牌;
//    private List<Card> old___cardRow;
    int[] CARD_POINT = {1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
    private CardDeck militaryDeck;
    private CardDeck currentEvent;
    private CardDeck futureEvent;

    private CardRow cardRow;
//    private Cards cards;
//  待優化  
//    private List<Card> 玩家1手牌;
//    private List<Card> 玩家1桌牌;
//    private List<Card> player2Cards; // on-hand
//    private List<Card> player2CardsOnTable;
//
//    private List<Card> player3Cards;
//    private List<Card> player4Cards;
//
//    private List<Card> player3CardsOnTable;
//    private List<Card> player4CardsOnTable;
//  待優化
    private Player[] 玩家 = new Player[4];
    private Player 當前玩家;

    /**
     * 獲得當前玩家的物件
     *
     * @return
     */
    public Player get當前玩家() {
        return 當前玩家;
    }

    public void set當前玩家(Player current玩家) {
        this.當前玩家 = current玩家;
    }

//    public Player get玩家(int k) {
//        return 玩家[k];
//    }
    final Card NOCARD = new Card(999, "", 0, CardType.EMPTY);
//    int playerm
//    2014-4-16 max 10:32,使用refactor變更變量名稱
    private int 當前玩家ID;
    private int 玩家人數 = 2;
    private int roundNum;
    private History history;

    public int getRoundNum() {
        return roundNum;
    }

    String feedback = null;

    public String getFeedback() {
        if (feedback == null) {
            return getCardRowInfo();
        }
        return feedback;
    }

    public void setFeedback(String str) {
        feedback = str;
    }

    public String getHistory() {
        return history.toString();
    }

    public String getCardRowInfo() {

        return cardRow.toString();
    }

    public boolean doStatus() throws AgesException {

        cardRow.show(11);//[A-亞歷山大大帝-領袖]
        System.out.println("\n   === 牌庫" + " === ");
        System.out.print("內政牌庫 時代I牌數:" + cardRow.getRemainingCardCount(1));
        System.out.print(" 時代II牌數:" + cardRow.getRemainingCardCount(2));
        System.out.println(" 時代III牌數:" + cardRow.getRemainingCardCount(3));
        System.out.println("軍事牌庫 " + militaryDeck);
        System.out.println("   === 事件" + " === ");
        System.out.println("未來事件 " + futureEvent);
        System.out.println("當前事件 " + currentEvent + " should be 4 AAAA");
//        System.out.println("過去事件:0可以不需要有");//
        System.out.println();
        System.out.println("   === Round #" + roundNum + ", " + this.當前玩家.getName() + " === ");
        this.當前玩家.showStatus();

//        System.out.print("   --- Player A is " + 玩家[0].getName() + " ---");
//        玩家[0].showStatus();
//        System.out.print("\n\n   --- Player B is " + 玩家[1].getName() + " ---");
//        玩家[1].showStatus();
//        System.out.println();
//        System.out.println();
        return true;
    }

//    public String getPlayerCardsString(List<Card> list) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(" ");
//        for (int k = 0; k < list.size(); k++) {
////            sb.append("[").append(list.get(k).get卡名()).append("] ");
//            sb.append(list.get(k).get卡名and類型Name());
//        }
//        return sb.toString();
//    }
    public void doNewGame() {

        System.out.println("新的遊戲開始");
    }

    public boolean doChangeTurn() throws AgesException {
        //  System.out.println("運行doChangeTurn");
        get當前玩家().執行生產();
        history.addRecord(roundNum, get當前玩家().getName(), "change-turn ", " --- ");

        if ((1 + 當前玩家ID) == 玩家人數) {
            當前玩家ID = 0;
            roundNum++;
        } else {
            當前玩家ID++;
        }
        this.set當前玩家(玩家[當前玩家ID]);

        if (roundNum == 1) {
            get當前玩家().getCivilCounter().setPoint(2);
        } else {
            get當前玩家().doStartRound();
        }
        // addCard
        if (roundNum >= 2) {
//            System.out.println(" ... auto add cards");
            cardRow.setRound(roundNum);
            cardRow.addCards();
        }
        setFeedback(null);

        return true;
    }

    public EngineCore() throws AgesException {
        init();
    }

    public void init() throws AgesException {
        history = new History();
        militaryDeck = new CardDeck();
        currentEvent = new CardDeck();
        futureEvent = new CardDeck();

        militaryDeck.getList().addAll(new Cards().get某時代軍事牌(1));

        玩家[0] = new Player();
        玩家[1] = new Player();
        玩家[2] = new Player();
        玩家[3] = new Player();

        玩家[0].setName("Max");
        玩家[1].setName("Amy");

        當前玩家 = 玩家[0];

        //當前玩家ID = 1; // TODO .... PROBLEM
        當前玩家ID = 0; //

        roundNum = 1;

        玩家[0].getMilitaryCounter().setPoint(0);//DEBUG 方便測試
        玩家[0].getCivilCounter().setPoint(1);//DEBUG 方便測試

        cardRow = new CardRow(玩家人數);

        System.out.println("   ========================");
        System.out.println("   *    Welcome to XXX    *");
        System.out.println("   ========================");

        this.doStatus();
    }

    public boolean doSetCulture(int k) {
//        玩家[當前玩家ID - 1].get點數().set文化(k);
        return true;
    }

    public boolean doConstructWonder() throws AgesException {
//            Card card = ;
//        int cardPoint = 1;//DEBUG，假設需要一個內政點數來打牌
        get當前玩家().doConstructWonder();

        return true;
    }

    public boolean doBrief() throws AgesException {
    
        String feedback= getCardRowInfo();
        
        setFeedback(feedback);
        return true;
    }
    
    public boolean doDebug() throws AgesException {
        System.out.println("手牌上限值的定義，為當前板塊上的內政點數和，由Cards列出所有相關的牌");
//          cards.show和手牌數相關的牌();
        Cards xxx = new Cards();
        System.out.println("----------------------------------------------");
        xxx.show和手牌數相關的牌();

        System.out.println("DOING HISTORY----------------------------------------------");
        history.show();
        return true;
    }

    public boolean doIncreasePopulation() throws AgesException {
        return get當前玩家().doIncreasePolutaion();
    }

    public boolean doRevolution() throws AgesException {
        return get當前玩家().doRevolution();
    }

    public boolean doChangeGovernment() throws AgesException {
        return get當前玩家().doChangeGovernment();
    }

    public boolean doFarm() throws AgesException {
//            Card card = ;
//        int cardPoint = 1;//DEBUG，假設需要一個內政點數來打牌
        System.out.println("EngineCore的DOFarm");
        get當前玩家().doFarm();

        return true;
    }

    public boolean doPlayCardWithRoundNumber(int p1) throws AgesException {
//            Card card = ;
//        int cardPoint = 1;//DEBUG，假設需要一個內政點數來打牌
        Card card = cardRow.getCards().get(p1);
        if (get當前玩家().doPlayCardWithRoundNumber(p1, this.roundNum)) {
            history.addRecord(roundNum, get當前玩家().getName(), "play-card " + p1, card.toString(1));
            return true;
        }

        return false;
    }

    public boolean doPlayCard革命(int p1) throws AgesException {
//            Card card = ;
//        int cardPoint = 1;//DEBUG，假設需要一個內政點數來打牌
        Card card = cardRow.getCards().get(p1);
        if (get當前玩家().doPlayCard革命(p1, this.roundNum)) {
            history.addRecord(roundNum, get當前玩家().getName(), "oo革命 " + p1, card.toString(1));
            return true;
        }

        return false;
    }

    public boolean doPlayCard(int k, int k2) throws AgesException {
        get當前玩家().doPlayCard(k, k2);

        return true;
    }

    public boolean doUpgrade(int p1, int p2, int p3) throws AgesException {
        get當前玩家().doUpgrade(p1, p2, p3);

        return true;
    }

    public boolean doBuild(int k, int k2) throws AgesException {
        get當前玩家().doBuild(k, k2);

        return true;
    }

    public boolean doDestroy(int k, int k2) throws AgesException {
        get當前玩家().doDestroy(k, k2);

        return true;
    }

    /**
     * 1. take card
     *
     * (1)enough point to take card
     *
     * (2)not allow to take any card which is being taken within this round
     *
     * (3)not allow to take AgeA leader if you ever took it successfully
     *
     * 2. maintain points when take card successfully
     *
     * @param p1
     * @return true: perform take-card successfully
     */
    public boolean doTakeCard(int p1) throws AgesException {
        int cardNum = p1;
        if (cardNum > 12 || cardNum < 0) { // card number must be 0 to 12 only 
//                        System.out.println("card number must be 0 to 12 only *** Nothing happened ***");
            System.out.println("拿的牌號必須要在0~12之內 *** 什麼事情都沒發生 ***");
            setFeedback("拿的牌號必須要在0~12之內 *** 什麼事情都沒發生 ***");
            return true;
        }
        if (cardRow.getCards().get(cardNum).get編號() == 999) {
//                        System.out.println("不讓玩家拿空牌 *** Nothing happened ***");
            System.out.println("不讓玩家拿空牌 *** 什麼事情都沒發生 ***");
            setFeedback("不讓玩家拿空牌 *** 什麼事情都沒發生 ***");

            return true;
        }

//        Card card = old___cardRow.get(p1);
        int cardPoint = CARD_POINT[p1];
        Card card = cardRow.getCards().get(p1);

        //ver 0.55
        card.setRound(this.roundNum);

//        if (card.get卡名().length() == 0) {
//            System.out.println("This card has been taken! ***Nothing happened***");
//            return true;
//        }
        if (get當前玩家().doTakeCard(cardPoint, card)) {//如果當當前玩家成功拿了牌
            // when card is taken successfully
//            old___cardRow.remove(p1);//從卡牌列上移除該牌
//            old___cardRow.add(p1, NOCARD);//並在卡牌列同一個位置增加空牌
            cardRow.getCards().remove(p1);//從卡牌列上移除該牌
            cardRow.getCards().add(p1, NOCARD);//並在卡牌列同一個位置增加空牌
            setFeedback(getCardRowInfo());

            history.addRecord(roundNum, get當前玩家().getName(), "take-card " + p1, card.toString(1));
        } else {
//            System.out.println("拿牌沒有成功" + card.get卡名());
            System.out.println("   拿牌沒有成功的原因:" + get當前玩家().get失敗原因());
            setFeedback("   拿牌沒有成功的原因:" + get當前玩家().get失敗原因());

        }

        //    do拿牌扣點(cardPoint);
        return true;
    }

    public boolean doHelpShort() {
        System.out.println("   help         this command");
        System.out.println("\n=== basic commands === (start)");

        System.out.println("c  回合交替  ");
        System.out.println("t x 拿牌 x=位置  ");
        System.out.println("s 顯示目前狀態");
        System.out.println("u 3 0 1 升級 農業 從0 到 1");
        System.out.println("d 3 1 摧毀 農業 1");
        System.out.println("d DEBUG，目前含檢視歷史紀錄");
        System.out.println("b 3 1 建造 農業 1");
        System.out.println("o 0 打出 第0張牌/p 1 打出 第1張牌");
        return true;
    }

    public boolean doHelp() {
        System.out.println("   help         this command");
        System.out.println("\n=== basic commands === (start)");

        System.out.println("debug  列出正在開發中的信息  ");
        System.out.println("population  ");

        System.out.println(" revolution 革命!");
        System.out.println(" change-government 和平轉移政權");
        System.out.println("   take-card X  take number X card, X is 0 base");
        System.out.println("   upgrade | u | 參數x,y,z x=項目代號1~5 y=從哪個時代 z=到哪個時代   ");
        System.out.println("   change-turn | c | ..    change player's turn");
        System.out.println("   status       to show current game status");
        System.out.println("   version      顯示版本變更歷史");
        System.out.println("  TODO         代辦事項");
        System.out.println("=== term === (start)");
        System.out.println("[current events]=[當前事件]，中文版說明書有錯誤");
        System.out.println("[future events]=[未來事件]");
        System.out.println("[military deck]=[軍事牌組]");
        System.out.println("[civil deck]=[內政牌組]");
        return true;
    }

//    public boolean doTODO() {
//        System.out.println();
//        System.out.println("  === TODO ===  ");
//        System.out.println("    1, 在change-turn的時候 目前玩家可以依照他目前的私有板塊獲得對應的資源，預計花1個小時完成,4/20日完成");
//        System.out.println("    2, 在Player內設置當前領袖位置.戰術牌位置.待建奇蹟位置.建好的奇蹟.值民地位置,預計花0.5個小時完成,4/20日完成");
//        System.out.println("    done, 在Player內設置I時代所有的科技牌位置");
//        System.out.println("    done, 目前第二個玩家有可能用兩個內政點數拿兩張時代A的領袖牌,應予以制止");
//        System.out.println("    done, 在指令行能用什麼樣的指令，把數字放到剛剛建好的內部類Score,設定文明指數set-culture 3");//
//        return true;
//    }
}
