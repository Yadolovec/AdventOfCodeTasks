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
        for (File f : files){
            System.out.println(f);
        }
        for (Dir d : dirs){
            System.out.println(d);
        }
    }

    public void fillDir(Dir subDir){
        String s = subDir.getName();
        for (int i = 0; i<dirs.size(); i++){
            if (dirs.get(i).getName().equals(s))
                dirs.set(i, subDir);
        }
    }

    public boolean isEmpty(){
        boolean noDirs = true;
        if (dirs == null) {
            noDirs = false;
        } else if (dirs.isEmpty()){
            noDirs = false;
        }

        boolean noFiles = true;
        if (files == null) {
            noFiles = false;
        } else if (files.isEmpty()){
            noFiles = false;
        }

        return !(noDirs||noFiles);

    }
}
