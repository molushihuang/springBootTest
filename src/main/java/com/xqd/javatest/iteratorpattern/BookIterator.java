package com.xqd.javatest.iteratorpattern;

/**
 * 获取迭代器的接口，某个类实现了这个接口，就能得到一个他自己的迭代器
 */
public interface BookIterator {
    public Iterator iterator();

}
