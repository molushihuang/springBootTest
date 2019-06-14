package com.xqd.javatest.templagtemethodpattern;

public class Son extends Father {
    @Override
    public void open() {
        System.out.println("打开方法");
    }

    @Override
    public void close() {
        System.out.println("关闭方法");

    }

    @Override
    public void print() {
        System.out.println("循环方法");
    }
}
