package com.company;

public class Demo {
    public static void main(String[] args) {
        /**
         * [Bài tập] Tạo thread đơn giản
         */
//        NumberGenerator numberGenerator1 = new NumberGenerator();
//        NumberGenerator numberGenerator2 = new NumberGenerator();
//        Thread thread1 = new Thread(numberGenerator1);
//        Thread thread2 = new Thread(numberGenerator2);
//        thread2.setPriority(Thread.MAX_PRIORITY);
//        thread1.setPriority(Thread.MIN_PRIORITY);
//        thread1.start();
//        thread2.start();
        /**
         * [Bài tập] Hiển thị số chẵn/lẻ
         */
//        OddThread oddThread = new OddThread();
//        EvenThread evenThread = new EvenThread();
//        oddThread.start();
//        try {
//            oddThread.join();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        evenThread.start();
        /**
         * [Optional] [Bài tập] Tìm số nguyên tố
         */
        LazyPrimeFactorization lazyPrimeFactorization = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimizedPrimeFactorization = new OptimizedPrimeFactorization();
        Thread thread1 = new Thread(lazyPrimeFactorization);
        Thread thread2 = new Thread(optimizedPrimeFactorization);
        thread1.start();
        thread2.start();
    }
}
