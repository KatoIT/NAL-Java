package com.company;

public class DienThoaiXachTay extends DienThoai {
    String country;
    String status;

    public DienThoaiXachTay(int id, String name, double price, int qty, String provide, String country, String status) {
        super(id, name, price, qty, provide);
        this.country = country;
        this.status = status;
    }

    @Override
    void display() {
        System.out.println("Diện Thoại XT: ");
        System.out.print(this.id + ", ");
        System.out.print(this.name + ", ");
        System.out.print(this.price + ", ");
        System.out.print(this.qty + ", ");
        System.out.print(this.provide + ", ");
        System.out.print(this.country + ", ");
        System.out.println(this.status);
    }

    @Override
    public String toString() {
        return id +
                "," + name +
                "," + price +
                "," + qty +
                ",'" + provide +
                "," + country +
                "," + status;
    }
}
