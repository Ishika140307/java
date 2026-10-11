import java.util.Scanner;

public class P3 {

    public static int factorial(int digit) {
        int fact = 1;
        for (int i = 1; i <= digit; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static boolean isStrongNumber(int number) {
        int originalNumber = number;
        int sumOfFactorials = 0;

        
        if (number == 0) {
            return false; 
        }

        while (number > 0) {
            int digit = number % 10;
            sumOfFactorials = sumOfFactorials + factorial(digit);
            number = number / 10;
        }

        return sumOfFactorials == originalNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Invalid Input: Please enter a positive integer.");
            return;
        }

        if (isStrongNumber(num)) {
            System.out.println(num + " is a Strong Number.");
        } else {
            System.out.println(num + " is not a Strong Number.");
        }

        System.out.println("\n--- Additional Test Cases ---");
        int[] tests = {1, 2, 123, 40585, 145};
        for (int t : tests) {
            if (isStrongNumber(t)) {
                System.out.println(t + " is a Strong Number.");
            } else {
                System.out.println(t + " is not a Strong Number.");
            }
        }

        sc.close();
    }
}