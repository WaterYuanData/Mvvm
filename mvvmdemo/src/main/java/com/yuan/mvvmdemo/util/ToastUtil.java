package com.yuan.mvvmdemo.util;

import android.widget.Toast;

import com.yuan.mvvmdemo.App;

public class ToastUtil {

    public static void show(String message) {
        Toast.makeText(App.getInstance(), message, Toast.LENGTH_SHORT).show();
    }
}
