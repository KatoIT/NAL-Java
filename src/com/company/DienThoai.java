package com.company;

abstract class DienThoai {
    int id;
    String name;
    double price;
    int qty;
    String provide;

    public DienThoai(int id, String name, double price, int qty, String provide) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.provide = provide;
    }

    abstract void display();

    @Override
    public String toString() {
        return id +
                ", " + name +
                ", " + price +
                ", " + qty +
                ", " + provide;
    }
}
