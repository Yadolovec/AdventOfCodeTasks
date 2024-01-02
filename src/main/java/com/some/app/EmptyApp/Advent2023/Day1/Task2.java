package com.some.app.EmptyApp.Advent2023.Day1;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 02.01.2024
 **/
public class Task2 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day1t");

        int answer = 0;
        for (String line : list) {
            line = wordsToDigits(line);
            char[] letters = line.toCharArray();
            for (int i = line.length() - 1; i >= 0; i--) {
                if (Character.isDigit(letters[i])) {
                    answer += letters[i] - '0';
                    break;
                }
            }

            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(letters[i])) {
                    answer += (letters[i] - '0') * 10;
                    break;
                }
            }

        }
        System.out.println(answer);

    }

    public static String wordsToDigits(String line) {
        List<String> digitsNames = new ArrayList<>();
        digitsNames.add("one");
        digitsNames.add("two");
        digitsNames.add("three");
        digitsNames.add("four");
        digitsNames.add("five");
        digitsNames.add("six");
        digitsNames.add("seven");
        digitsNames.add("eight");
        digitsNames.add("nine");

        int minStart = -1;
        int maxStart = -1;

        for (String digit : digitsNames) {
            if (line.contains(digit)) {
                minStart = minStart == -1 ? line.indexOf(digit) : -1;
                maxStart = maxStart == -1 ? line.lastIndexOf(digit) : -1;

                minStart = minStart < line.indexOf(digit) ? line.indexOf(digit) : -1;
                maxStart = maxStart == -1 ? line.lastIndexOf(digit) : -1;
            }
        }
        return


    }


}
