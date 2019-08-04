package com.yuan.mvvm.viewmodel.bean;

public class Student {
    private static final String TAG = "Student";

    private String name = "";
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "student:{name:" + name + " id:" + id + "}";
    }
}
