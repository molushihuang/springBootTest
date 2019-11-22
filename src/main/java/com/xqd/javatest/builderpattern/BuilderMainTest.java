package com.xqd.javatest.builderpattern;

/**
 * Created by 谢邱东 on 2019/11/22 10:41.
 * NO bug
 */

class BuilderMainTest {

    public static void main(String[] args) {
        TextBuilder textBuilder = new TextBuilder();
        new Director(textBuilder).construct();
        System.out.println(textBuilder.getResult());

    }
}
