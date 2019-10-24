package com.xqd.javatest.singletonpattern;

class SingletonTest {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

    }
}
