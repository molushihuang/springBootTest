package com.xqd.javatest.iteratorpattern;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements BookIterator {

    private List<Book> books;

    public BookShelf(List<Book> books) {
        this.books = books;
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("asda", "斯蒂芬森"));
        books.add(new Book("assadadda", "地方"));
        books.add(new Book("nmmg", "是否是"));

        BookShelf bookShelf = new BookShelf(books);
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName() + ":" + book.getPerson());
        }
    }

    @Override
    public Iterator iterator() {
        return new DealIterator(books);
    }
}
