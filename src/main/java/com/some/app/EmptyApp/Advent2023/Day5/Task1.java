package com.some.app.EmptyApp.Advent2023.Day5;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 19.01.2024
 **/
public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day5");

        int from = 0;
        int to = 0;

        List<Long> seeds = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            Map<Long, Long> instructions = new HashMap<>();
            String s = list.get(i);
            if (s.contains(":") && i != from) {
                to = i;
                if (from == 0) {
                    seeds = extractNumbers(list, from, to);
                } else {
                    // +1 and -2 are for empty spaces
                    instructions = extractInstructionsLine(extractNumbers(list, from + 1, to - 2));
                    Map<Long, Long> finalInstructions = instructions;
                    seeds = seeds.stream().map(x -> x = finalInstructions.getOrDefault(x, x)).collect(Collectors.toList());

                    for (int j = 0; j < list.size(); j++) {
                        long seed = seeds.get(j);
                        long toAdd = instructions.containsKey(seed) ? instructions.get(seed) : seed;
                        seeds.add(j, toAdd);
                    }
                }
            }

            from = to;
        }


        System.out.println(seeds.stream().reduce(Long::min));
    }

    public static Map<Long, Long> extractInstructionsLine(List<Long> instruction) {
        Map<Long, Long> toReturn = new HashMap<>();

        for (int i = 0; i < instruction.size(); i += 3) {
            long startIndex = instruction.get(i);
            long correspondingValue = instruction.get(i + 1);
            long changeQuantity = instruction.get(i + 2);

            for (int j = 0; j < changeQuantity; j++) {

                toReturn.put(correspondingValue + j, j + startIndex);
            }
        }

        return toReturn;
    }

    public static List<Long> extractNumbers(List<String> list, int from, int to) {
        List<Long> toReturn = new ArrayList<>();

        for (int i = from; i <= to; i++) {
            String[] sArray = list.get(i).split(" ");
            for (String s1 : sArray) {
                if (s1.chars().allMatch(Character::isDigit) && !s1.isEmpty()) {
                    toReturn.add(Long.parseLong(s1));
                }
            }
        }

        return toReturn;
    }
}
