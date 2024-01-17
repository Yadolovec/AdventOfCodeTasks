package com.some.app.EmptyApp.Advent2023.Day4;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 15.01.2024
 **/
public class Task2 {

    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day4t");
        list = list.stream().map(x -> x.split(":")[1]).collect(Collectors.toList());

        int answer = 0;
        for (String line : list) {
            int powerAnswer = -1;
            String[] sArray = line.split("\\|");
            Set<Integer> winningNumbersSet = new HashSet<>(extractNumbers(sArray[0]));
            List<Integer> numbers = extractNumbers(sArray[1]);

            for (Integer i : numbers) {
                if (winningNumbersSet.contains(i)) {
                    powerAnswer += 1;
                }
            }

            answer += powerAnswer == -1 ? 0 : Math.pow(2, powerAnswer);

        }

        System.out.println(answer);


    }

    public static List<Integer> extractNumbers(String s) {
        List<Integer> toReturn = new ArrayList<>();
        String[] sArray = s.split(" ");
        for (String number : sArray) {
            if (!number.equals("") && !number.equals(" ")) {
                toReturn.add(Integer.parseInt(number));
            }
        }

        return toReturn;
    }
}
