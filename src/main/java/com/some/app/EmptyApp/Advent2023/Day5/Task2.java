package com.some.app.EmptyApp.Advent2023.Day5;

import com.some.app.EmptyApp.util.Utils;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.*;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 26.01.2024
 **/
public class Task2 {

    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day5t");

        int from = 0;
        int to = 0;

        List<Long> seeds = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            String s = list.get(i);
            if ((s.contains(":") && i != from) || i == list.size() - 1) {
                to = i;
                if (from == 0) {
                    seeds = extractNumbers(list, from, to);
                }
            }
            from = to;
        }

        List<List<Long>> instructionList = new ArrayList<>(new ArrayList<>());
        for (int i = 0; i < list.size(); i++) {

            String s = list.get(i);
            if ((s.contains(":") && i != from) || i == list.size() - 1) {
                to = i;
                if (from != 0) {
                    // +1 and -2 are for empty spaces
                    if (i == list.size() - 1)
                        to+=2;
                    instructionList.add(extractNumbers(list, from + 1, to - 2));
                }
            }

            from = to;
        }


        //TODO extract overlaping seeds

        long answer = Long.MAX_VALUE;
//        for (int k = 0; k < seeds.size(); k+=2) {
//            for (long k1 = seeds.get(k); k1 < seeds.get(k) + seeds.get(k+1); k1++){
//
//
//
//                long seed = k1;
//                for (List<Long> list1 : instructionList){
//                    seed = followInstructions(seed, list1);
//                }
//
//                answer = Math.min(answer, seed);
//            }
//        }

        List<Long> newSeeds = new ArrayList<>();
        Map<Long, Long> skeapMap = new HashMap<>();
        for (int i = 0; i < seeds.size(); i+=2){
            newSeeds.add(seeds.get(i));
            newSeeds.add(seeds.get(i) + seeds.get(i + 1));
        }


        long lfrom = Collections.min(newSeeds);
        long lto = Collections.max(newSeeds);
        for (long i = lfrom; i < lto; i++){
            long seed = i;
                for (List<Long> list1 : instructionList) {
                    seed = followInstructions(seed, list1);
                }

            answer = Math.min(answer, seed);

        }
        System.out.println(answer);
    }

    public static Long followInstructions(Long seed, List<Long> instruction) {

        for (int i = 0; i < instruction.size(); i += 3) {
            long correspondingValue = instruction.get(i);
            long start = instruction.get(i + 1);
            long quantity = instruction.get(i + 2);

            if (seed >= start && seed < start + quantity) {
                seed = correspondingValue + seed - start;
                break;
            }

        }

        if (seed == 0 ){
            System.out.println("asf");
        }

        return seed;
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
