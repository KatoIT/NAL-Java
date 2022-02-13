package com.company;

abstract class Phone {
    String category;
    int id;
    String name;
    double price;
    int quantity;
    String producer;

    Phone(String category, int id, String name, double price, int quantity, String producer) {
        this.category = category;
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.producer = producer;
    }

    abstract void show();

    @Override
    public String toString() {
        return category +
                "," + id +
                "," + name +
                "," + price +
                "," + quantity +
                "," + producer;
    }
}
