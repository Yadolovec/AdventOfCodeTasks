package com.some.app.EmptyApp.SeventhDay;

public class File {
    private int size;
    private String name;

    public File(int size, String name){
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return size + " " + name;
    }
}
