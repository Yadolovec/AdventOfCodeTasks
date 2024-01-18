package com.some.app.EmptyApp.Advent2023.Day4;

import com.some.app.EmptyApp.util.Utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 15.01.2024
 **/
public class Task2 {

    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day4");
        List<String> l = list;
        list = list.stream().map(x -> x.split(":")[1]).collect(Collectors.toList());

        Map<Integer, Integer> repeatMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            repeatMap.put(i, 1);
        }

        for (int i = 0; i < list.size(); i++) {
            int quantityOfWinnings = 0;
            String line = list.get(i);
            String[] sArray = line.split("\\|");
            Set<Integer> winningNumbersSet = new HashSet<>(extractNumbers(sArray[0]));
            List<Integer> numbers = extractNumbers(sArray[1]);


            for (int number : numbers) {
                if (winningNumbersSet.contains(number))
                    quantityOfWinnings++;
            }

            for (int j = i + 1; j <= i + quantityOfWinnings; j++) {
                if (j < list.size())
                    repeatMap.put(j, repeatMap.get(j) + repeatMap.get(i));
            }
            System.out.println(l.get(i));

        }

        int answer = repeatMap.values().stream().reduce(Integer::sum).get();

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
