package com.some.app.EmptyApp.Advent2023.Day5;

import com.some.app.EmptyApp.util.Utils;

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

        for (int i = 0; i < list.size(); i++) {

            String s = list.get(i);
            if (s.contains(":") && i != from) {
                to = i;
            }

            Map<Integer, Integer> changeLine = extractChangeLine(list, from + 1, to - 2);
            from = to;


        }
    }
}
