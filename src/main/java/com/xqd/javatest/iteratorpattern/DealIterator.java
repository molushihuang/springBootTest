package com.xqd.javatest.iteratorpattern;

import java.util.List;

/**
 * 具体的某个迭代器，实现迭代器接口，在这个类里面，具体完成迭代器的操作
 */
public class DealIterator implements Iterator {
    private List<Book> books;
    private int index;

    public DealIterator(List<Book> books) {
        this.books = books;
        index = 0;

    }

    @Override
    public boolean hasNext() {

        if (index < books.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        Book book = books.get(index);
        index++;
        return book;
    }
}
