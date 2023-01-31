package com.some.app.EmptyApp;

import com.some.app.EmptyApp.util.Utils;

import java.util.Collections;
import java.util.List;

public class SecondDayTask {

    public static void main(String[] args) {
        List<Integer> list = Utils.getListFromText("src/main/resources/FirstDay.txt");
        int i = Collections.max(list);
        list.remove(Collections.max(list));

        i+=Collections.max(list);
        list.remove(Collections.max(list));

        i+=Collections.max(list);

        System.out.println(i);
    }
}
