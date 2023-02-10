package com.some.app.EmptyApp.SeventhDay;

import com.some.app.EmptyApp.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = Utils.getListFromText("src/main/resources/Test/Data7");
        Dir motherOfAll = new Dir("motherOfAll", null);
        Dir mother = motherOfAll;
        List<String> contains = new ArrayList<>();
        String s = "";
        int i = 2;


        while (list.get(i).charAt(0)!='$'){
            contains.add(list.get(i));
            i++;
        }
        addToDir(contains, mother);
        contains.clear();


//        if (list.get(i).startsWith("$ cd ")) {
//            s = list.get(i).substring(5);
//            if (!s.equals("..")){
//                Dir subDir = new Dir(s, mother);
//                i+=2;
//                while (list.get(i).charAt(0)!='$'){
//                    contains.add(list.get(i));
//                    i++;
//                }
//                addToDir(contains, subDir);
//                mother.fillDir(subDir);
//                mother = subDir;
//            }
//        }
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
