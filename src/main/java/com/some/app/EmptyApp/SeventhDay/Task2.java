package com.some.app.EmptyApp.SeventhDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    static int limit = 40_000_000;
    static int ourSize = 0;
    static List<Integer> listOfTheSmallest = new ArrayList<>();
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/SeventhDay.txt");
        Dir motherOfAll = new Dir("motherOfAll", null);
        Dir mother = motherOfAll;
        List<String> contains = new ArrayList<>();
        String s = "";
        int i = 2;

        //mother -> first folder;
        while (list.get(i).charAt(0)!='$'){
            contains.add(list.get(i));
            i++;
        }
        addToDir(contains, mother);
        contains.clear();
        /*
        mother -> first folder;                 ///////////////////////DONE

        $ cd 'name' -> find in mother 'name' -> fill it -> mother = 'name'
        $ cd .. -> mother = mother.motherFolder
        until list ends;
        */

        Dir subDir;
        while (i<list.size()) {
            if (list.get(i).startsWith("$ cd ")) {
                s = list.get(i).substring(5);
                if (!s.equals("..")){
                    i++;
                    i++;
                    subDir = new Dir(s, mother);
                    while (list.get(i).charAt(0) != '$') {
                        contains.add(list.get(i));
                        i++;
                        if (i==list.size())
                            break;
                    }
                    addToDir(contains, subDir);
                    contains.clear();
                    mother.fillDir(subDir);
                    mother = subDir;
                } else {
                    mother = mother.getMotherFolder();
                    i++;
                }
            } else if (list.get(i).startsWith("$ ls")){
                i++;
            }
        }

        motherOfAll.showAll();
        System.out.println("Size is "+motherOfAll.size());


//        System.out.println(motherOfAll.sizeUnder100k(0));



        setOurSize(motherOfAll.size());
        goThroughAllDirs(motherOfAll);
        System.out.println(Collections.min(listOfTheSmallest));


    }

    public static void setOurSize(int size){
        ourSize = size;
    }


    public static void goThroughAllDirs(Dir dir){
        if ((ourSize - dir.size())<=limit) {
            listOfTheSmallest.add(dir.size());
        }

        if (!dir.isEmpty()&&dir.getDirs()!=null)
            for (Dir subDir : dir.getDirs()){
                goThroughAllDirs(subDir);
            }
    }

    public static void addToDir(List<String> list, Dir dir){

        List<File> files = new ArrayList<>();
        List<Dir> dirs = new ArrayList<>();

        //first half will have size (digits) or "dir", second always have a name
        String[] info;
        int size;

        for (String s : list) {
            info = s.split(" ");
            try {
                size = Integer.parseInt(info[0]);
                files.add(new File(size, info[1]));
            } catch (NumberFormatException e) {
                dirs.add(new Dir(info[1], dir));
            }
        }

        if (!dirs.isEmpty())
            dir.setDirs(dirs);
        if (!files.isEmpty())
            dir.setFiles(files);
    }
}

/*if (list.get(i).startsWith("$ cd ")) {
                s = list.get(i).substring(5);
                if (!s.equals("..")) {
                    subDir = new Dir(s, mother);
                    i += 2;
                    while (list.get(i).charAt(0) != '$') {
                        contains.add(list.get(i));
                        i++;
                    }
                    addToDir(contains, subDir);
                    mother.fillDir(subDir);
                    mother = subDir;
                } else {
                    mother = mother.getMotherFolder();
                    i++;
                }
            }*/
