package com.yuan.mvvmdemo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.yuan.mvvmdemo.R;
import com.yuan.mvvmdemo.databinding.ActivityMainBinding;
import com.yuan.mvvmdemo.model.imagemodel.Data;
import com.yuan.mvvmdemo.model.imagemodel.ImageBean;
import com.yuan.mvvmdemo.viewmodel.ImageViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding mBinding;
    private ImageViewModel mImageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mImageViewModel = ViewModelProviders.of(this).get(ImageViewModel.class);
        mImageViewModel.getImage().observe(this, new Observer<Data<ImageBean>>() {
            @Override
            public void onChanged(Data<ImageBean> imageBeanData) {
                String errorMsg = imageBeanData.getErrorMsg();
                Log.d(TAG, "onChanged: errorMsg=" + errorMsg);
                if (TextUtils.isEmpty(errorMsg)) {
                    ImageBean imageBean = imageBeanData.getData();
                    Log.d(TAG, "onChanged: imageBean=" + imageBean.getUrl());
                    mBinding.setImage(imageBean);
                }
            }
        });
    }

    public void load(View view) {
        mImageViewModel.LoadImage();
    }

    public void pre(View view) {
        mImageViewModel.previousImage();
    }

    public void next(View view) {
        mImageViewModel.nextImage();
    }
}
