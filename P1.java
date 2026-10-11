import java.util.Scanner;

public class P1{

   
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

            number = number / 10;
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = sc.nextInt();

        int result = findSecondLargestDistinctDigit(num);

        if (result == -1) {
            System.out.println("No second largest distinct digit exists (fewer than two distinct digits).");
        } else {
            System.out.println("Second-largest distinct digit: " + result);
        }
        
        
        System.out.println("\n--- Additional Test Cases ---");
        int[] tests = {7777, 1221, 1000, 987654, 985998};
        for(int t : tests) {
            int r = findSecondLargestDistinctDigit(t);
            if(r == -1) System.out.println(t + " -> No second largest distinct digit");
            else System.out.println(t + " -> Second-largest: " + r);
        }

        sc.close();
    }
}