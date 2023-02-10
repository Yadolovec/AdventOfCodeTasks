package com.some.app.EmptyApp.SixthDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task2 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/SixthDay.txt");
        String s = list.get(0);
        System.out.println(Task1.endOfKey(s, 14));
    }
}
