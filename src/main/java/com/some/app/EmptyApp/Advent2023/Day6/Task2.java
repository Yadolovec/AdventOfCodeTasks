package com.some.app.EmptyApp.Advent2023.Day6;

import com.some.app.EmptyApp.util.Utils;

import java.util.List;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 07.02.2024
 **/
public class Task2 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day6");
        String[] timeAllowed = list.get(0).split(":")[1].split("\\s+");
        String[] records = list.get(1).split(":")[1].split("\\s+");

        int time = Integer.parseInt(String.join("", timeAllowed));
        long record = Long.parseLong(String.join("", records));

        int answer = 1;

        long acc = 0;
        for (long j = 0; j < time; j++) {

            long speed = j;
            long timeLeft = time - speed;

            if (timeLeft * speed > record) {
                acc++;
            }
        }

        answer *= acc;


        System.out.println(answer);

    }

}
