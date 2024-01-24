package com.some.app.EmptyApp.Advent2023.Day5;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

            String s = list.get(i);
            if (s.contains(":") && i != from) {
                to = i;
                if (from == 0) {
                    seeds = extractNumbers(list, from, to);
                } else {
                    // +1 and -2 are for empty spaces
                    followInstructions(seeds, extractNumbers(list, from + 1, to - 2));

                }
            }

            from = to;
        }


        System.out.println(seeds.stream().reduce(Long::min));
    }

    public static List<Long> followInstructions(List<Long> seeds, List<Long> instruction) {

        Set<Integer> alreadyUsed = new HashSet<>();
        for (int i = 0; i < instruction.size(); i += 3) {
            long correspondingValue = instruction.get(i);
            long start = instruction.get(i + 1);
            long quantity = instruction.get(i + 2);

            for (int j = 0; j < seeds.size(); j++) {
                long seed = seeds.get(j);
                if (seed >= start && seed < start + quantity && !alreadyUsed.contains(j)) {
                    seeds.set(j, correspondingValue + seed - start);
                    alreadyUsed.add(j);
                }
            }
        }

        return seeds;

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
