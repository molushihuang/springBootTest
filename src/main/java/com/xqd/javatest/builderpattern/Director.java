package com.xqd.javatest.builderpattern;

/**
 * Created by 谢邱东 on 2019/11/22 10:36.
 * NO bug
 */

class Director {
    private Builder mBuilder;

    public Director(Builder builder){
        mBuilder=builder;
    }

    public void construct(){
        mBuilder.makeTitle("good");
        mBuilder.makeString("from morning till afternoon");
        mBuilder.makeItems(new String[]{"good morning","good afternoon"});
        mBuilder.makeString("at night");
        mBuilder.makeItems(new String[]{"good evening","good night"});
        mBuilder.close();
    }
}
