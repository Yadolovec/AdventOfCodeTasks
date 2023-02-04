package com.some.app.EmptyApp.SecondDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/SecondDay.txt");
        int points = 0;
        for(String s : list){
            char opponent = s.charAt(0);
            char me = s.charAt(2);

            if (opponent=='A'){
                if (me=='X'){
                    points+=3;
                } else
                if (me=='Y'){
                    points+=1;
                    points+=3;
                } else
                if (me=='Z'){
                    points+=2;
                    points+=6;
                }
            } else
            if (opponent=='B'){
                if (me=='X'){
                    points+=1;
                } else
                if (me=='Y'){
                    points+=2;
                    points+=3;
                } else
                if (me=='Z'){
                    points+=3;
                    points+=6;
                }
            } else
            if (opponent=='C'){
                if (me=='X'){
                    points+=2;
                } else
                if (me=='Y'){
                    points+=3;
                    points+=3;
                } else
                if (me=='Z'){
                    points+=1;
                    points+=6;
                }
            }
        }

        System.out.println(points);
    }
}
