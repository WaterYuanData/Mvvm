package com.yuan.mvvm.databinding.util;

import android.widget.Toast;

import com.yuan.mvvm.App;

public class ToastUtil {

    public static void show(String message) {
        Toast.makeText(App.getInstance(), message, Toast.LENGTH_SHORT).show();
    }
}
