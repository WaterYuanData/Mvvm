package com.yuan.mvvm.viewmodel.bean;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class StudentViewModel extends ViewModel {
    private MutableLiveData<List<Student>> students;

    public MutableLiveData<List<Student>> getStudents() {
        if (students == null) students = new MutableLiveData<>();
        return students;
    }

    public void setStudents(MutableLiveData<List<Student>> students) {
        this.students = students;
    }

}
