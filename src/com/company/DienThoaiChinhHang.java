package com.company;

public class DienThoaiChinhHang extends DienThoai {
    int warrantyPeriod;
    String location;

    public DienThoaiChinhHang(int id, String name, double price, int qty, String provide, int warrantyPeriod, String location) {
        super(id, name, price, qty, provide);
        this.warrantyPeriod = warrantyPeriod;
        this.location = location;
    }

    @Override
    void display() {
        System.out.println("Diện Thoại CH: ");
        System.out.print(this.id + ", ");
        System.out.print(this.name + ", ");
        System.out.print(this.price + ", ");
        System.out.print(this.qty + ", ");
        System.out.print(this.provide + ", ");
        System.out.print(this.warrantyPeriod + ", ");
        System.out.println(this.location);
    }
    @Override
    public String toString() {
        return id +
                "," + name +
                "," + price +
                "," + qty +
                "," + provide +
                "," + warrantyPeriod +
                "," + location;
    }
}
