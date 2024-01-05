package com.some.app.EmptyApp.Advent2023.Day1;

import com.some.app.EmptyApp.util.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Volodymyr Havrylets
 * @link volodymyr.havrylets@embrox.com
 * @since 04.01.2024
 **/
public class Task2v2 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day1");

        int answer = 0;

        for (String line : list){

            String beginning = cutBeginning(line);
            String ending = cutEnding(line);
            int toShow1, toShow2;

            if (firstWordToDigit(beginning) != 0){
                answer+=firstWordToDigit(beginning) * 10;
                toShow1 = firstWordToDigit(beginning) * 10;
            } else {
                answer+=findFirstDigit(line) * 10;
                toShow1 = findFirstDigit(line) * 10;
            }

            if (lastWordToDigit(ending) != 0){
                answer+=lastWordToDigit(ending);
                toShow2=lastWordToDigit(ending);
            } else {
                answer+=findFirstDigit(new StringBuilder(line).reverse().toString());
                toShow2=findFirstDigit(new StringBuilder(line).reverse().toString());
            }

            System.out.println(toShow1 + toShow2);
        }

        System.out.println(answer);

    }

    public static String cutBeginning(String line){
        char[] charArray = line.toCharArray();
        int index = -1;

        for (int i = 0; i < charArray.length; i++){
            if (Character.isDigit(charArray[i])){
                index = i;
                break;
            }
        }

        return index != -1
                ?line.substring(0, index)
                : line;
    }

    public static String cutEnding(String line){
        String toReturn = new StringBuilder(line).reverse().toString();
        toReturn = cutBeginning(toReturn);
        return new StringBuilder(toReturn).reverse().toString();
    }

    public static int findFirstDigit(String line){
        char[] charArray = line.toCharArray();

        for (int i = 0; i < charArray.length; i++){
            if (Character.isDigit(charArray[i])){
                return charArray[i] - '0';
            }
        }
        return -1;
    }

    public static int findFirstDigitIndex(String line){
        char[] charArray = line.toCharArray();

        for (int i = 0; i < charArray.length; i++){
            if (Character.isDigit(charArray[i])){
                return i;
            }
        }
        return -1;
    }

    public static int findLastDigitIndex(String line){
        char[] charArray = line.toCharArray();

        for (int i = charArray.length - 1; i >= 0; i--){
            if (Character.isDigit(charArray[i])){
                return i;
            }
        }
        return -1;
    }

    public static int firstWordToDigit(String line){
        String toReturn = "";
        Map<String, Integer> nameToDigit = new HashMap<>();

        nameToDigit.put("one", 1);
        nameToDigit.put("two", 2);
        nameToDigit.put("three", 3);
        nameToDigit.put("four", 4);
        nameToDigit.put("five", 5);
        nameToDigit.put("six", 6);
        nameToDigit.put("seven", 7);
        nameToDigit.put("eight", 8);
        nameToDigit.put("nine", 9);

        int index = Integer.MAX_VALUE;
        for (String digit : nameToDigit.keySet()){
            if (line.contains(digit)){
                if (line.indexOf(digit) < index){
                    toReturn = digit;
                    index = line.indexOf(digit);
                }
            }
        }

        return nameToDigit.getOrDefault(toReturn, 0);
    }

    public static int lastWordToDigit(String line){
        String toReturn = "";
        Map<String, Integer> nameToDigit = new HashMap<>();

        nameToDigit.put("one", 1);
        nameToDigit.put("two", 2);
        nameToDigit.put("three", 3);
        nameToDigit.put("four", 4);
        nameToDigit.put("five", 5);
        nameToDigit.put("six", 6);
        nameToDigit.put("seven", 7);
        nameToDigit.put("eight", 8);
        nameToDigit.put("nine", 9);

        int index = Integer.MIN_VALUE;
        for (String digit : nameToDigit.keySet()){
            if (line.contains(digit)){
                if (line.lastIndexOf(digit) > index){
                    toReturn = digit;
                    index = line.indexOf(digit);
                }
            }
        }

        return nameToDigit.getOrDefault(toReturn, 0);
    }
}
