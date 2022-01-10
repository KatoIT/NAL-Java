package BaiTap;

import java.util.Scanner;

public class DeleteElement {
    public static int[] deleteArray(int[] array, int index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Array: ");
        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.print("\nEnter the number you want to delete:");
        int number = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                arr = deleteArray(arr, i);
                break;
            }
        }
        System.out.print("Array: ");
        for (int k : arr) {
            System.out.print(k + " ");
        }
    }
}
