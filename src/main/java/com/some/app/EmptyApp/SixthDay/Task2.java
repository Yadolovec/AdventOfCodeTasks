package com.some.app.EmptyApp.SixthDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task2 {
    public static void main(String[] args) {
        List<String> s = Utils.getListFromText("src/main/resources/SixthDay.txt");
        Set<Character> charSet = new HashSet<>();

        int i = -1;
        while (true){
            i++;
            if (charSet.size()==14){
                System.out.println(i+13);
                break;
            }
            charSet.clear();
            for (int j = i; j<i+14; j++){
                charSet.add(s.get(0).charAt(j));
            }
            System.out.println(charSet);
        }


    }
}
