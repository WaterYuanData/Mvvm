package com.yuan.mvvm.viewmodel;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.yuan.mvvm.App;
import com.yuan.mvvm.databinding.MainActivity;

public class MyClick {
    private static final String TAG = "MyClick";

    public void jumpMain(View view) {
        Log.d(TAG, "jumpMain: ");
        // Calling startActivity() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag
        Intent intent = new Intent(App.getInstance(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        App.getInstance().startActivity(intent);
    }
}
