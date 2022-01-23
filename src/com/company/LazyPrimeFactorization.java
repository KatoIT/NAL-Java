package com.company;

public class LazyPrimeFactorization implements Runnable {
    @Override
    public void run() {
        for (int number = 0; number < 10000; number++) {
            if (isPrime(number)) {
                System.out.println("Prime (Lazy): " + number);
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
