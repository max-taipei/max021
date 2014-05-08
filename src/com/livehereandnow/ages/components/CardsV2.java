/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.components;

import static com.livehereandnow.ages.components.CardType.事件;
import static com.livehereandnow.ages.components.CardType.侵略;
import static com.livehereandnow.ages.components.CardType.內政;
import static com.livehereandnow.ages.components.CardType.奇蹟;
import static com.livehereandnow.ages.components.CardType.戰術;
import static com.livehereandnow.ages.components.CardType.棕色;
import static com.livehereandnow.ages.components.CardType.橙色;
import static com.livehereandnow.ages.components.CardType.深棕色;
import static com.livehereandnow.ages.components.CardType.深紅色;
import static com.livehereandnow.ages.components.CardType.深綠色;
import static com.livehereandnow.ages.components.CardType.淺綠色;
import static com.livehereandnow.ages.components.CardType.灰色;
import static com.livehereandnow.ages.components.CardType.獎勵;
import static com.livehereandnow.ages.components.CardType.科技;
import static com.livehereandnow.ages.components.CardType.紅色;
import static com.livehereandnow.ages.components.CardType.紫色;
import static com.livehereandnow.ages.components.CardType.綠色;
import static com.livehereandnow.ages.components.CardType.藍色;
import static com.livehereandnow.ages.components.CardType.行動;
import static com.livehereandnow.ages.components.CardType.軍事;
import static com.livehereandnow.ages.components.CardType.雙色;
import static com.livehereandnow.ages.components.CardType.領袖;
import static com.livehereandnow.ages.components.CardType.黃色;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author max
 */
public class CardsV2 implements CardType {

    List<Card> cards;
    List<Card> initCards;
    Card init政府;
    Card init實驗室;
    Card init神廟;
    Card init農場;
    Card init礦山;
    Card init步兵;

    public Card getInit政府() {
        return init政府;
    }

    public Card getInit實驗室() {
        return init實驗室;
    }

    public Card getInit神廟() {
        return init神廟;
    }

    public Card getInit農場() {
        return init農場;
    }

    public Card getInit礦山() {
        return init礦山;
    }

    public Card getInit步兵() {
        return init步兵;
    }

    public Card getInitGovernment() {
        return init政府;
    }

    public List<Card> copyInitCards() {
        List<Card> temp = new ArrayList<>();
        for (int k = 0; k < initCards.size(); k++) {
            temp.add(initCards.get(k));
        }

        return temp;
    }

    public List<Card> get所有的牌() {
        return cards;
    }

    public void show和手牌數相關的牌() {
        System.out.println("顯示出get和手牌數相關的牌()");
//        System.out.println("335678" + this.get和手牌數相關的牌().size());
//        this.get和手牌數相關的牌().get(內政).get卡名()
        for (Card card : get和手牌數相關的牌()) {
            System.out.println(card.toString(10));
        }
//return ;
    }

    public List<Card> get和手牌數相關的牌() {
        List<Card> list = new ArrayList<>();

        for (int k = 0; k < cards.size(); k++) {
            if ((cards.get(k).get右上().equals("政府"))) {
                list.add(cards.get(k));
            }
        }

        return list;
    }

    public List<Card> get某時代內政牌(int age) {
        List<Card> list = new ArrayList<>();
        for (int k = 0; k < cards.size(); k++) {
            if ((cards.get(k).get時代() == age) && (cards.get(k).get牌背() == 內政)) {
                list.add(cards.get(k));
            }
        }
        return list;
    }

    public List<Card> get某時代軍事牌(int age) {
        List<Card> list = new ArrayList<>();
        for (int k = 0; k < cards.size(); k++) {
            if ((cards.get(k).get時代() == age) && (cards.get(k).get牌背() == 軍事)) {
                System.out.println(" military => " + cards.get(k).toString(1));
                list.add(cards.get(k));
            }
        }
        return list;
    }

    public List<Card> get測試牌(int test) {
        List<Card> 內政牌 = new ArrayList<>();
        switch (test) {
            case 1://時代1的科技牌
                for (int k = 0; k < cards.size(); k++) {
                    if ((cards.get(k).get時代() == 1) && (cards.get(k).get類型() == 科技)) {
                        內政牌.add(cards.get(k));
                    }
                }
                break;
            case 2://時代0跟時代1的奇蹟跟領袖
                for (int k = 0; k < cards.size(); k++) {
                    if ((cards.get(k).get類型() == 奇蹟) || (cards.get(k).get類型() == 領袖)) {
                        內政牌.add(cards.get(k));
                    }
                }
                break;
            case 3://所有時代的領袖牌
                for (int k = 0; k < cards.size(); k++) {
                    if ((cards.get(k).get類型() == 領袖)) {
                        內政牌.add(cards.get(k));
                        內政牌.add(cards.get(k));
                    }
                }
                break;
            case 4://所有時代的奇蹟
                for (int k = 0; k < cards.size(); k++) {
                    if ((cards.get(k).get類型() == 奇蹟)) {
                        內政牌.add(cards.get(k));
                        內政牌.add(cards.get(k));
                    }
                }
                break;
            default:
        }

        return 內政牌;
    }

