package com.some.app.EmptyApp.NinethDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    static int counter = 1;
    static int[] yHead = new int[]{0,0,0,0,0,0,0,0,0,0};
    static int[] xHead = new int[]{0,0,0,0,0,0,0,0,0,0};
    static int[] yTail = new int[]{0,0,0,0,0,0,0,0,0,0};
    static int[] xTail = new int[]{0,0,0,0,0,0,0,0,0,0};
    static List<int[]> wasThere = new ArrayList<>();
    static {
        wasThere.add(new int[]{0, 0});
    }

    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Test/NinthDay.txt");
        for (String s : list) {
            doInstruction(s);
            System.out.println(xHead[9]+" "+yHead[9]);
        }
        System.out.println(counter);

        for (int i = 10; i>-6; i--){
            for (int j = -12; j<16; j++){
                char c = '-';
                for (int[] a : wasThere) {
                    if (a[0] == i && a[1] == j) {
                        c = '#';
                        break;
                    }
                }
                System.out.print(c);
            }
            System.out.println();
        }

    }

    public static void doInstruction(String s) {
        String[] directionAndSteps = s.split(" ");
        makeSteps(directionAndSteps);

    }

    public static void makeSteps(String[] directionAndStep) {
        String direction = directionAndStep[0];
        int steps = Integer.parseInt(directionAndStep[1]);

        for (int i = 0; i < steps; i++) {
            doStep(direction);
            for (int j = 0; j < 10; j++) {
                moveTailIfTooFar(j);
            }
        }


    }

    public static void doStep(String direction) {
        if (direction.equals("R"))
            xHead[0]++;
        if (direction.equals("L"))
            xHead[0]--;
        if (direction.equals("D"))
            yHead[0]--;
        if (direction.equals("U"))
            yHead[0]++;
    }

    public static boolean tooFar(int number) {
        return (Math.abs(xHead[number] - xTail[number]) > 1) || (Math.abs(yHead[number] - yTail[number]) > 1);
    }
    public static void moveTailIfTooFar(int number){
        if (tooFar(number)) {
            if (xTail[number] == xHead[number]) {
                if (yHead[number] - yTail[number] > 0) {
                    yTail[number]++;
                } else {
                    yTail[number]--;
                }
            } else if (yTail[number] == yHead[number]) {
                if (xHead[number] - xTail[number] > 0) {
                    xTail[number]++;
                } else {
                    xTail[number]--;
                }
            } else {
                if (xHead[number] > xTail[number]) {
                    xTail[number]++;
                } else {
                    xTail[number]--;
                }
                if (yHead[number] > yTail[number]) {
                    yTail[number]++;
                } else {
                    yTail[number]--;
                }
            }


            if (number != 9){
                xHead[number+1]=xTail[number];
                yHead[number+1]=yTail[number];
            } else {
                for (int[] a : wasThere) {
                    if (a[0] == yHead[9] && a[1] == xHead[9]) {
                        return;
                    }
                }
                wasThere.add(new int[]{yHead[9], xHead[9]});
                counter++;
            }

        }
    }
}
