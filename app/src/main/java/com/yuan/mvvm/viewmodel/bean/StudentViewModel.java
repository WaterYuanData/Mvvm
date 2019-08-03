package com.yuan.mvvm.viewmodel.bean;

import android.os.SystemClock;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class StudentViewModel extends ViewModel {
    private static final String TAG = "StudentViewModel";

    // ViewModel持有MutableLiveData对象
    private MutableLiveData<List<Student>> students;

    public MutableLiveData<List<Student>> getStudents() {
        if (students == null) students = new MutableLiveData<>();
        return students;
    }

    public void setStudents(MutableLiveData<List<Student>> students) {
        this.students = students;
    }

    // VM层的业务逻辑，更新
    public void update() {
        List<Student> value = getStudents().getValue();
        if (value == null) {
            // TODO: 2019/8/4 缓存
            Log.d(TAG, "update: 新建，todo 缓存");
            value = new ArrayList<>();
        }
        value.clear();
        Student student = new Student();
        student.setName("李磊" + SystemClock.currentThreadTimeMillis() % 9999);
        student.setId(((int) (SystemClock.currentThreadTimeMillis() % 99)));
        value.add(student);
        value.add(student);
        getStudents().setValue(value);
        Log.d(TAG, "update: 线程=" + Thread.currentThread().getName());
        // 线程切换
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(TAG, "update: 新线程=" + Thread.currentThread().getName());
                    // 模拟耗时操作
                    Thread.sleep(1500);
                    Student student = new Student();
                    // TODO: 2019/8/4  
                    student.setName("韩梅梅" + SystemClock.currentThreadTimeMillis() % 9999);
                    student.setId(((int) (SystemClock.currentThreadTimeMillis() % 66)));
                    List<Student> vl = getStudents().getValue();
                    vl.set(1, student);
                    getStudents().postValue(vl); // 子线程只能postValue
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
