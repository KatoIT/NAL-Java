package com.company;

public class CellPhone extends Phone {
    String country;
    String status;

    public CellPhone(int id, String name, double price, int quantity, String provide, String country, String status) {
        super(id, name, price, quantity, provide);
        this.country = country;
        this.status = status;
    }

    @Override
    void show() {
        System.out.println("\n>>> Điện thoại xách tay <<<");
        System.out.println("| Mã sản phẩm: " + this.id);
        System.out.println("| Tên sản phẩm: " + this.name);
        System.out.println("| Giá sản phẩm: " + this.price);
        System.out.println("| Số lượng: " + this.quantity);
        System.out.println("| Nhà sản xuất: " + this.producer);
        System.out.println("| Quốc gia xách tay: " + this.country);
        System.out.println("| Trạng thái: " + this.status);
    }

    @Override
    public String toString() {
        return id +
                "," + name +
                "," + price +
                "," + quantity +
                ",'" + producer +
                "," + country +
                "," + status;
    }
}
