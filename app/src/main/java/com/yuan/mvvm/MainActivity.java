package com.yuan.mvvm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yuan.mvvm.databinding.ActivityMainBinding;
import com.yuan.mvvm.databinding.bean.User;
import com.yuan.mvvm.databinding.util.ImageUtil;

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
    }

    public void hideClick(View view) {
        User user = mBinding.getUser();
        user.setStudent(!user.isStudent());
        mBinding.setUser(user);
    }
}
