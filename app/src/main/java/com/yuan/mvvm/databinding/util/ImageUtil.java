package com.yuan.mvvm.databinding.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageUtil {

    // @BindingAdapter("image") 错误：未带{}
    @BindingAdapter({"myImg"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view).load(url).into(view);
    }
}
