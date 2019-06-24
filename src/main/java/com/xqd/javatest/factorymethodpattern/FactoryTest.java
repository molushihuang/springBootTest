package com.xqd.javatest.factorymethodpattern;

class FactoryTest {

    public static void main(String[] args) {

        Factory factory = new IDCardFactory();

        Product idCard1 = factory.create("sada");
        Product idCard2 = factory.create("sds");
        Product idCard3 = factory.create("jhh");

        idCard1.use();
        idCard2.use();
        idCard3.use();

    }
}
