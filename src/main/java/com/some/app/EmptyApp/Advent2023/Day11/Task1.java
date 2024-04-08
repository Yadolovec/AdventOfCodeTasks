package com.some.app.EmptyApp.Advent2023.Day11;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Volodymyr Havrylets
 * @since 18.03.2024
 **/
public class Task1 {

    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Res2023/Day11t");

        Set<Integer> horizontalEmptySpace = new HashSet<>();
        Set<Integer> verticalEmptySpace = new HashSet<>();


        for (int i = 0; i < list.size(); i++){
            boolean isEmpty = false;
            char[] charArr = list.get(i).toCharArray();
            for (int j = 0; j < charArr.length; j++){
                if (charArr[j] != '.'){
                    break;
                }
                if (j == charArr.length - 1){
                    isEmpty = true;
                }
            }
            if (isEmpty){
                horizontalEmptySpace.add(i);
            }
        }

        for (int i = 0; i < list.get(0).length(); i++){
            boolean isEmpty = false;
            for (int j = 0; j < list.size(); j++){
                if (list.get(j).charAt(i) != '.'){
                    break;
                }
                if (j == list.size() - 1){
                    isEmpty = true;
                }
            }
            if (isEmpty){
                verticalEmptySpace.add(i);
            }
        }

        int additionalHorizontalSpace = 0;
        int additionalVerticalSpace = 0;
        List<Coordinates> coordinates = new ArrayList<>();

        for (int i = 0; i < list.size(); i++){
            if (horizontalEmptySpace.contains(i)) {
                additionalHorizontalSpace++;
                continue;
            }
            additionalVerticalSpace = 0;
            char[] charArr = list.get(i).toCharArray();
            for (int j = 0; j < charArr.length; j++){
                if (verticalEmptySpace.contains(j)){
                    additionalVerticalSpace++;
                    continue;
                }
                if (charArr[j] == '#'){
                    coordinates.add(new Coordinates(i + additionalHorizontalSpace, j + additionalVerticalSpace));
                }
            }
        }

        int answer = 0;
        int a = 0;
        for (int i = 0; i < coordinates.size(); i++){
            Coordinates coordinate1 = coordinates.get(i);
            for (int j = i; j < coordinates.size(); j++){
                if (j == i)
                    continue;
                Coordinates coordinate2 = coordinates.get(j);
                answer+=Math.abs(coordinate2.getX() - coordinate1.getX()) + Math.abs(coordinate2.getY() - coordinate1.getY());
                System.out.println(a++);
            }
        }
        System.out.println(answer);



    }

    static class Coordinates{
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
}
