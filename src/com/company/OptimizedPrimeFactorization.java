package com.company;

public class OptimizedPrimeFactorization implements Runnable {
    @Override
    public void run() {
        for (int number = 0; number < 10000; number++) {
            if (isPrime(number)) {
                System.out.println("Prime (Optimize): " + number);
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
