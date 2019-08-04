package com.yuan.mvvmdemo.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yuan.mvvmdemo.model.imagemodel.Data;
import com.yuan.mvvmdemo.model.imagemodel.ImageBean;
import com.yuan.mvvmdemo.model.imagemodel.Root;
import com.yuan.mvvmdemo.repertory.ImageRepertory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ImageViewModel extends ViewModel {
    private static final String TAG = "ImageViewModel";
    // MutableLiveData<Data<Root>> mImage; // todo Retrofit返回的是Root，但xml中绑定的是Image
    MutableLiveData<Data<ImageBean>> mImage;
    private ImageRepertory mRepertory;
    private int idx;

    public ImageViewModel() {
        Log.d(TAG, "ImageViewModel: ");
        mImage = new MutableLiveData<>();
        mRepertory = new ImageRepertory();
        idx = 0;
    }

    public MutableLiveData<Data<ImageBean>> getImage() {
        return mImage;
    }

    public void LoadImage() {
        mRepertory.getImage("js", idx, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Root>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Root root) {
                        Log.d(TAG, "onNext: " + root);
                        // TODO: 2019/8/4 将得到Root转化为Data<Images>
                        mImage.setValue(new Data<ImageBean>(
                                root.getImages().get(0), null
                        ));
                    }

                    @Override
                    public void onError(Throwable e) {
                        mImage.setValue(new Data<ImageBean>(
                                null, e.getMessage()
                        ));
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void nextImage() {
        mRepertory.getImage("js", ++idx, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Root>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Root root) {
                        mImage.setValue(new Data<ImageBean>(
                                root.getImages().get(0), null
                        ));
                    }

                    @Override
                    public void onError(Throwable e) {
                        mImage.setValue(new Data<ImageBean>(
                                null, e.getMessage()
                        ));
                        idx--;
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void previousImage() {
        if (idx <= 0) {
            mImage.setValue(new Data<ImageBean>(
                    null, "已经是第一个了"
            ));
            return;
        }
        mRepertory.getImage("js", --idx, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Root>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Root root) {
                        mImage.setValue(new Data<ImageBean>(
                                root.getImages().get(0), null
                        ));
                    }

                    @Override
                    public void onError(Throwable e) {
                        mImage.setValue(new Data<ImageBean>(
                                null, e.getMessage()
                        ));
                        idx++;
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
