import java.util.Scanner;

public class P05 {

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long findLCM(int a, int b) {
        int gcd = findGCD(a, b);
        return (long) (a / gcd) * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First number: ");
        int first = sc.nextInt();
        System.out.print("Enter Second number: ");
        int second = sc.nextInt();

        if (first <= 0 || second <= 0) {
            System.out.println("Invalid Input: Numbers must be positive");
            return;
        }

        int gcd = findGCD(first, second);
        long lcm = findLCM(first, second);

        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);

        sc.close();
    }
}