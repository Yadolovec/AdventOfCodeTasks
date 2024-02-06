package com.some.app.EmptyApp.Advent2023.Day6;

import com.some.app.EmptyApp.util.Utils;

import java.util.Arrays;
import java.util.List;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 05.02.2024
 **/
public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day6");
        int[] timeAllowed = Arrays.stream(list.get(0).split(":")[1].split("\\s+")).filter(x -> !x.equals("")).mapToInt(Integer::parseInt).toArray();
        int[] records = Arrays.stream(list.get(1).split(":")[1].split("\\s+")).filter(x -> !x.equals("")).mapToInt(Integer::parseInt).toArray();

        int answer = 1;

        for (int i = 0; i<timeAllowed.length; i++){
            int acc = 0;
            int time = timeAllowed[i];
            for (int j = 0; j<time; j++){

                int speed = j;
                int timeLeft = time - speed;

                if (timeLeft*speed > records[i]){
                    acc++;
                }
            }

            answer*=acc;
        }

        System.out.println(answer);

    }

}
