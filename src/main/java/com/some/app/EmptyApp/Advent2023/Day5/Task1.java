package com.some.app.EmptyApp.Advent2023.Day5;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 19.01.2024
 **/
public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day5t");

        int from = 0;
        int to = 0;

        Map<Integer, Integer> instructions;
        List<Integer> seeds = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            String s = list.get(i);
            if (s.contains(":") && i != from) {
                to = i;
                if (from == 0) {
                    seeds = extractNumbers(list, from, to);
                } else {
                    // +1 and -2 are for empty spaces
                    instructions = extractInstructionsLine(extractNumbers(list, from + 1, to - 2));
                }
            }

            from = to;
        }

        System.out.println(" ");
    }

    public static Map<Integer, Integer> extractInstructionsLine(List<Integer> instruction) {
        Map<Integer, Integer> toReturn = new HashMap<>();

        for (int i = 0; i < instruction.size(); i += 3) {
            int startIndex = instruction.get(i);
            int correspondingValue = instruction.get(i + 1);
            int changeQuantity = instruction.get(i + 2);

            for (int j = startIndex; j < startIndex + changeQuantity; j++) {
                toReturn.put(j, correspondingValue + (j - startIndex));
            }
        }

        return toReturn;
    }

    public static List<Integer> extractNumbers(List<String> list, int from, int to) {
        List<Integer> toReturn = new ArrayList<>();

        for (int i = from; i <= to; i++) {
            String[] sArray = list.get(i).split(" ");
            for (String s1 : sArray) {
                if (s1.chars().allMatch(Character::isDigit) && !s1.isEmpty()) {
                    toReturn.add(Integer.parseInt(s1));
                }
            }
        }

        return toReturn;
    }
}
