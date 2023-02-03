package com.some.app.EmptyApp.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Utils {
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

    //FOR DAY THREE
    public static int getLetterPriority(char letter){
        int priority = 0;
        if (letter>='a'&&letter<='z'){
            priority=letter-96;
        } else
        if (letter>='A'&&letter<='Z'){
            priority=letter-65+27;
        }
        return priority;
    }

    public static String[] splitInHalf(String s){
        String[] toReturn = new String[2];
        int size = s.length();
        toReturn[0]=s.substring(0, size/2);
        toReturn[1]=s.substring(size/2, size);
        return toReturn;
    }

    public static Character[] toCharacterArray(char[] array){
        Character[] toReturn = new Character[array.length];
        for (int i = 0; i< array.length; i++){
            toReturn[i] = array[i];
        }
        return toReturn;
    }


}
