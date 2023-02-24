package com.some.app.EmptyApp.TenthDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.List;
import java.util.Map;


public class Task2 {
    static int acc = 1;
    static int answer = 0;
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/TenthDay.txt");
        int[] adding = new int[list.size()*2];
        int cycle = 0;
        for(String s : list){
            int toAdd = 0;
            if (s.startsWith("addx ")){
                toAdd = Integer.parseInt(s.substring(5));
                cycle++;
                check(cycle);
            }

            cycle++;
            check(cycle);
            acc = acc + toAdd;

        }

        System.out.println("\n"+answer);
    }

    public static void check(int cycle){
        int workingCycle = cycle%40;
        if (workingCycle>=acc&&workingCycle<=acc+2) {
            System.out.print('#');
        } else {
            System.out.print('.');
        }
        for (int i = 40; i<=220; i+=40){
            if (i==cycle){
                answer+=cycle*acc;
                System.out.println();
                return;
            }
        }
    }
}
