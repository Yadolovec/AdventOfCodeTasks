package com.some.app.EmptyApp.Advent2023.Day10;

import com.some.app.EmptyApp.util.Utils;

import java.util.List;

/**
 * @author Volodymyr Havrylets
 * @since 22.02.2024
 **/
public class Task1 {

    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day10t");
        int[] start = {-1, -1};

        //Find the start
        for (int i = 0; i < list.size(); i++){
            char[] charArray = list.get(i).toCharArray();
            for (int j = 0; j < charArray.length; j++){
                if (charArray[j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
            if (start[0] != -1){
                break;
            }
        }




    }
}
