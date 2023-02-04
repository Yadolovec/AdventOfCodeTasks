package com.some.app.EmptyApp.FourthDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/FourthDay.txt");
        int begin1;
        int end1;
        int begin2;
        int end2;

        int counter = 0;

        for (String data : list) {
            String[] s = data.split(",");
            String[] Elf1 = s[0].split("-");
            String[] Elf2 = s[1].split("-");

            begin1 = Integer.parseInt(Elf1[0]);
            end1 = Integer.parseInt(Elf1[1]);
            begin2 = Integer.parseInt(Elf2[0]);
            end2 = Integer.parseInt(Elf2[1]);

            if (begin1 >= begin2 && end1 <= end2) {
                counter++;
            } else if (begin2 >= begin1 && end2 <= end1) {
                counter++;
            }

        }
            System.out.println(counter);

    }
}
