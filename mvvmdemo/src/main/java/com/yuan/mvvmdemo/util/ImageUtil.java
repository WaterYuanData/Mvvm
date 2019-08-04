package com.yuan.mvvmdemo.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageUtil {
    @BindingAdapter({"myPic"}) // todo @BindingAdapter("myPic")缺少{}会报错
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView).load(url).into((imageView));
    }
}
