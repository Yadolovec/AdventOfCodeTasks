package com.some.app.EmptyApp.NinethDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    static int counter = 1;
    static int yHead = 0;
    static int xHead = 0;
    static int yTail = 0;
    static int xTail = 0;
    static List<int[]> wasThere = new ArrayList<>();
    static {
        wasThere.add(new int[]{0,0});
    }

    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/NinthDay.txt");

        for (String s : list){
            doInstruction(s);
        }

        System.out.println(counter);


    }

    public static void doInstruction(String s){
        String[] directionAndSteps = s.split(" ");
        makeSteps(directionAndSteps);

    }

    public static void makeSteps(String[] directionAndStep){

        String direction = directionAndStep[0];
        int steps = Integer.parseInt(directionAndStep[1]);


        for (int i = 0; i<steps; i++){
            doStep(direction);
        }

    }



    public static void doStep(String direction){
        if (direction.equals("R"))
            xHead++;
        if (direction.equals("L"))
            xHead--;
        if (direction.equals("D"))
            yHead--;
        if (direction.equals("U"))
            yHead++;

        if (tooFar()){
            if (xTail == xHead){
                if (yHead-yTail>0){
                    yTail++;
                } else {
                    yTail--;
                }
            } else if (yTail == yHead) {
                if (xHead - xTail > 0) {
                    xTail++;
                } else {
                    xTail--;
                }
            } else {
                if (xHead>xTail){
                    xTail++;
                } else {
                    xTail--;
                }
                if (yHead>yTail){
                    yTail++;
                } else {
                    yTail--;
                }
            }

            for (int[] a : wasThere){
                if (a[0] == yTail && a[1] == xTail){
                    return;
                }
            }

            wasThere.add(new int[]{yTail, xTail});
            counter++;
        }



    }
    public static boolean tooFar(){
        return (Math.abs(xHead - xTail) > 1) || (Math.abs(yHead - yTail) > 1);
    }
}
