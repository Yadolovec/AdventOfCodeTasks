package com.some.app.EmptyApp.EighthDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/EighthDay.txt");
        System.out.println(list);
        int height = list.size();
        int width = list.get(0).length();
        int[][] forest = new int[height][width];

        for (int i = 0; i<height; i++){
            for (int j = 0; j<width; j++){
                forest[i][j] = Integer.parseInt(list.get(i).substring(j, j+1));
            }
        }

        int counter = list.size()*2 + list.get(0).length()*2 - 4;
        for (int i = 1; i<height-1; i++){
            for (int j = 1; j<width-1; j++){
                counter = counter + checkTheTree(i, j, forest);
            }
        }

        System.out.println(counter);


    }

    public static int checkTheTree(int row, int column, int[][] forest){
        int tree = forest[row][column];
        for (int i = 0; i<row; i++){
            if (forest[i][column]>=tree){
                break;
            } else {
                if (i==row-1){
                    return 1;
                }
            }
        }

        for (int i = row+1; i<forest.length; i++){
            if (forest[i][column]>=tree){
                break;
            } else {
                if (i== forest.length-1){
                    return 1;
                }
            }
        }

        for (int j = 0; j<column; j++){
            if (forest[row][j]>=tree){
                break;
            } else {
                if (j==column-1){
                    return 1;
                }
            }
        }

        for (int j = column+1; j< forest[0].length; j++){
            if (forest[row][j]>=tree){
                break;
            } else {
                if (j== forest[0].length-1){
                    return 1;
                }
            }
        }

        return 0;


    }
}
