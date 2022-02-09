package com.company;

abstract class Phone {
    int id;
    String name;
    double price;
    int quantity;
    String producer;

    Phone(int id, String name, double price, int quantity, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.producer = producer;
    }

    abstract void show();

    @Override
    public String toString() {
        return id +
                "," + name +
                "," + price +
                "," + quantity +
                "," + producer;
    }
}
