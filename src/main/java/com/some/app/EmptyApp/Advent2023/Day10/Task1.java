package com.some.app.EmptyApp.Advent2023.Day10;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Volodymyr Havrylets
 * @since 22.02.2024
 **/
public class Task1 {
    enum Direction {WEST, EAST, SOUTH, NORTH, NONE}

    ;


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

        Map<Integer, int[]> way = new HashMap<>();
        int[] coordinates = start;
        int i = 0;
        Direction ignoredDirection = Direction.NONE;
        do {
            way.put(i, coordinates);
            i++;
            coordinates = calculateNext(coordinates, map, ignoredDirection);


        } while (coordinates.equals(start));


    }

    public static int[] calculateNext(int[] coordinates, Map<Integer, char[]> map, Direction ignoredDirection) {

        if (ignoredDirection == Direction.NONE) {

        }

        char west = coordinates[1] - 1 >= 0
                ? map.get(coordinates[0])[coordinates[1] - 1] : ' ';
        char east = coordinates[1] + 1 < map.get(0).length
                ? map.get(coordinates[0])[coordinates[1] + 1] : ' ';
        char north = coordinates[0] - 1 >= 0
                ? map.get(coordinates[0] - 1)[coordinates[1]] : ' ';
        char south = coordinates[1] - 1 < map.size()
                ? map.get(coordinates[0] + 1)[coordinates[1]] : ' ';


        char currentLocation = map.get(coordinates[0])[coordinates[1]];
        if (currentLocation == 'S')

    }

    public class Tile {

    }
}

