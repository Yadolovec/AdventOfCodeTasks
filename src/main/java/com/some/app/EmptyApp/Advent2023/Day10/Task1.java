package com.some.app.EmptyApp.Advent2023.Day10;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Volodymyr Havrylets
 * @since 22.02.2024
 **/
public class Task1 {


    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day10t");
        int[] start = {-1, -1};

        List<char[]> map = new ArrayList<>();
        //Find the start and Create map
        for (int i = 0; i < list.size(); i++) {
            char[] charArray = list.get(i).toCharArray();
            map.add(charArray);
            if (start[0] == -1) {
                for (int j = 0; j < charArray.length; j++) {
                    if (charArray[j] == 'S') {
                        start[0] = i;
                        start[1] = j;
                        break;
                    }
                }
            }
        }
        int i = 0;

        int[] previousTile = start.clone();
        int[] tileCoordinates = start.clone();
        int[] additionalTile;
        do {
            additionalTile = tileCoordinates.clone();
            tileCoordinates = findNextTile(tileCoordinates, previousTile, map);
            previousTile = additionalTile.clone();

            i++;
        } while (!Arrays.equals(tileCoordinates, start));

        System.out.println(i);
    }

    public static int[] findNextTile(int[] tileCoordinates, int[] previousTile, List<char[]> map) {
        List<int[]> potentialNexts = findConnectable(map, tileCoordinates);
        if (Arrays.equals(potentialNexts.get(0), previousTile)){
            return potentialNexts.get(1);
        } else {
            return potentialNexts.get(0);
        }
    }

    public static List<int[]> findConnectable(List<char[]> map, int[] tileCoordinates) {
        List<int[]> toReturn = new ArrayList<>();

        int[][] potentialNextTiles = new int[4][2];

        potentialNextTiles[0] = new int[]{tileCoordinates[0], tileCoordinates[1] + 1};
        potentialNextTiles[1] = new int[]{tileCoordinates[0], tileCoordinates[1] - 1};
        potentialNextTiles[2] = new int[]{tileCoordinates[0] + 1, tileCoordinates[1]};
        potentialNextTiles[3] = new int[]{tileCoordinates[0] - 1, tileCoordinates[1]};

        for (int[] array : potentialNextTiles){
            if (array[0] < 0 || array[1] < 0 || array[0] >= map.size() || array[1] >= map.get(0).length){
                continue;
            }


            //TODO additional check for position
            if (isConnectable(tileCoordinates, array, map)){
                toReturn.add(array);
            }
        }

        return toReturn;
    }

    public static boolean isConnectable(int[] first, int[] second, List<char[]> map){
        return isConnectable(getTileByCoordinates(map, first), getTileByCoordinates(map, second));
    }

    public static boolean isConnectable(char first, char second) {
        if (first == 'S' || second == 'S')
            return true;

        if (second == '.')
            return false;

        if (first == '|')
            return second != '-';

        if (first == '-')
            return second != '|';

        return !(first == second);
    }

    public static char getTileByCoordinates(List<char[]> map, int[] coordinates){
        return map.get(coordinates[0])[coordinates[1]];
    }
}

