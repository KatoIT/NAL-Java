package com.company;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static PhoneManager phoneManager = new PhoneManager();

    public static void main(String[] args) {
        int choose;
        while (true) {
            showMenu();
            choose = scanner.nextInt();
            switch (choose) {
                case 1 -> addPhone();
                case 2 -> deletePhone();
                case 3 -> phoneManager.showPhoneList();
                case 4 -> searchPhone();
                case 5 -> {
                    System.out.println("Bye bye!!!");
                    return;
                }
                default -> System.out.println("Chức năng không có trong menu!");
            }
        }
    }

    /**
     * functions in menu
     */
    public static void addPhone() {
        int chooseRequestAddPhone;
        int id = phoneManager.autoIncrementId();
        String name = inputName();
        double price = inputPrice();
        int quantity = inputQuantity();
        String producer = inputProducer();
        while (true) {
            showMenuAddPhone();
            chooseRequestAddPhone = scanner.nextInt();

            switch (chooseRequestAddPhone) {
                case 1 -> {
                    int warrantyPeriod = inputWarrantyPeriod();
                    String warrantyCoverage = inputWarrantyCoverage();
                    if (phoneManager.insertPhone(
                            new GenuinePhone(id,
                                    name,
                                    price,
                                    quantity,
                                    producer,
                                    warrantyPeriod,
                                    warrantyCoverage))) {
                        System.out.println("Thêm thành công!");
                    } else {
                        System.out.println("Thêm thất bại!");
                    }
                    return;
                }
                case 2 -> {
                    String country = inputCountry();
                    String status = inputStatus();
                    if (phoneManager.insertPhone(
                            new CellPhone(id,
                                    name,
                                    price,
                                    quantity,
                                    producer,
                                    country,
                                    status))) {
                        System.out.println("Thêm thành công!");
                    } else {
                        System.out.println("Thêm thất bại!");
                    }
                    return;
                }
                case 0 -> {
                    System.out.println("Hủy thêm điện thoại!");
                    return;
                }
                default -> System.out.println("Chức năng không có trong menu!");
            }

        }


    }

    public static void deletePhone() {
        try {
            System.out.println("ID điện thoại cần xóa: ");
            int phoneIdToDelete = scanner.nextInt();
            Phone phoneWantDelete = phoneManager.findById(phoneIdToDelete);
            if (phoneWantDelete != null) {
                System.out.println("Điện thoại có ID = " + phoneIdToDelete);
                phoneWantDelete.show();
                System.out.println("Bạn chắc chắn muốn xóa: 1-Yes | 2-No");
                System.out.println("Chọn: ");
                int chooseConfirm = scanner.nextInt();
                if (chooseConfirm == 1) {
                    if (phoneManager.deletePhone(phoneWantDelete)) {
                        System.out.println("Delete successful!");
                    } else {
                        System.out.println("Delete fail!");
                    }
                }
            } else {
                throw new NotFoundProductException("ID điện thoại không tồn tại.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchPhone() {
        System.out.println("Enter text serch:");
        scanner.nextLine();
        String textSearch = scanner.nextLine();
        List<Phone> phoneListAnswer = phoneManager.approximateSearch(textSearch);
        for (Phone phone : phoneListAnswer) {
            phone.show();
        }
    }


    /**
     * Show
     */
    public static void showMenu() {
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Thêm mới");
        System.out.println("2. Xóa");
        System.out.println("3. Xem danh sách điện thoại");
        System.out.println("4. Tìm kiếm");
        System.out.println("5. Thoát");
        System.out.println("Chọn chức năng:");
    }

    public static void showMenuAddPhone() {
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Đây là điện thoại chính hãng");
        System.out.println("2. Đây là điện thoại xách tay");
        System.out.println("0. Trở về");
        System.out.println("Chọn: ");
    }

    /**
     * Input
     */
    public static String inputName() {
        System.out.println("Tên điện thoại: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static double inputPrice() {
        System.out.println("Giá bán: ");
        double price = scanner.nextDouble();
        while (price < 0) {
            System.out.println("Giá bán phải là số dương: ");
            price = scanner.nextInt();
        }
        return price;
    }

    public static int inputQuantity() {
        System.out.println("Số lượng: ");
        int quantity = scanner.nextInt();
        while (quantity < 0) {
            System.out.println("Số lượng phải là số dương: ");
            quantity = scanner.nextInt();
        }
        return quantity;
    }

    public static String inputProducer() {
        System.out.println("Nhà sản xuất: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static String inputCountry() {
        System.out.println("Quốc gia xách tay: ");
        scanner.nextLine();
        String country = scanner.nextLine();
        while (country.equals("Viet Nam")) {
            System.out.println("Quôc gia xách tay không thể là 'Viet Nam': ");
            country = scanner.nextLine();
        }
        return country;
    }

    public static String inputStatus() {
        System.out.println("Trang thai: ");
        String status = scanner.nextLine();
        while (!status.equals("Da sua chua") && !status.equals("Chua sua chua")) {
            System.out.println("Trạng thái phải là 'Chua sua chua' hoặc 'Da sua chua': ");
            status = scanner.nextLine();
        }
        return status;
    }

    public static int inputWarrantyPeriod() {
        System.out.println("Thời gian bảo hành: ");
        int warrantyPeriod = scanner.nextInt();
        while (warrantyPeriod < 0 || warrantyPeriod > 730) {
            System.out.println("Thời gian bảo hành phải nằm trong khoảng 0 -> 730: ");
            warrantyPeriod = scanner.nextInt();
        }
        return warrantyPeriod;
    }

    public static String inputWarrantyCoverage() {
        System.out.println("Phạm vi bảo hành: ");
        scanner.nextLine();
        String warrantyCoverage = scanner.nextLine();
        while (!warrantyCoverage.equals("Toan Quoc") && !warrantyCoverage.equals("Quoc Te")) {
            System.out.println("Phạm vi bảo hành phải là 'Toan Quoc' hoặc 'Quoc Te': ");
            warrantyCoverage = scanner.nextLine();
        }
        return warrantyCoverage;
    }
}
