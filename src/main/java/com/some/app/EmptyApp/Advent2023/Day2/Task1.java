package com.some.app.EmptyApp.Advent2023.Day2;

import com.some.app.EmptyApp.util.Utils;

import java.util.List;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 08.01.2024
 **/
public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day2");

        int redLimit = 12;
        int greenLimit = 13;
        int blueLimit = 14;

        int answer = 0;

        for (int i = 0; i < list.size(); i++) {
            boolean isValid = true;
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
                        if ((round.contains("red") && cubes > redLimit)
                                || (round.contains("green") && cubes > greenLimit)
                                || (round.contains("blue") && cubes > blueLimit)) {
                            isValid = false;
                        }
                    }
                }
            }

            if (isValid) {
                answer += i + 1;
            }
        }

        System.out.println(answer);

    }
}
