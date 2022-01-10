package BaiTap;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount (USD): ");
        double USD = sc.nextDouble();
        int UsdToVnd = 23000;
        double VND = USD * UsdToVnd;
        System.out.print(USD + " (USD) = " + VND + " (VNĐ)");
    }
}
