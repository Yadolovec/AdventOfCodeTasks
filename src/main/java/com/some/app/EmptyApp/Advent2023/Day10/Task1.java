package com.some.app.EmptyApp.Advent2023.Day10;

import com.some.app.EmptyApp.util.Utils;

import java.util.*;

/**
 * @author Volodymyr Havrylets
 * @since 22.02.2024
 **/
public class Task1 {

    static Direction directionToIgnore = Direction.NONE;

    enum Direction {
        LEFT, RIGHT, DOWN, UP, NONE
    }

    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day10");
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
            tileCoordinates = findNextTile(tileCoordinates, map);
            i++;

        } while (!Arrays.equals(tileCoordinates, start));

        System.out.println(i / 2);
    }

    public static int[] findNextTile(int[] tileCoordinates, List<char[]> map) {



        int[] rightTile = new int[]{tileCoordinates[0], tileCoordinates[1] + 1};
        int[] leftTile = new int[]{tileCoordinates[0], tileCoordinates[1] - 1};
        int[] downTile = new int[]{tileCoordinates[0] + 1, tileCoordinates[1]};
        int[] upTile = new int[]{tileCoordinates[0] - 1, tileCoordinates[1]};

        Set<Character> left = Set.of('-', 'F', 'L', 'S');
        Set<Character> right = Set.of('-', '7', 'J', 'S');
        Set<Character> up = Set.of('|', 'F', '7', 'S');
        Set<Character> down = Set.of('|', 'J', 'L', 'S');

        Map<Direction, Set<Character>> allowedCharactersByDirection = new HashMap<>();

        allowedCharactersByDirection.put(Direction.LEFT, left);
        allowedCharactersByDirection.put(Direction.RIGHT, right);
        allowedCharactersByDirection.put(Direction.UP, up);
        allowedCharactersByDirection.put(Direction.DOWN, down);

        char tileName = getTileByCoordinates(map, tileCoordinates);


        if (isInBounds(map, upTile) && directionToIgnore != Direction.UP
                && allowedCharactersByDirection.get(Direction.UP).contains(getTileByCoordinates(map, upTile))
                && isConnectable(tileName, getTileByCoordinates(map, upTile), Direction.UP)) {
            directionToIgnore = Direction.DOWN;
            return upTile;
        }


        if (isInBounds(map, downTile) && directionToIgnore != Direction.DOWN
                && allowedCharactersByDirection.get(Direction.DOWN).contains(getTileByCoordinates(map, downTile))
                && isConnectable(tileName, getTileByCoordinates(map, downTile), Direction.DOWN)) {
            directionToIgnore = Direction.UP;
            return downTile;
        }


        if (isInBounds(map, leftTile) && directionToIgnore != Direction.LEFT
                && allowedCharactersByDirection.get(Direction.LEFT).contains(getTileByCoordinates(map, leftTile))
                && isConnectable(tileName, getTileByCoordinates(map, leftTile), Direction.LEFT)) {
            directionToIgnore = Direction.RIGHT;
            return leftTile;
        }


        if (isInBounds(map, rightTile) && directionToIgnore != Direction.RIGHT
                && allowedCharactersByDirection.get(Direction.RIGHT).contains(getTileByCoordinates(map, rightTile))
                && isConnectable(tileName, getTileByCoordinates(map, rightTile), Direction.RIGHT)) {
            directionToIgnore = Direction.LEFT;
            return rightTile;
        }

        return null;
    }

    public static boolean isConnectable(char first, char second, Direction direction) {
        if (first == 'S' || second == 'S')
            return true;

        if (first == 'L' && (direction == Direction.DOWN || direction == Direction.LEFT))
            return false;

        if (first == 'J' && (direction == Direction.RIGHT || direction == Direction.DOWN))
            return false;


        if (first == '7' && (direction == Direction.RIGHT || direction == Direction.UP))
            return false;


        if (first == 'F' && (direction == Direction.UP || direction == Direction.LEFT))
            return false;

        if (second == '.')
            return false;

        if (first == '|'){
            if (direction == Direction.RIGHT || direction == Direction.LEFT)
                return false;

            return second != '-';
        }

        if (first == '-') {

            if (direction == Direction.UP || direction == Direction.DOWN)
                return false;
            return second != '|';
        }


        return !(first == second);
    }

    public static char getTileByCoordinates(List<char[]> map, int[] coordinates) {
        return map.get(coordinates[0])[coordinates[1]];
    }

    public static Direction checkDirection(int[] first, int[] second) {
        if (first[0] > second[0])
            return Direction.DOWN;
        if (first[0] < second[0])
            return Direction.UP;
        if (first[1] > second[1])
            return Direction.LEFT;
        if (first[1] < second[1])
            return Direction.RIGHT;

        return Direction.NONE;
    }

    public static boolean isInBounds(List<char[]> map, int[] array) {
        return  !(array[0] < 0 || array[1] < 0 || array[0] >= map.size() || array[1] >= map.get(0).length);
    }
}

