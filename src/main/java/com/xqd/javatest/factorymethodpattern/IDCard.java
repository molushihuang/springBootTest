package com.xqd.javatest.factorymethodpattern;

public  class IDCard extends Product {

    private String owner;
    private int serial;

    public IDCard(String owner,int serial){
        this.owner=owner;
        this.serial=serial;
        System.out.println("制作"+owner+"("+serial+")的id卡");

    }

    public String getOwner() {
        return owner;
    }

    public int getSerial() {
        return serial;
    }

    @Override
    public void use() {

        System.out.println("使用"+owner+"("+serial+")的id卡");

    }
}
