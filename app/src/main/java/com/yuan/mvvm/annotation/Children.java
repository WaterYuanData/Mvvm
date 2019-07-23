package com.yuan.mvvm.annotation;

public class Children extends Parent {

    public static void main(String[] args) {
        // region 注解Inherited的测试
        Class<Children> childrenClass = Children.class;
        if (childrenClass.isAnnotationPresent(TestY.class)) {
            TestY annotation = childrenClass.getAnnotation(TestY.class);
            String value = annotation.value();
            System.out.println(value);
        }
        // endregion

    }
}
