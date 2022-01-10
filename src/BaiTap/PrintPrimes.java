package BaiTap;

public class PrintPrimes {
    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i > -1; i++) {
            if (isPrime(i)){
                System.out.print(i + ", ");
                count++;
            }
            if (count==20) break;
        }
    }
}
