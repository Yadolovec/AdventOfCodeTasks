package com.some.app.EmptyApp.SeventhDay;

import java.util.List;

public class Dir {
    private List<File> files;
    private List<Dir> dirs;

    private Dir motherFolder;

    private String name;
    public Dir(String name, Dir motherFolder){
        this.name = name;
        this.motherFolder = motherFolder;
    }


    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<Dir> getDirs() {
        return dirs;
    }

    public void setDirs(List<Dir> dirs) {
        this.dirs = dirs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dir getMotherFolder() {
        return motherFolder;
    }

    public void setMotherFolder(Dir motherFolder) {
        this.motherFolder = motherFolder;
    }

    @Override
    public String toString() {
        return "dir "+name;
    }

    public void showAll(){
        System.out.println("dir " + name);
        System.out.println('{');
        if ((dirs==null||dirs.isEmpty())&&(files==null||files.isEmpty())) {
            System.out.print(" is empty");
            return;
        }

        if (!(files==null||files.isEmpty()))
            for (File f : files){
                System.out.println(" "+f);
            }
        if (!(dirs==null||dirs.isEmpty()))
            for (Dir d : dirs){
//                System.out.println(" "+d);
                System.out.print(" ");
                d.showAll();
            }

        System.out.println('}');
    }

    public int size(){
        int toReturn = 0;

        if (!(files==null||files.isEmpty()))
            for (File f : files){
                toReturn+=f.getSize();
            }
        if (!(dirs==null||dirs.isEmpty()))
            for (Dir d : dirs){
                toReturn+=d.size();
            }

        return toReturn;
    }

//    public int sizeUnder100k(int sum){
//        int batery = 0;
//
//        if (!(files==null||files.isEmpty()))
//            for (File f : files){
//                batery+=f.getSize();
//            }
//        if (!(dirs==null||dirs.isEmpty()))
//            for (Dir d : dirs){
//                batery+=d.sizeUnder100k(sum);
//            }
//
//        if (batery>100000){
//            return sum;
//        }
//        return sum+batery;
//    }

    public void fillDir(Dir subDir){
        String s = subDir.getName();
        for (int i = 0; i<dirs.size(); i++){
            if (dirs.get(i).getName().equals(s))
                dirs.set(i, subDir);
        }
    }

    public boolean isEmpty(){
        boolean haveDirs = true;
        if (dirs == null) {
            haveDirs = false;
        } else if (dirs.isEmpty()){
            haveDirs = false;
        }

        boolean haveFiles = true;
        if (files == null) {
            haveFiles = false;
        } else if (files.isEmpty()){
            haveFiles = false;
        }

        return !(haveDirs||haveFiles);

    }
}
