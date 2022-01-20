package com.company;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();
        int[] frequentChar = new int[255];                          //{1}
        for (int i = 0; i < inputString.length(); i++) {            //{2}
            /* Tìm ví trí tương ứng của ký tự trong bảng ASCII */
            int ascii = inputString.charAt(i);                      //{3}
            /* Tăng giá trị tần suất */
            frequentChar[ascii] += 1;                               //{4}
        }
        int max = 0;                                                //{5}
        char character = (char) 255; /* empty character */          //{6}
        for (int j = 0; j < 255; j++) {                             //{7}
            if (frequentChar[j] > max) {                            //{8}
                max = frequentChar[j];                              //{9}
                character = (char) j;                               //{10}
            }
        }
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
    }
}
/*
* C1 = O(1)
* C2 = O(n)
* C3 = O(1)
* C4 = O(1)
* C5 = O(1)
* C6 = O(1)
* C7 = O(255)
* C8 = O(1)
* C9 = O(1)
* C10 = O(1)
*
* Ta sẽ có 2 trường hợp
* TH1: n <= 255
* Khi đó độ phức tạp của thuật toán  sẽ là thời gian thực hiện lệnh {7} và bằng O(255)
* TH2: n> 255
* Khi đó độ phức tạp của thuật toán  sẽ là thời gian thực hiện lệnh {2} và bằng O(n)
*
* */
