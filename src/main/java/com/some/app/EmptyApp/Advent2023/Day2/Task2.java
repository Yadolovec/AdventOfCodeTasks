package com.some.app.EmptyApp.Advent2023.Day2;

import com.some.app.EmptyApp.util.Utils;

import java.util.List;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 09.01.2024
 **/
public class Task2 {

    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day2");

        int answer = 0;

        for (int i = 0; i < list.size(); i++) {

            int minRed = 0;
            int minGreen = 0;
            int minBlue = 0;

            String allInfo = list.get(i).split(":")[1];
            String[] draws = allInfo.split(";");
            for (String s : draws) {
                String[] gameInfo = s.split(" ");

                int cubes = 0;
                for (int j = 0; j < gameInfo.length; j++) {
                    String round = gameInfo[j];
                    if (j % 2 != 0) {
                        cubes = Integer.parseInt(round);
                    } else {
                        if (round.contains("red") && cubes > minRed) {
                            minRed = cubes;
                        }
                        if (round.contains("green") && cubes > minGreen) {
                            minGreen = cubes;
                        }
                        if (round.contains("blue") && cubes > minBlue) {
                            minBlue = cubes;
                        }
                    }
                }
            }

            answer = answer + minRed * minGreen * minBlue;
        }

        System.out.println(answer);

    }


}