package com.xqd.javatest.singletonpattern;

class Singleton {
    private static Singleton ourInstance = null;
    private Singleton() {
        //构造方法一定要是private，这样能确保在外部不会生成实例
        System.out.println("生成了一个实例");
    }

    //synchronized 确保线程安全
    public static synchronized Singleton getInstance() {
        if (ourInstance == null) {
            ourInstance = new Singleton();
        }
        return ourInstance;
    }


}
