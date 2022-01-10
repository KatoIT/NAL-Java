package BaiTap;

import java.util.Scanner;

public class SumOnColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input size matrix
        System.out.print("Enter column number: ");
        int col = scanner.nextInt();
        System.out.print("Enter row number: ");
        int row = scanner.nextInt();
        int[][] arr = new int[row][col];
        // Create matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = (int)Math.floor(Math.random()*(101)+0);
            }
        }
        System.out.println("Array:");
        for (int[] k : arr) {
            for (int h : k) {
                System.out.print(h + " ");
            }
            System.out.println("");
        }

        System.out.print("\nEnter column [0, " + (col - 1) + "] select: ");
        int columnSelected = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += arr[i][columnSelected];
        }

        System.out.print("\nSum = " + sum);
    }
}
