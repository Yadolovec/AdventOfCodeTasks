package com.some.app.EmptyApp.Advent2023.Day1;

import com.some.app.EmptyApp.util.Utils;

import java.util.List;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 01.01.2024
 **/
public class Task1 {

    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day1");

        int answer = 0;
        for (String line : list) {
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
}
