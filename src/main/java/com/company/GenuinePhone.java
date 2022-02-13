package com.company;

public class GenuinePhone extends Phone {
    int warrantyPeriod;
    String warrantyCoverage;

    public GenuinePhone(int id, String name, double price, int quantity, String producer, int warrantyPeriod, String warrantyCoverage) {
        super("genuine", id, name, price, quantity, producer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyCoverage = warrantyCoverage;
    }

    @Override
    void show() {
        System.out.println("\n>>> Hàng chính hãng <<<");
        System.out.println("| Mã sản phẩm: " + this.id);
        System.out.println("| Tên sản phẩm: " + this.name);
        System.out.println("| Giá sản phẩm: " + this.price);
        System.out.println("| Số lượng: " + this.quantity);
        System.out.println("| Nhà sản xuất: " + this.producer);
        System.out.println("| Thời gian bảo hành: " + this.warrantyPeriod + " ngày");
        System.out.println("| Phạm vi bảo hành: " + this.warrantyCoverage);
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + warrantyPeriod +
                "," + warrantyCoverage;
    }
}
