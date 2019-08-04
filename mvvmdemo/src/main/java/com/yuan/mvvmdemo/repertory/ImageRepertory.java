package com.yuan.mvvmdemo.repertory;

import android.util.Log;

import com.yuan.mvvmdemo.model.imagemodel.Root;
import com.yuan.mvvmdemo.util.ToastUtil;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ImageRepertory {
    private static final String TAG = "ImageRepertory";
    private final Retrofit mRetrofit;

    public ImageRepertory() {
        Log.d(TAG, "ImageRepertory: ");
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://cn.bing.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private interface Service {
        @GET("HPImageArchive.aspx")
            // Observable getImage( // 不指定泛型会报错
        Observable<Root> getImage(
                @Query("format") String format,
                @Query("idx") int idx,
                @Query("n") int n
        );
    }

    public Observable getImage(String format, int idx, int n) {
        Log.d(TAG, "getImage: idx=" + idx + " n=" + n);
        ToastUtil.show("idx=" + idx);
        return mRetrofit.create(Service.class).getImage(format, idx, n);
    }
}
