package BaiTap;

public class JoinArray {
    public static void main(String[] args) {
        int[] arr1 = {10, 3, 5, 4, 5, 0};
        int[] arr2 = {11, 2, 1, 2, 9, 0};
        int[] arr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr.length; i++) {
            if (i < arr1.length) {
                arr[i] = arr1[i];
            } else {
                arr[i] = arr2[i - arr1.length];
            }
        }
        System.out.print("Array 1: ");
        for (int k :
                arr1) {
            System.out.print(k + " ");
        }
        System.out.print("\nArray 2: ");
        for (int k :
                arr2) {
            System.out.print(k + " ");
        }
        System.out.print("\nArray 1 + 2: ");
        for (int k :
                arr) {
            System.out.print(k + " ");
        }
    }
}
