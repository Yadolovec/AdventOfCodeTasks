package com.some.app.EmptyApp.Advent2023.Day8;

import com.some.app.EmptyApp.util.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 13.02.2024
 **/
public class Task2 {


        public static void main(String[] args) {
            List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day8");
            char[] instructions = list.get(0).toCharArray();


            Map<String, LeftRight> map = new HashMap<>();
            for (int i = 2; i < list.size(); i++) {
                map.put(list.get(i).split(" ")[0], new LeftRight(list.get(i)));
            }

            long answer = 0;
            int i = 0;

            List<String> starts = map.keySet().stream().filter(x -> x.toCharArray()[2] == 'A').toList();
            Set<String> ends = map.keySet().stream().filter(x -> x.toCharArray()[2] == 'Z').collect(Collectors.toSet());

            while (!ends.containsAll(starts)) {
                int finalI = i;
                starts = starts.stream()
                        .map(x -> instructions[finalI] == 'L' ? map.get(x).getLeft() : map.get(x).getRight()).toList();

                i++;
                answer++;

                if (i == instructions.length) {
                    i = 0;
                }

                if (answer % 1000000 == 0){
                    System.out.println(answer);
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
