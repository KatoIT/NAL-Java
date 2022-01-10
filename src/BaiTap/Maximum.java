package BaiTap;

public class Maximum {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {1, 2, 3}};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println("Array:");
        for (int[] k : arr) {
            for (int h : k) {
                System.out.print(h + " ");
            }
            System.out.println("");
        }
        System.out.print("\nMax = " + max);
    }
}
