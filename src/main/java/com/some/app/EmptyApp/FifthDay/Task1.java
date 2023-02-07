package com.some.app.EmptyApp.FifthDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/FifthDay.txt");

        int highOfStack = getHighOfStuck(list);
        int numberOfStacks = getNumberOfStacks(list, highOfStack);
        int instructionStart = highOfStack+2;

        int[][] instruction = createInstruction(list, instructionStart);
        Character[][] cratesTable = createCratesTable(list, highOfStack, numberOfStacks);



        showInstruction(instruction);
        showCrates(cratesTable);

        for (int[] instr : instruction){
            cratesTable = moveAsInstructionSaid(cratesTable, instr);
        }


        showCrates(cratesTable);

        for (int i = 0; i<cratesTable[0].length; i++)
            System.out.print(cratesTable[indexOfTop(cratesTable, i)][i]);
    }

    public static Character[][] moveAsInstructionSaid(Character[][] cratesTable, int[] instruction){
        int quantity = instruction[0];
        int from = instruction[1];
        int to = instruction[2];

        for (int i = 0; i < quantity; i++){
            cratesTable[indexOfTop(cratesTable, to)+1][to]=cratesTable[indexOfTop(cratesTable, from)][from];
            cratesTable[indexOfTop(cratesTable, from)][from]=' ';
        }
        return cratesTable;

    }

    public static void showInstruction(int[][] instruction){
        for (int i = 0; i < instruction.length; i++) {
            System.out.println(instruction[i][0] + " from " + instruction[i][1] + " to " + instruction[i][2]);
        }
        System.out.println();

    }

    public static void showCrates(Character[][] cratesTable){
        int highestPoint = 0;
        for (int i = 0; i < cratesTable[0].length; i++){
            if (indexOfTop(cratesTable, i)>highestPoint) {
                highestPoint = indexOfTop(cratesTable, i);
            }
        }

        for (int i = highestPoint; i>=0; i--) {
            System.out.print(i+" ");
            for (int j = 0; j < cratesTable[i].length; j++) {
                if (cratesTable[i][j]==null)
                    cratesTable[i][j]=' ';
                System.out.print(cratesTable[i][j]);
            }
            System.out.println();
        }
        System.out.print("  ");
        for(int i = 0; i<cratesTable[0].length; i++){
            System.out.print(i);
        }
        System.out.println();
        System.out.println();

    }
    public static int indexOfTop(Character[][] cratesTable, int numberOfStack){

        int index = cratesTable.length-1;
        while((cratesTable[index][numberOfStack]==null||cratesTable[index][numberOfStack]==' ')&&(index>=0)){
            index--;
            if (index==-1)
                return index;
        }


        return index;
    }

    public static Character[][] createCratesTable(List<String> list, int highOfStack, int numberOfStacks){
        Character[][] tableToReturn = new Character[highOfStack*9][numberOfStacks];
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
            instruction[high][1] = Integer.parseInt(sArray[0])-1;
            instruction[high][2] = Integer.parseInt(sArray[1])-1;
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
