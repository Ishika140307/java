import java.util.Scanner;

public class P04{

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = sc.nextInt();

        if (num < 1) {
            System.out.println("Invalid Input: Number must be >= 1");
            return;
        }

        if (num == 1) {
            System.out.println("Prime factorization: 1 has no prime factors");
            return;
        }

        int n = num;
        System.out.print("Prime factorization: ");
        boolean first = true;

        for (int factor = 2; factor * factor <= n; factor++) {
            if (n % factor == 0 && isPrime(factor)) {
                int count = 0;
                while (n % factor == 0) {
                    n /= factor;
                    count++;
                }
                if (!first) {
                    System.out.print(" x ");
                }
                System.out.print(factor + "^" + count);
                first = false;
            }
        }

        if (n > 1) {
            if (!first) {
                System.out.print(" x ");
            }
            System.out.print(n + "^1");
        }

        System.out.println();
        sc.close();
    }
}