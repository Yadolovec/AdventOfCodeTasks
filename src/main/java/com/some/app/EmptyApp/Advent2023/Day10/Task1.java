package com.some.app.EmptyApp.Advent2023.Day10;

import com.some.app.EmptyApp.util.Utils;

import java.util.*;

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
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
            if (start[0] != -1) {
                break;
            }
        }

        int[] tile = start;
        int i = 0;
        int[] previousTile = start.clone();
        do {
            i++;
            tile = calculateNext(tile, map, previousTile);
            previousTile = tile.clone();
        } while (Arrays.equals(tile, start));

        System.out.println(i);


    }

    public static int[] calculateNext(int[] tile, List<char[]> map, int[] previousTile) {


        int[] toReturn = {-1, -1};

        int[][] potentialNextTiles = new int[4][2];

        potentialNextTiles[0] = new int[]{tile[0], tile[1] + 1};
        potentialNextTiles[1] = new int[]{tile[0], tile[1] - 1};
        potentialNextTiles[2] = new int[]{tile[0] + 1, tile[1]};
        potentialNextTiles[3] = new int[]{tile[0] - 1, tile[1]};

        for (int [] nextTile : potentialNextTiles){
            char tileName = getTileByCoordinates(map, tile);
            char nextTileName = getTileByCoordinates(map, nextTile);

            if (isConnectable(tileName, nextTileName) && !Arrays.equals(nextTile, previousTile)){
                toReturn = nextTile;
                break;
            }
        }

        return toReturn;

    }
    public static char getTileByCoordinates(List<char[]> map, int[] coordinates){
        return map.get(coordinates[0])[coordinates[1]];
    }

    public static boolean isConnectable(char first, char second){
        if (first == 'S' || second == 'S')
            return true;

        if (second == '.')
            return false;

        if (first == '|')
            return  second != '-';

        if (first == '-')
            return second != '|';

        return !(first == second);
    }


}

