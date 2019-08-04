package com.yuan.mvvmdemo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

public class App extends Application {
    private static final String TAG = "App";

    public static Application getInstance() {
        return instance;
    }

    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: " + this);
        instance = this;
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        unregisterActivityLifecycleCallbacks(mActivityLifecycleCallbacks);
    }

    ActivityLifecycleCallbacks mActivityLifecycleCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Log.d(TAG, "onActivityCreated: " + activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
            Log.d(TAG, "onActivityStarted: " + activity);
        }

        @Override
        public void onActivityResumed(Activity activity) {
            Log.d(TAG, "onActivityResumed: " + activity + " getTaskId=" + activity.getTaskId());
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Log.d(TAG, "onActivityPaused: " + activity + " getTaskId=" + activity.getTaskId());
        }

        @Override
        public void onActivityStopped(Activity activity) {
            Log.d(TAG, "onActivityStopped: " + activity);
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Log.d(TAG, "onActivitySaveInstanceState: " + activity);
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            Log.d(TAG, "onActivityDestroyed: " + activity);
        }
    };
}
