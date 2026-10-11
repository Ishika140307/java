import java.util.Scanner;

class Student {
    private String studentName;
    private int rollNumber;
    private int mark1;
    private int mark2;
    private int mark3;
    private int mark4;
    private int mark5;

    public Student(String studentName, int rollNumber, int mark1, int mark2, int mark3, int mark4, int mark5) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.mark1 = validateMark(mark1);
        this.mark2 = validateMark(mark2);
        this.mark3 = validateMark(mark3);
        this.mark4 = validateMark(mark4);
        this.mark5 = validateMark(mark5);
    }

    private int validateMark(int mark) {
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("Mark must be between 0 and 100. Found: " + mark);
        }
        return mark;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public int calculateTotal() {
        return mark1 + mark2 + mark3 + mark4 + mark5;
    }

    public double calculatePercentage() {
        return calculateTotal() / 5.0;
    }

    public boolean isPass() {
        return mark1 >= 40 && mark2 >= 40 && mark3 >= 40 && mark4 >= 40 && mark5 >= 40;
    }

    public void displayResult() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Total Marks: " + calculateTotal() + "/500");
        System.out.println("Percentage: " + calculatePercentage() + "%");
        if (isPass()) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}

public class P06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();

        System.out.print("Enter 5 subject marks separated by space: ");
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int m4 = sc.nextInt();
        int m5 = sc.nextInt();

        try {
            Student student = new Student(name, rollNo, m1, m2, m3, m4, m5);
            System.out.println();
            student.displayResult();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Input: " + e.getMessage());
        }

        sc.close();
    }
}