package com.some.app.EmptyApp.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    //FOR DAY ONE
    public static List<Integer> getListFromTextAndAddCalories(String pathToFile){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathToFile));
            String s;
            int i = 0;
            while ((s = br.readLine())!=null) {
                if (s.isBlank()) {
                    i++;
                    list.add(0);
                } else {
                    list.set(i, (list.get(i) + Integer.parseInt(s)));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> getListFromText(String pathToFile){
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathToFile));
            String s;
            while ((s = br.readLine())!=null) {
                list.add(s);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
