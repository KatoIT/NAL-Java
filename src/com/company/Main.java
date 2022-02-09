package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Service service = new Service();
        int choose = 0;
        Scanner sc = new Scanner(System.in);
        while (choose != 5) {
            displayMenu1();
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    displayMenu2();
                    int dtch = sc.nextInt();
                    switch (dtch) {
                        case 1:
                            service.addDTCH(sc);
                            break;
                        case 2:
                            service.addDTXT(sc);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Id Dien thoai can xoa:");
                    int id = sc.nextInt();
                    if (service.checkDT(id)) {
                        System.out.println("Xac Nhan xoa(1-Yes, 2-No):");
                        int choose2 = sc.nextInt();
                        if (choose2 == 1) {
                            service.deleteDT(id);
                        }
                    }
                    break;
                case 3:
                    service.display();
                    break;
                case 4:
                    System.out.println("Enter text serch:");
                    sc.nextLine();
                    String textSearch = sc.nextLine();
                    if (isNumeric(textSearch)) {
                        service.findById(Integer.parseInt(textSearch)).display();
                    } else {
                        service.findByName(textSearch).display();
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Chọn chức năng:");
            }
        }
    }

    public static void displayMenu1() {
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Thêm mới");
        System.out.println("2. Xóa");
        System.out.println("3. Xem danh sách điện thoại");
        System.out.println("4. Tìm kiếm");
        System.out.println("5. Thoát");
        System.out.println("Chọn chức năng");
    }

    public static void displayMenu2() {
        System.out.println("Chọn chức Loaij DT can them:");
        System.out.println("1. Dien Thoai CH");
        System.out.println("2. Dien Thoai XT");
        System.out.println("Chọn");
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
