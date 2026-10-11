import java.util.Scanner;

public class P2 {

    public static int findSecondLargestDistinctDigit(int number) {
        int largest = -1;
        int secondLargest = -1;
        number = Math.abs(number);

        if (number == 0) {
            largest = 0;
        }

        while (number > 0) {
            int digit = number % 10;

            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit < largest && digit > secondLargest) {
                secondLargest = digit;
            }
            number /= 10;
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Invalid Input: Please enter a positive integer.");
            return;
        }

        int result = findSecondLargestDistinctDigit(num);

        if (result == -1) {
            System.out.println("No second largest distinct digit exists - fewer than two distinct digits.");
        } else {
            System.out.println("Second-largest distinct digit: " + result);
        }
        sc.close();
    }
}