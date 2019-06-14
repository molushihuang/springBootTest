package com.xqd.javatest.adapterpattern;

/**
 * 适配器
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void targetMethod() {
        adapteeMethod();//自己的接口方法下面操作对方的方法
    }
}
