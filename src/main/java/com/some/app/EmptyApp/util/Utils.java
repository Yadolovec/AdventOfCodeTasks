package com.some.app.EmptyApp.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Integer> getListFromText(String pathToFile){
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
}
