package com.yuan.mvvm.viewmodel.bean;

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

    // VM层业务逻辑，初始化数据，从数据库或者缓存中取数据
    public void initData() {
        // TODO: 2019/8/4 通过setStudents()更新数据还是通过getStudents().setValue() ???
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
        student.setName("李磊" + System.currentTimeMillis() % 1000);
        student.setId(((int) (System.currentTimeMillis() % 100)));
        value.add(student);
        value.add(new Student());
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
                    long time = System.currentTimeMillis() % 1000;
                    Log.d(TAG, "run: " + time);
                    student.setName("韩梅梅" + time);
                    student.setId(((int) (System.currentTimeMillis() % 100)));
                    List<Student> vl = getStudents().getValue();
                    vl.set(1, student);
                    getStudents().postValue(vl); // 子线程只能postValue
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static void main(String[] args) {
        // todo 与 SystemClock.currentThreadTimeMillis() 不同
        long real = System.currentTimeMillis();
        long time = System.currentTimeMillis() % 1000;
        long time2 = System.currentTimeMillis() % 9999;
        System.out.println("real=" + real);
        System.out.println("time=" + time);
        System.out.println("time2=" + time2);
        /*
real=1564888915003
time=3
time2=9544
        * */
    }
}
