package com.yuan.mvvm.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import com.yuan.mvvm.R;
import com.yuan.mvvm.databinding.ActivityMain2Binding;
import com.yuan.mvvm.viewmodel.bean.Student;
import com.yuan.mvvm.viewmodel.bean.StudentViewModel;

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

        // 通过binding将将点击事件设置到xml中
        mBinding.setMyClick(new MyClick()); // todo 遗漏将导致点击无效

        // 通过binding将数据设置到xml中
        // TODO: 2019/8/4 数据初始化应优化为通过ViewModel的set进行
        mStudent_binding = new ObservableArrayList<>();
        for (int i = 0; i < 2; i++) {
            Student student = new Student();
            student.setName("y" + SystemClock.currentThreadTimeMillis() % 7777);
            mStudent_binding.add(student);
        }
        mBinding.setStudent1(mStudent_binding);
        mBinding.setStudent2(mStudent_binding);

        // 创建ViewModel对象
        mStudentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        /*
        得到ViewModel对象持有的MutableLiveData对象，
        将MutableLiveData对象绑定到当前生命周期控件，
        观察MutableLiveData对象中数据的变化，
        将更新后的数据通过binding设置到xml中进行显示，
        更新逻辑在VM层中进行，此V层只是显示，
        */
        mStudentViewModel.getStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> studentList) {
                // 观察到数据变化，将新数据设置到xml进行显示
                String string = "";
                for (int i = 0; i < studentList.size(); i++) {
                    string = string + "\n" + studentList.get(i).toString();
                }
                // 仅绑定id，通过set赋值
                mBinding.tvStudentInfo.setText(string);

                /*
'setStudent1(androidx.databinding.ObservableList<com.yuan.mvvm.viewmodel.bean.Student>)' in
'cannot be applied to '(java.util.List<com.yuan.mvvm.viewmodel.bean.Student>)'
                * */
                // mBinding.setStudent1(studentList);
                // 绑定variable，通过'@{student2[0].name+" "+student2[1].name}'赋值
                mBinding.setStudent2(studentList);
            }
        });
    }

    public void updateStudentInfo(View view) {
        mStudentViewModel.update();
    }
}
