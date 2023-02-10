package com.some.app.EmptyApp.SixthDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/SixthDay.txt");
        String s = list.get(0);
        System.out.println(endOfKey(s, 4));
    }

    public static int endOfKey(String s, int quantityOfUniques) {
        Set<Character> charSet = new HashSet<>();
        int i = 0;
        while (true){
            if (charSet.size()==quantityOfUniques){
                return (i+quantityOfUniques-1);
            }
            charSet.clear();
            for (int j = i; j<i+quantityOfUniques; j++){
                charSet.add(s.charAt(j));
            }
            System.out.println(charSet);
            i++;
        }
    }
}
