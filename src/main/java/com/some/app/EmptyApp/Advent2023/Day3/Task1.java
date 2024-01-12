package com.some.app.EmptyApp.Advent2023.Day3;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 11.01.2024
 **/
public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day3");

        List<Number> numbers = new ArrayList<>();
        List<Coordinates> symbolsCoordinates = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            char[] charArray = s.toCharArray();

            int start = 0;
            int end = 0;
            boolean numberOperation = false;

            for (int j = 0; j < charArray.length; j++) {
                char c = charArray[j];

                if (!Character.isDigit(c) && c != '.') {
                    symbolsCoordinates.add(new Coordinates(j, i));
                }

                if (Character.isDigit(c) && !numberOperation) {
                    start = j;
                    numberOperation = true;
                }

                if (!Character.isDigit(c) && numberOperation) {
                    end = j - 1;
                    numberOperation = false;

                    int value = Integer.parseInt(s.substring(start, end + 1));

                    numbers.add(new Number(new Coordinates(start, i),
                            end - start + 1,
                            value));
                }

                if (numberOperation && j == charArray.length - 1) {
                    end = j;
                    numberOperation = false;

                    int value = Integer.parseInt(s.substring(start, end + 1));

                    numbers.add(new Number(new Coordinates(start, i),
                            end - start + 1,
                            value));
                }
            }
        }

        int answer = 0;
        for (Number number : numbers) {
            for (Coordinates coordinates : symbolsCoordinates) {
                if (isAdjacent(number, coordinates)) {
                    answer += number.getValue();
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean isAdjacent(Number number, Coordinates coordinates) {

        Coordinates begin = number.getBeginCoordinates();
        int length = number.getLength();

        if (Math.abs(coordinates.getY() - begin.getY()) <= 1
                && coordinates.getX() >= begin.getX() - 1
                && coordinates.getX() <= begin.getX() + length) {

            System.out.println(number.getValue());
            return true;
        }
        ;

        return false;
    }

}


class Number {
    private Coordinates beginCoordinates;
    private int length;
    private int value;

    public Number(Coordinates beginCoordinates, int length, int value) {
        this.beginCoordinates = beginCoordinates;
        this.length = length;
        this.value = value;
    }

    public Coordinates getBeginCoordinates() {
        return beginCoordinates;
    }

    public void setBeginCoordinates(Coordinates beginCoordinates) {
        this.beginCoordinates = beginCoordinates;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
