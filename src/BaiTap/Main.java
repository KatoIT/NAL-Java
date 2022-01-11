package BaiTap;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void selectionSort() {
        int size = 100000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size);
        }
        int i, j, min_idx;
        for (i = 0; i < size - 1; i++) {
            min_idx = i;
            for (j = i + 1; j < size; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int tg = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = tg;
        }
    }

    public static void main(String[] args) {
        //
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("1. QuadraticEquation");
            System.out.println("2. StopWatch");
            System.out.println("3. Fan");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                // QuadraticEquation
                case 1 -> {
                    double a, b, c;
                    System.out.println("Enter a: ");
                    a = sc.nextDouble();
                    System.out.println("Enter b: ");
                    b = sc.nextDouble();
                    System.out.println("Enter c: ");
                    c = sc.nextDouble();
                    QuadraticEquation qe = new QuadraticEquation(a, b, c);
                    if (qe.getDiscriminant() > 0) {
                        System.out.println("x1 = " + qe.getRoot1());
                        System.out.println("x2 = " + qe.getRoot2());
                    } else {
                        if (qe.getDiscriminant() == 0) {
                            System.out.println("x2 = x1 = " + qe.getRoot1());
                        } else {
                            System.out.println("The equation has no roots");
                        }
                    }
                }
                // StopWatch
                case 2 -> {
                    StopWatch st = new StopWatch();
                    st.start();
                    selectionSort();
                    st.stop();
                    System.out.println("Sorting a selection of 100,000 elements takes " + st.getElapsedTime() + " seconds");
                }
                // Fan
                case 3 -> {
                    Fan fan1 = new Fan(3,true, 10, "Yellow");
                    Fan fan2 = new Fan(2,false, 5, "Blue");
                    System.out.println(fan1.toString());
                    System.out.println(fan2.toString());
                }
                // Exit
                case 0 -> {
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("No choice!");
            }
        }
    }
}
