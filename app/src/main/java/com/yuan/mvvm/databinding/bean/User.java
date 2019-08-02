package com.yuan.mvvm.databinding.bean;

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    // TODO: 2019/8/2
    //    Integer id;
    //
    //    public Integer getId() {
    //        return id;
    //    }
    //
    //    public void setId(Integer id) {
    //        this.id = id;
    //    }

    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    boolean isStudent = true;

}
