package com.xqd.javatest.factorymethodpattern;

import java.util.HashMap;

public class IDCardFactory extends Factory {
    private int serial = 100;
    private HashMap data = new HashMap();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        IDCard idCard = (IDCard) product;
        data.put(idCard.getSerial(), idCard.getOwner());
    }
}
