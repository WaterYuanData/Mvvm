package com.yuan.mvvm.databinding.bean;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

public class User2 {
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
    public final ObservableBoolean isStudent = new ObservableBoolean();
}
