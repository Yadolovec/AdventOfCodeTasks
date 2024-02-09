package com.some.app.EmptyApp.Advent2023.Day7;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 08.02.2024
 **/
public class Task1 {

    static Map<String, Integer> cards = new HashMap<>();
    static {
        cards.put("2", 2);
        cards.put("3", 3);
        cards.put("4", 4);
        cards.put("5", 5);
        cards.put("6", 6);
        cards.put("7", 7);
        cards.put("8", 8);
        cards.put("9", 9);
        cards.put("T", 10);
        cards.put("J", 11);
        cards.put("Q", 12);
        cards.put("K", 13);
        cards.put("A", 14);
    }

    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day7t");
        List<Player> players = new ArrayList<>();

        for (String s : list){
            players.add(new Player(s));
        }
    }

    public class Player{

        public Player (String s){
            String[] sArray = s.split(" ");
            this.setBid(Integer.parseInt(sArray[1]));
            sArray =  sArray[0].split("");

            int[] hand = new int[5];
            for (int i = 0; i < sArray.length; i++){
                hand[i] = cards.get(sArray[i]);
            }
            this.setHand(hand);

            this.setRank(calculateRank(hand));
        }
        int bid;
        int[] hand;
        int rank;

        public int getBid() {
            return bid;
        }

        public void setBid(int bid) {
            this.bid = bid;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int[] getHand() {
            return hand;
        }

        public void setHand(int[] hand) {
            this.hand = hand;
        }

        public static int calculateRank(int[] hand){

        }
    }
}
