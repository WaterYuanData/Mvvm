package com.yuan.mvvm.databinding.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageUtil {

    // @BindingAdapter("image") 错误：未带{}
    @BindingAdapter({"myImg"}) // 该标记myImg可在xml中直接使用
    public static void loadImage(ImageView view, String url) {
        Glide.with(view).load(url).into(view);
    }
}
