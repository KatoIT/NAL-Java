package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int a = 50000;
        double sum1 = 0.0;
        double sum2 = 0.0;
        for (int i = 1; i <= a; i++) {
            sum1 += 1.0 / i;
        }
        for (int i = a; i > 0; i--) {
            sum2 += 1.0 / i;
        }
        System.out.println(sum1 - sum2);
    }
}
