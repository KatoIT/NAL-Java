package BaiTap;

import java.util.Scanner;

public class InsertElement {
    public static int[] insertArray(int[] array, int index, int value) {
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9, 0, 0, 0, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Array: ");
        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.print("\nEnter the number you want to insert:");
        int number = scanner.nextInt();
        System.out.print("Enter the location you want to insert:");
        int index = scanner.nextInt();
        arr = insertArray(arr, index, number);
        System.out.print("Array: ");
        for (int k : arr) {
            System.out.print(k + " ");
        }
    }
}
