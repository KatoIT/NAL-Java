package BaiTap;

import java.util.Scanner;

public class SumOnMainDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input size matrix
        System.out.print("Enter size matrix Square: ");
        int size = scanner.nextInt();
        int[][] arr = new int[size][size];
        // Create matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = (int) Math.floor(Math.random() * (101) + 0);
            }
        }
        System.out.println("Array:");
        for (int[] k : arr) {
            for (int h : k) {
                System.out.print(h + " ");
            }
            System.out.println("");
        }
        // Sum
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i][i];
        }
        System.out.print("Sum = " + sum);
        scanner.close();
    }
}
