package com.some.app.EmptyApp.Advent2023.Day3;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 13.01.2024
 **/
public class Task2 {
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

                if (c == '*') {
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

        for (Coordinates coordinates : symbolsCoordinates) {
            boolean valid = false;
            int firstValue = 0;
            for (Number number : numbers) {
                if (isAdjacent(number, coordinates)) {

                    if (valid) {
                        answer += firstValue * number.getValue();
                        break;
                    }

                    firstValue = number.getValue();
                    valid = true;
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
