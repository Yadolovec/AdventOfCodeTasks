package com.some.app.EmptyApp.FirstDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.Collections;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        List<Integer> list = Utils.getListFromTextAndAddCalories("src/main/resources/.txt");
        int sum = 0;

        for (int i = 0; i<3; i++){
            Integer max = Collections.max(list);
            sum+=max;
            list.remove(max);
        }

        System.out.println(sum);
    }
}
