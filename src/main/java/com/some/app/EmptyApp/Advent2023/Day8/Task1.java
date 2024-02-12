package com.some.app.EmptyApp.Advent2023.Day8;

import com.some.app.EmptyApp.util.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 12.02.2024
 **/
public class Task1 {

    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day8");
        char[] instructions = list.get(0).toCharArray();


        Map<String, LeftRight> map = new HashMap<>();
        for (int i = 2; i < list.size(); i++) {
            map.put(list.get(i).split(" ")[0], new LeftRight(list.get(i)));
        }

        int answer = 0;
        int i = 0;
        String location = "AAA";
        while (!location.equals("ZZZ")) {
            location = instructions[i] == 'L' ? map.get(location).getLeft() : map.get(location).getRight();
            i++;
            answer++;

            if (i == instructions.length) {
                i = 0;
            }
        }

        System.out.println(answer);
    }

    static class LeftRight {

        public LeftRight(String s) {
            String s1 = s.split("\\(")[1];
            setLeft(s1.split(",")[0]);
            setRight(s1.split(" ")[1].replaceAll("\\)", ""));
        }

        private String left;
        private String right;

        public String getLeft() {
            return left;
        }

        public void setLeft(String left) {
            this.left = left;
        }

        public String getRight() {
            return right;
        }

        public void setRight(String right) {
            this.right = right;
        }
    }
}
