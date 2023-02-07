package com.some.app.EmptyApp.FifthDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Test/Data5");

        int highOfStack = getHighOfStuck(list);
        int numberOfStacks = getNumberOfStacks(list, highOfStack);
        int instructionStart = highOfStack+2;

        int[][] instruction = createInstruction(list, instructionStart);
        char[][] cratesTable = createCratesTable(list, highOfStack, numberOfStacks);



        showInstruction(instruction);
        showCrates(cratesTable);

    }

    public static void showInstruction(int[][] instruction){
        for (int i = 0; i < instruction.length; i++) {
            System.out.println(instruction[i][0] + " from " + instruction[i][1] + " to " + instruction[i][2]);
        }
    }

    public static void showCrates(char[][] cratesTable){
        for (int i = cratesTable.length-1; i>=0; i--) {
            for (int j = 0; j < cratesTable[i].length; j++) {
                System.out.print(cratesTable[i][j]);
            }
            System.out.println();
        }
    }
    public static int indexOfTop(char[][] cratesTable){
        int index = 0;
        for (int i = 0; i<cratesTable[0].length; i++ ){

        }
        return index;
    }

    public static char[][] createCratesTable(List<String> list, int highOfStack, int numberOfStacks){
        char[][] tableToReturn = new char[highOfStack*2][numberOfStacks];
        String s;
        for (int i = highOfStack-1; i >= 0; i--) {
            s = list.get(highOfStack-i-1);
            for (int j = 0; j < numberOfStacks; j++) {
                int characterNumber = j * 4 + 1; //find it by empyric
                if (characterNumber < s.length()) {
                    tableToReturn[i][j] = s.charAt(characterNumber);
                } else {
                    tableToReturn[i][j] = ' ';
                }
            }
        }
        return tableToReturn;
    }

    public static int[][] createInstruction(List<String> list, int instructionStart){
        int[][] instruction = new int[list.size() - instructionStart][3];
        int high = 0;
        String s;
        String[] sArray;

        for (int i = instructionStart; i < list.size(); i++) {
            s = list.get(i).substring(5);
                sArray = s.split(" from ");
            instruction[high][0] = Integer.parseInt(sArray[0]);
                sArray = sArray[1].split(" to ");
            instruction[high][1] = Integer.parseInt(sArray[0]);
            instruction[high][2] = Integer.parseInt(sArray[1]);
            high++;
        }
        return instruction;
    }

    public static int getHighOfStuck(List<String> list){
        int highOfStack = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith(" 1   2   3")) {
                highOfStack = i;
                break;
            }
        }
        return highOfStack;
    }

    public static int getNumberOfStacks(List<String> list, int highOfStack){
        String s = list.get(highOfStack);
        return Integer.parseInt(s.substring((s.length() - 1), (s.length())));
    }
}
