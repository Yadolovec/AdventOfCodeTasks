package com.some.app.EmptyApp.Advent2023.Day9;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Volodymyr Havrylets
 * @since 15.02.2024
 **/
public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day9");


        int answer = 0;

        for (String s : list) {
            List<Integer> numbers = Arrays.stream(s.split(" ")).sequential().map(Integer::parseInt).toList();
            answer += calcNext(numbers);
        }

        System.out.println(answer);

    }

    public static int calcNext(List<Integer> numbers) {
        List<Integer> newNumbers = new ArrayList<>();

        if (containsAllZeros(numbers))
            return 0;

        for (int i = 0; i < numbers.size() - 1; i++) {
            newNumbers.add(numbers.get(i + 1) - numbers.get(i));
        }

        return numbers.get(numbers.size() - 1) + calcNext(newNumbers);
    }

    public static boolean containsAllZeros(List<Integer> numbers) {
        for (int i : numbers) {
            if (i != 0)
                return false;
        }

        return true;
    }
}
