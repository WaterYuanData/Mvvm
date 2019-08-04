# Mvvm
1. Inherited注解的练习  
2. DataBinding的使用  
>RecyclerView中使用DataBinding

3. LiveData和ViewModel的混合使用    
ActivityLifecycleCallbacks  
getApplicationContext就是Application本身    
>ViewModel通过MutableLiveData而对延迟变化的数据也生效

>DataBinding只是简化findViewById()及@{user.name}，数据变化后还必须set一下才生效

```
ViewModel对象持有MutableLiveData对象，
将MutableLiveData对象绑定到当前生命周期控件，
观察MutableLiveData对象中数据的变化，
将更新后的数据通过binding设置到xml中进行显示，
更新逻辑在VM层中进行，V层只是显示，
```

4. MutableLiveData与ObservableList的应用场景？    

5. System.currentTimeMillis() 与 SystemClock.currentThreadTimeMillis() 的区别

6. [Demo](https://github.com/WaterYuanData/Mvvm)    
获取Bing每日一图并显示   
[Android官方架构组件ViewModel+LiveData+DataBinding架构属于自己的MVVM](https://www.cnblogs.com/dev-njp/p/8783341.html)    
[解析网络接口返回信息](https://cn.bing.com/HPImageArchive.aspx?format=js&idx=1&n=1)

![Demo效果图](https://upload-images.jianshu.io/upload_images/9601136-95aa734a2335d0b5.gif?imageMogr2/auto-orient/strip)
