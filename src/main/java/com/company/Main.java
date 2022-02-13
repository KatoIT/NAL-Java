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
    public static boolean addPhone() {
        int chooseRequestAddPhone;
        int id = phoneManager.autoIncrementId();
        //
        System.out.println("Tên điện thoại: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        //
        System.out.println("Giá bán: ");
        double price = scanner.nextDouble();
        //
        System.out.println("Số lượng: ");
        int quantity = scanner.nextInt();
        //
        System.out.println("Nhà sản xuất: ");
        scanner.nextLine();
        String producer = scanner.nextLine();
        while (true) {
            showMenuAddPhone();
            chooseRequestAddPhone = scanner.nextInt();

            switch (chooseRequestAddPhone) {
                case 1 -> {
                    //
                    System.out.println("Thời gian bảo hành: ");
                    int warrantyPeriod = scanner.nextInt();
                    //
                    System.out.println("Phạm vi bảo hành: ");
                    scanner.nextLine();
                    String warrantyCoverage = scanner.nextLine();
                    if (validatePrice(price) &&
                            validateQuantity(quantity) &&
                            validateWarrantyPeriod(warrantyPeriod) &&
                            validateWarrantyCoverage(warrantyCoverage)
                    ) {
                        if (phoneManager.insertPhone(
                                new GenuinePhone(id,
                                        name,
                                        price,
                                        quantity,
                                        producer,
                                        warrantyPeriod,
                                        warrantyCoverage))) {
                            System.out.println("Thêm thành công!");
                            return true;
                        }
                    }
                    System.err.println("Thêm thất bại!");
                    return false;
                }
                case 2 -> {
                    //
                    System.out.println("Quốc gia xách tay: ");
                    scanner.nextLine();
                    String country = scanner.nextLine();
                    //
                    System.out.println("Trang thai: ");
                    String status = scanner.nextLine();
                    if (validatePrice(price) &&
                            validateQuantity(quantity) &&
                            validateCountry(country) &&
                            validateStatus(status)
                    ) {
                        if (phoneManager.insertPhone(
                                new CellPhone(id,
                                        name,
                                        price,
                                        quantity,
                                        producer,
                                        country,
                                        status))) {
                            System.out.println("Thêm thành công!");
                            return true;
                        }
                    }
                    System.err.println("Thêm thất bại!");
                    return false;
                }
                case 0 -> {
                    System.out.println("Hủy thêm điện thoại!");
                    return false;
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
        System.out.println("#####################################");
        System.out.println("#     Quản        Điện           ❤ #");
        System.out.println("#            Lý           Thoại     #");
        System.out.println("#####################################");
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
     * Validate Input
     */
    public static boolean validatePrice(double price) {
        if (price < 0)
            System.err.println("Giá bán phải lớn hơn hoặc bằng 0!");
        return price >= 0;
    }

    public static boolean validateQuantity(int quantity) {
        if (quantity < 0)
            System.err.println("Số lượng phải lớn hơn hoặc bằng 0!");
        return quantity >= 0;
    }

    public static boolean validateCountry(String country) {
        if (country.equals("Viet Nam"))
            System.err.println("Quôc gia xách tay không thể là 'Viet Nam'");
        return !country.equals("Viet Nam");
    }

    public static boolean validateStatus(String status) {
        if (!status.equals("Da sua chua") && !status.equals("Chua sua chua")) {
            System.err.println("Trạng thái phải là 'Chua sua chua' hoặc 'Da sua chua'");
            return false;
        }
        return true;
    }

    public static boolean validateWarrantyPeriod(int warrantyPeriod) {
        if (warrantyPeriod < 0)
            System.err.println("Thời gian bảo hành phải lớn hơn hoặc bằng 0!");
        else if (warrantyPeriod > 730)
            System.err.println("Thời gian bảo hành phải nhỏ hơn hoặc bằng 730!");
        return warrantyPeriod >= 0 && warrantyPeriod <= 730;
    }

    public static boolean validateWarrantyCoverage(String warrantyCoverage) {
        if (!warrantyCoverage.equals("Toan Quoc") && !warrantyCoverage.equals("Quoc Te")) {
            System.err.println("Phạm vi bảo hành phải là 'Toan Quoc' hoặc 'Quoc Te'");
            return false;
        }
        return true;
    }

}
