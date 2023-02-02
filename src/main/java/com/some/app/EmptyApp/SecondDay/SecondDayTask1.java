package com.some.app.EmptyApp.SecondDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.List;

public class SecondDayTask1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/SecondDay.txt");
        int points = 0;
        for(String s : list){
            char opponent = s.charAt(0);
            char me = s.charAt(2);

            if (me=='X'){
                points+=1;
                if (opponent=='A'){
                    points+=3;
                } else
                if (opponent=='B'){
                } else
                if (opponent=='C'){
                    points+=6;
                }

            } else
            if (me=='Y'){
                points+=2;
                if (opponent=='A'){
                    points+=6;
                } else
                if (opponent=='B'){
                    points+=3;
                } else
                if (opponent=='C'){
                }
            } else
            if (me=='Z'){
                points+=3;
                if (opponent=='A'){
                } else
                if (opponent=='B'){
                    points+=6;
                } else
                if (opponent=='C'){
                    points+=3;
                }
            }
        }

        System.out.println(points);
    }
}
