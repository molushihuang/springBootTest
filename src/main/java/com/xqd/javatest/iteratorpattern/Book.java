package com.xqd.javatest.iteratorpattern;

class Book {

    public Book(String name,String person){

        this.name=name;
        this.person=person;

    }

    private String name;
    private String person;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
