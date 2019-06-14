package com.xqd.javatest.adapterpattern;

public class ConcreteTarget implements Target {
    @Override
    public void targetMethod() {
        System.out.println("自己的业务逻辑");
    }
}
