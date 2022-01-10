package BaiTap;

import java.util.Locale;
import java.util.Scanner;

public class CountCharInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        System.out.print("Enter Character: ");
        char c = sc.next().toLowerCase().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c == str.toLowerCase().charAt(i)) {
                count++;
            }
        }
//        System.out.println("String: " + str);
        System.out.println("Count =  " + count);
    }
}