    public CardsV2() {
 
        initCards = new ArrayList<>();

        cards = new ArrayList<>();
        cards.add(new Card(1001, "專制", 0, 內政, 科技, 橙色, "政府", "內政點數+4;軍事點數+2;建築上限+2", "0"));
        cards.add(new Card(1002, "亞歷山大圖書館", 0, 內政, 奇蹟, 紫色, "奇蹟", "科技生產+1;文化生產+1;內政手牌上限+1;軍事手牌上限+1", "1;2;2;1"));
        cards.add(new Card(1003, "亞歷山大大帝", 0, 內政, 領袖, 綠色, "領袖", "每1個紅色科技牌上的黃點;軍力+1", "0"));
        cards.add(new Card(1004, "亞里士多得", 0, 內政, 領袖, 綠色, "領袖", "拿取科技牌時;科技+1", "0"));
        cards.add(new Card(1005, "人口的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家免費擴充1人口", "0"));
        cards.add(new Card(1006, "軍事的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家可以選擇是否使用1個閒置人口免費建造1個戰士", "0"));
        cards.add(new Card(1007, "農業", 0, 內政, 科技, 棕色, "農場", "食物生產+1", "2"));
        cards.add(new Card(1008, "農業的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家食物+2", "0"));
        cards.add(new Card(1009, "凱薩", 0, 內政, 領袖, 綠色, "領袖", "軍力+1;軍事點數+1", "0"));
        cards.add(new Card(1010, "哲學", 0, 內政, 科技, 灰色, "實驗室", "科技生產+1", "3"));
        cards.add(new Card(1011, "宗教", 0, 內政, 科技, 灰色, "神廟", "笑臉+1;文化生產+1", "3"));
        cards.add(new Card(1012, "宗教的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家可以選擇是否使用1個閒置人口免費建造1個宗教", "0"));
        cards.add(new Card(1013, "富饒之土", 0, 內政, 行動, 黃色, "行動", "提供1資源建造農場或是礦山", "0"));
        cards.add(new Card(1014, "工程天才", 0, 內政, 行動, 黃色, "行動", "提供2資源建造奇蹟", "0"));
        cards.add(new Card(1015, "巨人像", 0, 內政, 奇蹟, 紫色, "奇蹟", "軍力+1;文化生產+1;殖民點數+1", "3;3"));
        cards.add(new Card(1016, "市場的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家資源+2", "0"));
        cards.add(new Card(1017, "建築工地", 0, 內政, 行動, 黃色, "行動", "提供1資源建造非農場或礦山的建築", "0"));
        cards.add(new Card(1018, "戰士", 0, 內政, 科技, 紅色, "步兵", "軍力+1", "2"));
        cards.add(new Card(1019, "手工業的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家可以選擇食物+2或是資源+2", "0"));
        cards.add(new Card(1020, "摩西", 0, 內政, 領袖, 綠色, "領袖", "擴充人口;食物需求-1", "0"));
        cards.add(new Card(1021, "政治的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家可以抽3張軍事牌;本回合跳過軍事牌檢測階段", "0"));
        cards.add(new Card(1022, "無事件", 0, 軍事, 事件, 深綠色, "事件", "0", "0"));
        cards.add(new Card(1023, "漢摩拉比", 0, 內政, 領袖, 綠色, "領袖", "內政點數+1;軍事點數-1", "0"));
        cards.add(new Card(1024, "愛國主義", 0, 內政, 行動, 黃色, "行動", "軍事點數+1;提供1資源用於建造或升級軍隊", "0"));
        cards.add(new Card(1025, "科技的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家科技+2", "0"));
        cards.add(new Card(1026, "空中花園", 0, 內政, 奇蹟, 紫色, "奇蹟", "笑臉+2;文化生產+1", "2;2;2"));
        cards.add(new Card(1027, "藝術作品", 0, 內政, 行動, 黃色, "行動", "文化+6", "0"));
        cards.add(new Card(1028, "節儉", 0, 內政, 行動, 黃色, "行動", "支付正常價格擴充人口後;獲得1食物", "0"));
        cards.add(new Card(1029, "荷馬", 0, 內政, 領袖, 綠色, "領袖", "建造戰士;資源需求-1(1回合1次);回合結束戰士上的黃點提供文化生產+1(最多2)", "0"));
        cards.add(new Card(1030, "貿易的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家獲得食物+1資源+1科技+1文化+1", "0"));
        cards.add(new Card(1031, "金字塔", 0, 內政, 奇蹟, 紫色, "奇蹟", "內政點數+1", "3;2;1"));
        cards.add(new Card(1032, "青銅", 0, 內政, 科技, 棕色, "礦山", "資源生產+1", "2"));
        cards.add(new Card(1033, "革新思想", 0, 內政, 行動, 黃色, "行動", "科技+1", "0"));
        cards.add(new Card(1036, "萬里長城", 1, 內政, 奇蹟, 紫色, "奇蹟", "文化生產+1;每個步兵和砲兵+1軍力", "2;2;3;2"));
        cards.add(new Card(1037, "中世紀軍隊", 1, 軍事, 戰術, 深紅色, "戰術", "步馬+2", "0"));
        cards.add(new Card(1037, "中世紀軍隊", 1, 軍事, 戰術, 深紅色, "戰術", "步馬+2", "0"));
        cards.add(new Card(1037, "中世紀軍隊", 1, 軍事, 戰術, 深紅色, "戰術", "步馬+2", "0"));
        cards.add(new Card(1038, "豐收", 1, 內政, 行動, 黃色, "行動", "食物+2", "0"));
        cards.add(new Card(1039, "兵家必爭之地", 1, 軍事, 事件, 淺綠色, "領土", "+2軍力;立即抽3張軍事牌", "0"));
        cards.add(new Card(1040, "兵陣", 1, 軍事, 戰術, 深紅色, "戰術", "步步+1", "0"));
        cards.add(new Card(1040, "兵陣", 1, 軍事, 戰術, 深紅色, "戰術", "步步+1", "0"));
        cards.add(new Card(1040, "兵陣", 1, 軍事, 戰術, 深紅色, "戰術", "步步+1", "0"));
        cards.add(new Card(1041, "戰爭機構", 1, 內政, 科技, 藍色, "軍事", "軍力+1;軍事點數+1", "4"));
        cards.add(new Card(1042, "軍團", 1, 軍事, 戰術, 深紅色, "戰術", "步步步+2", "0"));
        cards.add(new Card(1042, "軍團", 1, 軍事, 戰術, 深紅色, "戰術", "步步步+2", "0"));
        cards.add(new Card(1042, "軍團", 1, 軍事, 戰術, 深紅色, "戰術", "步步步+2", "0"));
        cards.add(new Card(1043, "製圖術", 1, 內政, 科技, 藍色, "殖民", "軍力+1;殖民點數+2", "4"));
        cards.add(new Card(1044, "劍士", 1, 內政, 科技, 紅色, "步兵", "軍力+2", "3;3"));
        cards.add(new Card(1044, "劍士", 1, 內政, 科技, 紅色, "步兵", "軍力+2", "3;3"));
        cards.add(new Card(1046, "十字軍東征", 1, 軍事, 事件, 深綠色, "事件", "最高軍力文化+4;最低軍力文化-4", "0"));
        cards.add(new Card(1047, "卡羅琳娜大學", 1, 內政, 奇蹟, 紫色, "奇蹟", "文化生產+1;科技生產+2", "3;3;3"));
        cards.add(new Card(1048, "印刷術", 1, 內政, 科技, 灰色, "圖書館", "文化生產+1;科技生產+1", "3"));
        cards.add(new Card(1048, "印刷術", 1, 內政, 科技, 灰色, "圖書館", "文化生產+1;科技生產+1", "3"));
        cards.add(new Card(1049, "歷史悠久之地", 1, 軍事, 事件, 淺綠色, "領土", "笑臉+1;文化+6", "0"));
        cards.add(new Card(1051, "叛亂", 1, 軍事, 事件, 深綠色, "事件", "每一個不開心的工人;下回合開始內政點數-2", "0"));
        cards.add(new Card(1052, "君主制", 1, 內政, 科技, 橙色, "政府", "內政點數+5;軍事點數+3;建築上限+3", "9;3"));
        cards.add(new Card(1053, "河蟹娛樂", 1, 內政, 科技, 灰色, "競技場", "軍力+1;笑臉+2", "3;4"));
        cards.add(new Card(1053, "河蟹娛樂", 1, 內政, 科技, 灰色, "競技場", "軍力+1;笑臉+2", "3;4"));
        cards.add(new Card(1055, "哥倫布", 1, 內政, 領袖, 綠色, "領袖", "你可以在政治階段改為打出1張殖民地;並且獲得它(只能使用1次)", "0"));
        cards.add(new Card(1056, "聖女貞德", 1, 內政, 領袖, 綠色, "領袖", "你的每個神廟笑臉;使你的軍力+1;你受到侵略或是戰爭前;文化+5", "0"));
        cards.add(new Card(1057, "聖彼得大教堂", 1, 內政, 奇蹟, 紫色, "奇蹟", "文化生產+2;你的建築以及奇蹟笑臉*2", "4;4"));
        cards.add(new Card(1058, "防禦卡", 1, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+2;殖民時殖民點數+1", "0"));
        cards.add(new Card(1058, "防禦卡", 1, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+2;殖民時殖民點數+1", "0"));
        cards.add(new Card(1058, "防禦卡", 1, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+2;殖民時殖民點數+1", "0"));
        cards.add(new Card(1058, "防禦卡", 1, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+2;殖民時殖民點數+1", "0"));
        cards.add(new Card(1058, "防禦卡", 1, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+2;殖民時殖民點數+1", "0"));
        cards.add(new Card(1058, "防禦卡", 1, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+2;殖民時殖民點數+1", "0"));
        cards.add(new Card(1059, "奴役", 1, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2;對象玩家人口-1;你獲得3資源", "0"));
        cards.add(new Card(1059, "奴役", 1, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2;對象玩家人口-1;你獲得3資源", "0"));
        cards.add(new Card(1060, "好收成", 1, 軍事, 事件, 深綠色, "事件", "每個玩家;生產一次農場", "0"));
        cards.add(new Card(1061, "富饒之土", 1, 內政, 行動, 黃色, "行動", "提供2資源建造農場或是礦山", "0"));
        cards.add(new Card(1061, "富饒之土", 1, 內政, 行動, 黃色, "行動", "提供2資源建造農場或是礦山", "0"));
        cards.add(new Card(1062, "富饒肥沃之地", 1, 軍事, 事件, 淺綠色, "領土", "黃點+3;立即食物+3", "0"));
        cards.add(new Card(1063, "工程天才", 1, 內政, 行動, 黃色, "行動", "提供3資源建造奇蹟", "0"));
        cards.add(new Card(1064, "巴巴羅薩", 1, 內政, 領袖, 綠色, "領袖", "你可以用1點內政點數;建造1個軍事單位;資源以及食物需求-1", "0"));
        cards.add(new Card(1065, "建築工地", 1, 內政, 行動, 黃色, "行動", "提供2資源建造非農場或礦山的建築", "0"));
        cards.add(new Card(1065, "建築工地", 1, 內政, 行動, 黃色, "行動", "提供2資源建造非農場或礦山的建築", "0"));
        cards.add(new Card(1067, "恐怖地區", 1, 軍事, 事件, 深綠色, "事件", "軍力最低損失1個工人", "0"));
        cards.add(new Card(1068, "戲劇", 1, 內政, 科技, 灰色, "劇院", "文化生產+2;笑臉+1", "4;4"));
        cards.add(new Card(1068, "戲劇", 1, 內政, 科技, 灰色, "劇院", "文化生產+2;笑臉+1", "4;4"));
        cards.add(new Card(1069, "成吉思汗", 1, 內政, 領袖, 綠色, "領袖", "忽略戰術牌的軍力加成;你的騎兵軍力+1", "0"));
        cards.add(new Card(1070, "掠奪", 1, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2;對象玩家;失去資源和食物共3;你獲得相同資源食物", "0"));
        cards.add(new Card(1070, "掠奪", 1, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2;對象玩家;失去資源和食物共3;你獲得相同資源食物", "0"));
        cards.add(new Card(1071, "文化的影響", 1, 軍事, 事件, 深綠色, "事件", "每個玩家;生產一次文化", "0"));
        cards.add(new Card(1072, "新的礦藏", 1, 軍事, 事件, 深綠色, "事件", "每個玩家;生產一次礦山", "0"));
        cards.add(new Card(1073, "方陣", 1, 軍事, 戰術, 深紅色, "戰術", "步步馬+3", "0"));
        cards.add(new Card(1073, "方陣", 1, 軍事, 戰術, 深紅色, "戰術", "步步馬+3", "0"));
        cards.add(new Card(1074, "有人居住之地", 1, 軍事, 事件, 淺綠色, "領土", "黃點+2;立即免費生產1個工人", "0"));
        cards.add(new Card(1075, "法典", 1, 內政, 科技, 藍色, "內政", "內政點數+1", "6"));
        cards.add(new Card(1076, "泰姬陵", 1, 內政, 奇蹟, 紫色, "奇蹟", "文化生產+3", "2;4;2"));
        cards.add(new Card(1077, "灌溉", 1, 內政, 科技, 棕色, "農場", "食物生產+2", "3;4"));
        cards.add(new Card(1077, "灌溉", 1, 內政, 科技, 棕色, "農場", "食物生產+2", "3;4"));
        cards.add(new Card(1078, "煉金術", 1, 內政, 科技, 灰色, "實驗室", "科技生產+2", "4;6"));
        cards.add(new Card(1078, "煉金術", 1, 內政, 科技, 灰色, "實驗室", "科技生產+2", "4;6"));
        cards.add(new Card(1079, "愛國主義", 1, 內政, 行動, 黃色, "行動", "軍事點數+1;提供2資源用於建造或升級軍隊", "0"));
        cards.add(new Card(1080, "物資豐富之地", 1, 軍事, 事件, 淺綠色, "領土", "藍點+3;立即資源+5;", "0"));
        cards.add(new Card(1081, "瘟疫", 1, 軍事, 事件, 深綠色, "事件", "每個玩家損失1個工人", "0"));
        cards.add(new Card(1082, "石工學", 1, 內政, 科技, 藍色, "建築", "當你建造以及預計升級建築物;1級減免1;2級減免1;3級減免1", "3"));
        cards.add(new Card(1083, "礦藏", 1, 內政, 行動, 黃色, "行動", "資源+2", "0"));
        cards.add(new Card(1084, "神學", 1, 內政, 科技, 灰色, "神廟", "文化生產+1;笑臉+2", "2;5"));
        cards.add(new Card(1084, "神學", 1, 內政, 科技, 灰色, "神廟", "文化生產+1;笑臉+2", "2;5"));
        cards.add(new Card(1085, "神權政治", 1, 內政, 科技, 橙色, "政府", "內政點數+4;軍事點數+3;笑臉+2;建築上限+3", "7;2"));
        cards.add(new Card(1086, "科技先進之地", 1, 軍事, 事件, 淺綠色, "領土", "黃點+1;藍點+1;立即科技+3", "0"));
        cards.add(new Card(1087, "科技突破", 1, 軍事, 事件, 深綠色, "事件", "每個玩家;生產一次科技", "0"));
        cards.add(new Card(1088, "移民", 1, 軍事, 事件, 深綠色, "事件", "最高笑臉的玩家;生產1個工人", "0"));
        cards.add(new Card(1089, "突破", 1, 內政, 行動, 黃色, "行動", "支付正常打出科技後;獲得2科技", "0"));
        cards.add(new Card(1090, "突襲", 1, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2;拆除對象目標建築物共1個;你獲得建造向下取整的一半資源", "0"));
        cards.add(new Card(1090, "突襲", 1, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2;拆除對象目標建築物共1個;你獲得建造向下取整的一半資源", "0"));
        cards.add(new Card(1091, "米開朗基羅", 1, 內政, 領袖, 綠色, "領袖", "每個笑臉;文化生產+1", "0"));
        cards.add(new Card(1092, "藝術作品", 1, 內政, 行動, 黃色, "行動", "文化+5", "0"));
        cards.add(new Card(1093, "節儉", 1, 內政, 行動, 黃色, "行動", "支付正常價格擴充人口後;獲得2食物", "0"));
        cards.add(new Card(1094, "蠻族入侵", 1, 軍事, 事件, 深綠色, "事件", "分數最高的玩家;如果軍力最低;損失1個工人", "0"));
        cards.add(new Card(1095, "輕騎兵", 1, 軍事, 戰術, 深紅色, "戰術", "馬馬+2", "0"));
        cards.add(new Card(1095, "輕騎兵", 1, 軍事, 戰術, 深紅色, "戰術", "馬馬+2", "0"));
        cards.add(new Card(1096, "邊境衝突", 1, 軍事, 事件, 深綠色, "事件", "軍力最高的玩家資源+3;軍力最低的玩家;拆除1個礦山或農場", "0"));
        cards.add(new Card(1097, "達文西", 1, 內政, 領袖, 綠色, "領袖", "當你打出科技牌時;獲得資源+1。科技生產值=你最高實驗室的等級", "0"));
        cards.add(new Card(1098, "重騎兵", 1, 軍事, 戰術, 深紅色, "戰術", "馬馬馬+4", "0"));
        cards.add(new Card(1098, "重騎兵", 1, 軍事, 戰術, 深紅色, "戰術", "馬馬馬+4", "0"));
        cards.add(new Card(1099, "鐵礦", 1, 內政, 科技, 棕色, "礦山", "資源生產+2", "5;5"));
        cards.add(new Card(1099, "鐵礦", 1, 內政, 科技, 棕色, "礦山", "資源生產+2", "5;5"));
        cards.add(new Card(1100, "革新思想", 1, 內政, 行動, 黃色, "行動", "科技+2", "0"));
        cards.add(new Card(1101, "領土糾紛", 1, 軍事, 事件, 深綠色, "事件", "軍力最高的玩家;增加1個黃點;軍力最低的玩家;減少1個黃點", "0"));
        cards.add(new Card(1102, "騎士", 1, 內政, 科技, 紅色, "騎兵", "軍力+2", "4;3"));
        cards.add(new Card(1102, "騎士", 1, 內政, 科技, 紅色, "騎兵", "軍力+2", "4;3"));
        cards.add(new Card(1103, "高效升級", 1, 內政, 行動, 黃色, "行動", "升級農場;礦山少支付2點資源", "0"));
        cards.add(new Card(1103, "高效升級", 1, 內政, 行動, 黃色, "行動", "升級農場;礦山少支付2點資源", "0"));
        cards.add(new Card(1104, "鼠疫", 1, 軍事, 事件, 深綠色, "事件", "每個玩家失去所有食物", "0"));
        cards.add(new Card(1107, "豐收", 2, 內政, 行動, 黃色, "行動", "食物+3", "0"));
        cards.add(new Card(1108, "破碎的偶像", 2, 軍事, 事件, 深綠色, "事件", "移除非當時代的領袖", "0"));
        cards.add(new Card(1109, "克里姆林宮", 2, 內政, 奇蹟, 紫色, "奇蹟", "笑臉-2;內政點數+1;軍事點數+1;文化生產+3", "0"));
        cards.add(new Card(1110, "共和制", 2, 內政, 科技, 橙色, "政府", "內政點數+8;軍事點數+2", "0"));
        cards.add(new Card(1111, "兵家必爭之地", 2, 軍事, 事件, 淺綠色, "領土", "軍力+4;抽5張軍事牌", "0"));
        cards.add(new Card(1113, "冷戰", 2, 軍事, 事件, 深綠色, "事件", "軍力最高的玩家;科技+6", "0"));
        cards.add(new Card(1114, "刺殺", 2, 軍事, 侵略, 深棕色, "侵略", "軍事點數[-依照對象領袖等級];移除領袖;你獲得領袖等級*3文化", "0"));
        cards.add(new Card(1115, "歷史悠久之地", 2, 軍事, 事件, 淺綠色, "領土", "笑臉+2;文化+11", "0"));
        cards.add(new Card(1116, "古典陣型", 2, 軍事, 戰術, 深紅色, "戰術", "步步馬馬9(4)", "0"));
        cards.add(new Card(1117, "司法系統", 2, 內政, 科技, 藍色, "內政", "內政點數+1;藍點+3", "7"));
        cards.add(new Card(1118, "君主立憲制", 2, 內政, 科技, 橙色, "政府", "內政點數+6;軍事點數+4", "0"));
        cards.add(new Card(1119, "吞併", 2, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2;指定對象一個殖民地轉移;無法獲得立即獎勵", "0"));
        cards.add(new Card(1120, "團隊競技", 2, 內政, 科技, 灰色, "競技場", "軍力+2;笑臉+3", "0"));
        cards.add(new Card(1123, "艾菲爾鐵塔", 2, 內政, 奇蹟, 紫色, "奇蹟", "笑臉+1;文化生產+4", "0"));
        cards.add(new Card(1124, "防禦卡", 2, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+4;殖民時殖民點數+2", "0"));
        cards.add(new Card(1125, "富饒之土", 2, 內政, 行動, 黃色, "行動", "提供3資源建造農場或是礦山", "0"));
        cards.add(new Card(1126, "富饒肥沃之地", 2, 軍事, 事件, 淺綠色, "領土", "黃點+4;食物+5", "0"));
        cards.add(new Card(1127, "工程天才", 2, 內政, 行動, 黃色, "行動", "提供4資源建造奇蹟", "0"));
        cards.add(new Card(1128, "巴哈", 2, 內政, 領袖, 綠色, "領袖", "打出劇院成本-1;建造劇院成本-1;劇院文化生產+1", "0"));
        cards.add(new Card(1129, "市民暴動", 2, 軍事, 事件, 深綠色, "事件", "每一個不快樂的工人-4文化", "0"));
        cards.add(new Card(1130, "庫克船長", 2, 內政, 領袖, 綠色, "領袖", "獎勵卡殖民+1;文化生產+殖民地數量*2", "0"));
        cards.add(new Card(1131, "建築學", 2, 內政, 科技, 藍色, "建築", "當你建造以及預計升級建築物;1級減免1;2級減免2;3級減免2", "0"));
        cards.add(new Card(1132, "建築工地", 2, 內政, 行動, 黃色, "行動", "提供3資源建造非農場或礦山的建築", "0"));
        cards.add(new Card(1133, "恐怖主義", 2, 軍事, 事件, 深綠色, "事件", "分數最低的玩家;選擇摧毀其他玩家的一個城市建築物", "0"));
        cards.add(new Card(1134, "戰略", 2, 內政, 科技, 藍色, "軍事", "軍力+3;軍事點數+2", "0"));
        cards.add(new Card(1135, "拿破崙", 2, 內政, 領袖, 綠色, "領袖", "軍力+你的陣型戰鬥力", "0"));
        cards.add(new Card(1136, "拿破崙陣型", 2, 軍事, 戰術, 深紅色, "戰術", "步馬炮8(4)", "0"));
        cards.add(new Card(1137, "掠奪", 2, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2;對象玩家;失去資源和食物共5;你獲得相同資源食物", "0"));
        cards.add(new Card(1139, "文化戰爭", 2, 軍事, 戰爭, 黑色, "戰爭", "戰敗方:失去軍力差的文化值;戰勝方:獲取軍力差的文化值", "0"));
        cards.add(new Card(1140, "新聞業", 2, 內政, 科技, 灰色, "圖書館", "科技生產+2;文化生產+2", "0"));
        cards.add(new Card(1141, "時間的洪流", 2, 軍事, 事件, 深綠色, "事件", "每個玩家選擇自己的一個奇蹟效果變成;文化生產+2", "0"));
        cards.add(new Card(1142, "有人居住之地", 2, 軍事, 事件, 淺綠色, "領土", "黃點+3;生產2個黃點", "0"));
        cards.add(new Card(1143, "機動部隊", 2, 軍事, 戰術, 深紅色, "戰術", "馬炮+5", "0"));
        cards.add(new Card(1144, "歌劇", 2, 內政, 科技, 灰色, "劇院", "笑臉+1;文化生產+3", "0"));
        cards.add(new Card(1145, "民族主義浪潮", 2, 內政, 行動, 黃色, "行動", "如果你的軍力最低得到6礦;", "0"));
        cards.add(new Card(1146, "民族的自豪", 2, 軍事, 事件, 深綠色, "事件", "文化最高的玩家;文化+5", "0"));
        cards.add(new Card(1147, "洲際鐵路", 2, 內政, 奇蹟, 紫色, "奇蹟", "軍力+5;生產", "0"));
        cards.add(new Card(1148, "火槍兵", 2, 內政, 科技, 紅色, "步兵", "軍力+3", "0"));
        cards.add(new Card(1149, "火砲", 2, 內政, 科技, 紅色, "炮兵", "軍力+3", "0"));
        cards.add(new Card(1150, "煤礦", 2, 內政, 科技, 棕色, "礦山", "資源生產+3", "0"));
        cards.add(new Card(1151, "愛國主義", 2, 內政, 行動, 黃色, "行動", "軍事點數+1;提供3資源用於建造或升級軍隊", "0"));
        cards.add(new Card(1152, "牛頓", 2, 內政, 領袖, 綠色, "領袖", "當你打出科技牌時;回收一個內政點數。科技生產值=你最高實驗室的等級", "0"));
        cards.add(new Card(1153, "物資豐富之地", 2, 軍事, 事件, 淺綠色, "領土", "藍點+3;資源+8", "0"));
        cards.add(new Card(1154, "獨立宣言", 2, 軍事, 事件, 深綠色, "事件", "軍力最低者;選擇自己一個殖民地失去", "0"));
        cards.add(new Card(1155, "胸甲騎兵", 2, 內政, 科技, 紅色, "騎兵", "軍力+3", "0"));
        cards.add(new Card(1156, "礦藏", 2, 內政, 行動, 黃色, "行動", "資源+3", "0"));
        cards.add(new Card(1157, "破壞", 2, 軍事, 侵略, 深棕色, "侵略", "軍事點數[-依照對象奇蹟等級];移除奇蹟;你獲得奇蹟等級*3文化", "0"));
        cards.add(new Card(1158, "科學方法", 2, 內政, 科技, 灰色, "實驗室", "科技生產+3", "0"));
        cards.add(new Card(1160, "科技戰爭", 2, 軍事, 戰爭, 黑色, "戰爭", "戰敗方:失去軍力差的科技值;戰勝方:獲取軍力差的科技值", "0"));
        cards.add(new Card(1161, "科技領先之地", 2, 軍事, 事件, 淺綠色, "領土", "黃點+2;藍點+2;科技+5", "0"));
        cards.add(new Card(1162, "科普教育", 2, 軍事, 事件, 深綠色, "事件", "+文化=科技生產", "0"));
        cards.add(new Card(1163, "移民出境", 2, 軍事, 事件, 深綠色, "事件", "失去一半的工人區(向下取整)", "0"));
        cards.add(new Card(1164, "突破", 2, 內政, 行動, 黃色, "行動", "支付正常打出科技後;獲得4科技", "0"));
        cards.add(new Card(1165, "突襲", 2, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2;拆除對象目標建築物共2個;你獲得建造向下取整的一半資源", "0"));
        cards.add(new Card(1166, "組織化宗教", 2, 內政, 科技, 灰色, "神廟", "笑臉+3;文化生產+1", "0"));
        cards.add(new Card(1167, "經濟發展", 2, 軍事, 事件, 深綠色, "事件", "每個玩家生產資源以及食物(會執行腐敗)", "0"));
        cards.add(new Card(1168, "羅伯斯比爾", 2, 內政, 領袖, 綠色, "領袖", "你的革命改為消耗軍事點數", "0"));
        cards.add(new Card(1169, "罪惡之都", 2, 軍事, 事件, 深綠色, "事件", "軍力最低的玩家失去3分", "0"));
        cards.add(new Card(1170, "航海術", 2, 內政, 科技, 藍色, "殖民", "殖民點數+4;軍力+3", "0"));
        cards.add(new Card(1171, "藝術作品", 2, 內政, 行動, 黃色, "行動", "文化+4", "0"));
        cards.add(new Card(1172, "節儉", 2, 內政, 行動, 黃色, "行動", "支付正常價格擴充人口後;獲得3食物", "0"));
        cards.add(new Card(1173, "莎士比亞", 2, 內政, 領袖, 綠色, "領袖", "圖書館文化生產+1;圖書館+劇院文化生產改為+2", "0"));
        cards.add(new Card(1174, "西班牙陣型", 2, 軍事, 戰術, 深紅色, "戰術", "步馬馬5(3)", "0"));
        cards.add(new Card(1175, "資源戰爭", 2, 軍事, 戰爭, 黑色, "戰爭", "戰敗方:失去軍力差的資源值;戰勝方:獲取軍力差的資源值", "0"));
        cards.add(new Card(1176, "遠洋客運", 2, 內政, 奇蹟, 紫色, "奇蹟", "特殊行動:執行一次生產黃點的行動;少花5食物", "0"));
        cards.add(new Card(1177, "選種培育", 2, 內政, 科技, 棕色, "農場", "食物生產+3", "0"));
        cards.add(new Card(1178, "間諜", 2, 軍事, 侵略, 深棕色, "侵略", "軍事點數-1;對象玩家科技-5;你獲得科技+5", "0"));
        cards.add(new Card(1179, "防禦工事", 2, 軍事, 戰術, 深紅色, "戰術", "炮炮4", "0"));
        cards.add(new Card(1180, "防禦陣型", 2, 軍事, 戰術, 深紅色, "戰術", "步步炮+6", "0"));
        cards.add(new Card(1181, "難民", 2, 軍事, 事件, 深綠色, "事件", "軍力最高文化+3+1人口;軍力最低文化-3-1人口", "0"));
        cards.add(new Card(1182, "革新思想", 2, 內政, 行動, 黃色, "行動", "科技+3", "0"));
        cards.add(new Card(1183, "領土戰爭", 2, 軍事, 戰爭, 黑色, "戰爭", "戰敗方:失去3/軍力差+1的黃點;戰勝方:獲取相同黃點", "0"));
        cards.add(new Card(1184, "高效升級", 2, 內政, 行動, 黃色, "行動", "升級農場;礦山少支付3點資源", "0"));
        cards.add(new Card(1185, "F14", 3, 內政, 領袖, 綠色, "領袖", "你的實驗室;科技生產-1;文化生產=實驗室的總等級", "0"));
        cards.add(new Card(1186, "邱吉爾", 3, 內政, 領袖, 綠色, "領袖", "紅色科技牌打出成本-3;被宣戰建造軍隊資源-2;被侵略防禦卡效果*2", "0"));
        cards.add(new Card(1188, "豐收", 3, 內政, 行動, 黃色, "行動", "食物+4", "0"));
        cards.add(new Card(1189, "人口的影響", 3, 軍事, 事件, 深綠色, "事件", "每個玩家獲得(人數-10)*2的文化", "0"));
        cards.add(new Card(1190, "公共服務", 3, 內政, 科技, 藍色, "內政", "內政點數+2;藍點+3", "10"));
        cards.add(new Card(1191, "共產主義", 3, 內政, 科技, 橙色, "政府", "內政點數+7;軍事點數+6;笑臉-1", "0"));
        cards.add(new Card(1193, "軍事建設", 3, 內政, 行動, 黃色, "行動", "如果你的軍力最低得到8礦", "0"));
        cards.add(new Card(1194, "軍事倫理", 3, 內政, 科技, 藍色, "軍事", "軍力+5;軍事點數+3", "0"));
        cards.add(new Card(1195, "軍力的影響", 3, 軍事, 事件, 深綠色, "事件", "軍力最高玩家+10文化", "0"));
        cards.add(new Card(1196, "農業的影響", 3, 軍事, 事件, 深綠色, "事件", "+文化=你得食物生產總量", "0"));
        cards.add(new Card(1197, "衛星", 3, 內政, 科技, 藍色, "殖民", "殖民點數+3;軍力+2", "0"));
        cards.add(new Card(1198, "歷史進程的影響", 3, 軍事, 事件, 深綠色, "事件", "文化+(政府等級+特殊科技等級)*2", "0"));
        cards.add(new Card(1199, "原教旨主義", 3, 內政, 科技, 橙色, "政府", "內政點數+6;軍事點數+5;軍力+5", "0"));
        cards.add(new Card(1201, "因特網", 3, 內政, 奇蹟, 紫色, "奇蹟", "建造完成後;文化+(實驗室+圖書館)總等級", "0"));
        cards.add(new Card(1203, "聖戰", 3, 軍事, 戰爭, 黑色, "戰爭", "戰敗方:失去3/軍力差人口;戰勝方:戰敗方失去的每個人口獲得三點文化 ", "0"));
        cards.add(new Card(1204, "甘地", 3, 內政, 領袖, 綠色, "領袖", "文化生產+2;侵略戰爭需要花費的紅點*2;你不能侵略或是戰爭", "0"));
        cards.add(new Card(1205, "坦克", 3, 內政, 科技, 紅色, "騎兵", "軍力+5", "0"));
        cards.add(new Card(1206, "多媒體", 3, 內政, 科技, 灰色, "圖書館", "科技生產+3;文化生產+3", "0"));
        cards.add(new Card(1207, "奇蹟的影響", 3, 軍事, 事件, 深綠色, "事件", "自己擁有的A/I/II/III的奇蹟獲得5/3/2/1分", "0"));
        cards.add(new Card(1208, "防禦卡", 3, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+6;殖民時殖民點數+3", "0"));
        cards.add(new Card(1209, "好萊烏", 3, 內政, 奇蹟, 紫色, "奇蹟", "建造完成後;文化+(劇院等級+圖書館等級)*2", "0"));
        cards.add(new Card(1210, "尼古拉特斯拉", 3, 內政, 領袖, 綠色, "領袖", "資源生產+實驗室等級總量", "0"));
        cards.add(new Card(1211, "工業的影響", 3, 軍事, 事件, 深綠色, "事件", "文化+(資源生產)", "0"));
        cards.add(new Card(1212, "工程天才", 3, 內政, 行動, 黃色, "行動", "提供5資源建造奇蹟", "0"));
        cards.add(new Card(1213, "工程學", 3, 內政, 科技, 藍色, "建築", "當你建造以及預計升級建築物;1級減免1;2級減免2;3級減免3", "0"));
        cards.add(new Card(1214, "幸福的影響", 3, 軍事, 事件, 深綠色, "事件", "每個笑臉+2文化(最多給16文化)", "0"));
        cards.add(new Card(1215, "建築工地", 3, 內政, 行動, 黃色, "行動", "提供4資源建造非農場或礦山的建築", "0"));
        cards.add(new Card(1216, "建築的影響", 3, 軍事, 事件, 深綠色, "事件", "獲得每個黃點建築物等級的分數", "0"));
        cards.add(new Card(1217, "快餐連鎖", 3, 內政, 奇蹟, 紫色, "奇蹟", "建造完成後;每1個工作黃點得1分;農場礦山的黃點在得1分", "0"));
        cards.add(new Card(1218, "戰壕", 3, 軍事, 戰術, 深紅色, "戰術", "步炮炮+9(5)", "0"));
        cards.add(new Card(1219, "技術的影響", 3, 軍事, 事件, 深綠色, "事件", "文化+III等科技牌*4", "0"));
        cards.add(new Card(1220, "掠奪", 3, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2;對象玩家;失去資源和食物共8;你獲得相同資源食物", "0"));
        cards.add(new Card(1221, "政府的影響", 3, 軍事, 事件, 深綠色, "事件", "獲得(政府+特殊科技)*2的文化", "0"));
        cards.add(new Card(1222, "文化戰爭", 3, 軍事, 戰爭, 黑色, "戰爭", "戰敗方:失去軍力差的文化值;戰勝方:獲取軍力差的文化值", "0"));
        cards.add(new Card(1223, "機械化農業", 3, 內政, 科技, 棕色, "農場", "食物生產+5", "0"));
        cards.add(new Card(1224, "機械化部隊", 3, 軍事, 戰術, 深紅色, "戰術", "馬炮炮+10(5)", "0"));
        cards.add(new Card(1225, "武裝入侵", 3, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2;對象文化-7;你獲得文化+7", "0"));
        cards.add(new Card(1226, "殖民地的影響", 3, 軍事, 事件, 深綠色, "事件", "殖民地*4文化", "0"));
        cards.add(new Card(1227, "民主制", 3, 內政, 科技, 橙色, "政府", "內政點數+8;軍事點數+3;文化生產+2", "0"));
        cards.add(new Card(1228, "火箭", 3, 內政, 科技, 紅色, "炮兵", "軍力+5", "0"));
        cards.add(new Card(1229, "愛因斯坦", 3, 內政, 領袖, 綠色, "領袖", "當你打出科技牌時;獲得文化+3。科技生產值=你最高實驗室的等級", "0"));
        cards.add(new Card(1230, "愛國主義", 3, 內政, 行動, 黃色, "行動", "軍事點數+1;提供4資源用於建造或升級軍隊", "0"));
        cards.add(new Card(1231, "現代化步兵", 3, 內政, 科技, 紅色, "步兵", "軍力+5", "0"));
        cards.add(new Card(1232, "現代化軍隊", 3, 軍事, 戰術, 深紅色, "戰術", "步步馬炮13(7)", "0"));
        cards.add(new Card(1233, "電影", 3, 內政, 科技, 灰色, "劇院", "笑臉+1;文化生產+4", "0"));
        cards.add(new Card(1234, "石油", 3, 內政, 科技, 棕色, "礦山", "資源生產+5", "0"));
        cards.add(new Card(1235, "礦床", 3, 內政, 行動, 黃色, "行動", "資源+4", "0"));
        cards.add(new Card(1236, "科學的影響", 3, 軍事, 事件, 深綠色, "事件", "科技生產最高玩家+10文化", "0"));
        cards.add(new Card(1237, "空軍", 3, 內政, 科技, 紅色, "空軍", "軍力+5;配合一個完整的陣型;使陣型效果*2", "0"));
        cards.add(new Card(1238, "空間飛行", 3, 內政, 奇蹟, 紫色, "奇蹟", "建造完成後;獲得每張科技牌等級的分數", "0"));
        cards.add(new Card(1239, "突襲", 3, 軍事, 侵略, 深棕色, "侵略", "軍事點數-3;拆除對象目標建築物共3個;你獲得建造向下取整的一半資源", "0"));
        cards.add(new Card(1240, "競爭力的影響", 3, 軍事, 事件, 深綠色, "事件", "文化+(軍隊總等級+競技場總等級)", "0"));
        cards.add(new Card(1241, "約翰藍儂", 3, 內政, 領袖, 綠色, "領袖", "笑臉+2;最高等級劇院文化生產*2", "0"));
        cards.add(new Card(1242, "藝術作品", 3, 內政, 行動, 黃色, "行動", "文化+3", "0"));
        cards.add(new Card(1243, "藝術捐獻", 3, 內政, 行動, 黃色, "行動", "如果你的文化值最低+6文化", "0"));
        cards.add(new Card(1244, "計算機", 3, 內政, 科技, 灰色, "實驗室", "科技生產+5", "0"));
        cards.add(new Card(1245, "閃電戰", 3, 軍事, 戰術, 深紅色, "戰術", "步馬馬馬11(6)", "0"));
        cards.add(new Card(1246, "革命性理念", 3, 內政, 行動, 黃色, "行動", "科技+4", "0"));
        cards.add(new Card(1247, "高效升級", 3, 內政, 行動, 黃色, "行動", "升級農場;礦山少支付4點資源", "0"));

    }

}
