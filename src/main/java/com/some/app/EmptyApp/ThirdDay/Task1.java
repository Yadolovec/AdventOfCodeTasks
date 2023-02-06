package com.some.app.EmptyApp.ThirdDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/ThirdDay.txt");
        String[] halfs;
        Character[] charArray1;
        Character[] charArray2;
        Set<Character> set;
        Set<Character> set1;
        Set<Character> set2;
        int points = 0;

        for (String s : list) {
            halfs = Utils.splitInHalf(s);
            charArray1 = Utils.toCharacterArray(halfs[0].toCharArray());
            charArray2 = Utils.toCharacterArray(halfs[1].toCharArray());

            set1 = Arrays.stream(charArray1).collect(Collectors.toSet());
            set2 = Arrays.stream(charArray2).collect(Collectors.toSet());
            set = new HashSet<>(set1);

            set1.removeAll(set2);
            set.removeAll(set1);

            points += Utils.getLetterPriority((char) set.toArray()[0]);

        }
        System.out.println(points);

    }
}

