package com.some.app.EmptyApp.Advent2023.Day1;

import com.some.app.EmptyApp.util.Utils;

import java.util.List;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 04.01.2024
 **/
public class TryHard {
    public static void main(String[] args) {
        List<String> list1 = Utils.getListFromText("src/main/resources/Res2023/TryHavr");
        List<String> list2 = Utils.getListFromText("src/main/resources/Res2023/TryAndr");

        for (int i = 0; i < list1.size(); i++){
            if (!list1.get(i).equals(list2.get(i))){
                System.out.println(i);
                System.out.println(list1.get(i));
                System.out.println(list2.get(i));
                System.out.println();
            }
        }
    }
}
