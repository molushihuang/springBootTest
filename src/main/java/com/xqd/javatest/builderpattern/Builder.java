package com.xqd.javatest.builderpattern;

/**
 * Created by 谢邱东 on 2019/11/22 10:20.
 * NO bug
 */

public abstract class Builder {

    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();

}
