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

            char[] charArray = newLine.toCharArray();

            for (int i = 0; i < charArray.length; i++) {
                if (Character.isDigit(charArray[i])) {
                    answer = answer + (charArray[i] - '0') * 10;
                    break;
                }
            }
            for (int i = charArray.length - 1; i >= 0; i--) {
                if (Character.isDigit(charArray[i])) {
                    answer = answer + (charArray[i] - '0');
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
        int indexLast = Integer.MIN_VALUE;
        String firstDigit = "";
        String lastDigit = "";
        for (String digit : nameToDigit.keySet()) {
            if (line.contains(digit)) {
                if (line.indexOf(digit) < indexFirst) {
                    indexFirst = line.indexOf(digit);
                    firstDigit = digit;
                }

                if (line.lastIndexOf(digit) > indexLast) {
                    indexLast = line.lastIndexOf(digit);
                    lastDigit = digit;
                }
            }
        }

        line = line.replaceFirst(firstDigit, nameToDigit.get(firstDigit) + "");
        return line.replaceAll(lastDigit, nameToDigit.get(lastDigit) + "");
    }


}
