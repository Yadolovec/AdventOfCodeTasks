package com.some.app.EmptyApp.EighthDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.Arrays;
import java.util.List;

public class Task2 {
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
            System.out.println(Arrays.toString(forest[i]));
        }

        int bestScore = 0;
        int score = 0;
        for (int i = 1; i<height-1; i++){
            for (int j = 1; j<width-1; j++){
                score = checkTheTreeViewScore(i, j, forest);
                if (score > bestScore){
                    bestScore = score;
                }
            }
        }


        System.out.println(bestScore);


    }

    public static int checkTheTreeViewScore(int row, int column, int[][] forest){
        int tree = forest[row][column];
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        for (int i = row-1; i>=0; i--){
            up++;
            if (forest[i][column]>=tree)
                break;
        }

        for (int i = row+1; i<forest.length; i++){
            down++;
            if (forest[i][column]>=tree)
                break;
        }

        for (int j = column - 1; j>=0; j--){
            left++;
            if (forest[row][j]>=tree)
                break;

        }

        for (int j = column+1; j< forest[0].length; j++){
            right++;
            if (forest[row][j]>=tree)
                break;
        }

        return up*down*left*right;


    }
}
