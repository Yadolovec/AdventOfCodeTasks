package com.some.app.EmptyApp.ThirdDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/ThirdDay.txt");
        Character[] charArray1;
        Character[] charArray2;
        Character[] charArray3;
        Set<Character> set1;
        Set<Character> set2;
        Set<Character> set3;
        Set<Character> set;
        int points = 0;

        for (int i = 0; i<list.size(); i+=3) {
            charArray1 = Utils.toCharacterArray(list.get(i).toCharArray());
            charArray2 = Utils.toCharacterArray(list.get(i+1).toCharArray());
            charArray3 = Utils.toCharacterArray(list.get(i+2).toCharArray());

            set1 = Arrays.stream(charArray1).collect(Collectors.toSet());
            set2 = Arrays.stream(charArray2).collect(Collectors.toSet());
            set3 = Arrays.stream(charArray3).collect(Collectors.toSet());

            set = Utils.getIntersection(set1, set2);
            set = Utils.getIntersection(set, set3);

            points+=Utils.getLetterPriority((char) set.toArray()[0]);

        }
        System.out.println(points);
    }
}
