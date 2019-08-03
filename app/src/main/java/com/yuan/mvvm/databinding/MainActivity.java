package com.yuan.mvvm.databinding;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yuan.mvvm.R;
import com.yuan.mvvm.databinding.adapter.User2Adapter;
import com.yuan.mvvm.databinding.bean.User;
import com.yuan.mvvm.databinding.bean.User2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String imageUrl = "http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg";
    String imageUrl2 = "https://upload-images.jianshu.io/upload_images/9601136-364eb1ba9b574842.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/885/format/webp";
    String imageUrl3 = "https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg";
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User();
        user.setName("小样儿");
        user.setId(2);
        mBinding.setUser(user);

        // xml中绑定Activity中的方法
        mBinding.setMActivity(this);

        // ImageUtil.loadImage(mBinding.ivImg, imageUri3);
        mBinding.setImgUrl(imageUrl3);

        List<User2> user2List = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User2 user2 = new User2();
            user2.name.set("张" + i + "三");
            user2.age.set(i);
            user2.isStudent.set(i % 3 == 0);
            user2List.add(user2);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplication(), RecyclerView.VERTICAL, false);
        mBinding.rvUser2.setLayoutManager(linearLayoutManager);
        mBinding.rvUser2.setAdapter(new User2Adapter(user2List));
        // Caused by: org.apache.xerces.impl.io.MalformedByteSequenceException: Invalid byte 3 of 3-byte UTF-8 sequence.

    }

    public void hideClick(View view) {
        User user = mBinding.getUser();
        user.setStudent(!user.isStudent());
        mBinding.setUser(user);
    }
}
