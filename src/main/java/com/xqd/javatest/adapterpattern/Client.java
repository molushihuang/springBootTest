package com.xqd.javatest.adapterpattern;

public class Client {


    public static void main(String[] args) {

        Target concreteTarget=new ConcreteTarget();
        concreteTarget.targetMethod();

        Target target = new Adapter();
        target.targetMethod();
    }
}
