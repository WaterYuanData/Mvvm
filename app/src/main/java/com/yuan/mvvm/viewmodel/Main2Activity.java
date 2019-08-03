package com.yuan.mvvm.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import com.yuan.mvvm.R;
import com.yuan.mvvm.databinding.ActivityMain2Binding;
import com.yuan.mvvm.viewmodel.bean.Student;
import com.yuan.mvvm.viewmodel.bean.StudentViewModel;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main2Activity";
    private StudentViewModel mStudentViewModel;
    private ActivityMain2Binding mBinding;
    private ObservableList<Student> mStudent_binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 绑定xml
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main2);

        // 将点击事件绑定到xml中
        // todo 遗漏导致点击无效
        mBinding.setMyClick(new MyClick());

        // 将数据绑定到xml中
        mStudent_binding = new ObservableArrayList<>();
        for (int i = 0; i < 2; i++) {
            Student student = new Student();
            student.setName("y" + SystemClock.currentThreadTimeMillis() % 7777);
            mStudent_binding.add(student);
        }
        mBinding.setStudent1(mStudent_binding);
        mBinding.setStudent2(mStudent_binding);

        mStudentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        mStudentViewModel.getStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                String string = "";
                for (int i = 0; i < students.size(); i++) {
                    string = string + "\n" + students.get(i).toString();
                }
                mBinding.tvStudentInfo.setText(string);

                mBinding.setStudent1(mStudent_binding);
                mBinding.setStudent2(mStudent_binding);
            }
        });
    }

    public void updateStudentInfo(View view) {
        // 点击更新数据属于业务逻辑应放在ViewModel中处理

        final MutableLiveData<List<Student>> students = mStudentViewModel.getStudents();
        // List<Student> studentList = students.getValue(); // 得到null
        final List<Student> studentList = new ArrayList<>();
        final Student student = new Student();
        student.setName("张三" + SystemClock.currentThreadTimeMillis() % 9999);
        student.setId(((int) (SystemClock.currentThreadTimeMillis() % 99)));
        studentList.add(0, student);
        students.setValue(studentList);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Student student = new Student();
                student.setName("李四" + SystemClock.currentThreadTimeMillis() % 5555);
                student.setId(((int) (SystemClock.currentThreadTimeMillis() % 55)));
                studentList.add(1, student);
                students.postValue(studentList);
            }
        }, 1500);

        mStudent_binding.clear();
        mStudent_binding.addAll(studentList);
        for (int i = 0; i < mStudent_binding.size(); i++) { // 因为延迟，此时mStudent_binding.size()永远是1
            Log.d(TAG, "updateStudentInfo: " + mStudent_binding.get(i));
        }
    }
}
