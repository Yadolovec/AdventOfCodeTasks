package com.some.app.EmptyApp.FifthDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Test/Data5");
        List<String> crates = new ArrayList<>();
        List<int[]> instruction = new ArrayList<>();
        String[] sArray;

        int highOfStack = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith(" 1   2   3")) {
                highOfStack = i;
                break;
            }
            crates.add(list.get(i));
        }

        for (int i = 0; i < highOfStack; i++){
            System.out.println(crates.get(i));
        }

        int instructionStart = highOfStack;

        String s = list.get(instructionStart);
        int numberOfStacks = Integer.parseInt(s.substring((s.length() - 1), (s.length())));

        instructionStart += 2;

        int[] array = new int[3];
        for (int i = instructionStart; i < list.size(); i++) {
            s = list.get(i).substring(5);

                sArray = s.split(" from ");
            array[0] = Integer.parseInt(sArray[0]);
                sArray = sArray[1].split(" to ");
            array[1] = Integer.parseInt(sArray[0]);
            array[2] = Integer.parseInt(sArray[1]);
            System.out.println(array[0]+" " + array[1] + " " + array[2]);

            instruction.add(array);
        }


    }
}
