package com.some.app.EmptyApp.Advent2023.Day1;

import com.some.app.EmptyApp.util.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 02.01.2024
 **/
public class Task2 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day1");

        int answer = 0;
        for (String line : list) {
            String newLine = wordsToDigits(line);
            System.out.println(newLine);
            char[] letters = newLine.toCharArray();

            for (int i = newLine.length() - 1; i >= 0; i--) {
                if (Character.isDigit(letters[i])) {
                    answer += letters[i] - '0';
                    break;
                }
            }

            for (int i = 0; i < newLine.length(); i++) {
                if (Character.isDigit(letters[i])) {
                    answer += (letters[i] - '0') * 10;
                    break;
                }
            }

        }
        System.out.println(answer);

    }

    public static String wordsToDigits(String line) {
        Map<String, Integer> nameToDigit = new HashMap<>();

        nameToDigit.put("one", 1);
        nameToDigit.put("two", 2);
        nameToDigit.put("three", 3);
        nameToDigit.put("four", 4);
        nameToDigit.put("five", 5);
        nameToDigit.put("six", 6);
        nameToDigit.put("seven", 7);
        nameToDigit.put("eight", 8);
        nameToDigit.put("nine", 9);

        int indexFirst = Integer.MAX_VALUE;
        String firstDigit = "";
        for (String digit : nameToDigit.keySet()) {
            if (line.contains(digit)) {
                if (line.indexOf(digit) < indexFirst) {
                    indexFirst = line.indexOf(digit);
                    firstDigit = digit;
                }
            }
        }
        if (!firstDigit.equals(""))
            line = line.replaceFirst(firstDigit, nameToDigit.get(firstDigit) + firstDigit);

        line = new StringBuilder(line).reverse().toString();
        String lastDigit = "";
        String reverseLastDigit = "";
        int indexLast = Integer.MAX_VALUE;
        for (String digit : nameToDigit.keySet()) {
            String reverseDigit = new StringBuilder(digit).reverse().toString();

            if (line.contains(reverseDigit)) {
                if (line.indexOf(reverseDigit) < indexLast) {
                    indexLast = line.indexOf(reverseDigit);
                    reverseLastDigit = reverseDigit;
                    lastDigit = digit;
                }
            }
        }

        if (!lastDigit.equals(""))
            line =  line.replaceFirst(reverseLastDigit, nameToDigit.get(lastDigit) + reverseLastDigit);

        return new StringBuilder(line).reverse().toString();
    }


}
