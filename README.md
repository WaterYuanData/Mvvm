# Mvvm
1. Inherited注解的练习  
2. DataBinding的使用  
RecyclerView中使用DataBinding
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

 