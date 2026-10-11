import java.util.Scanner;

class Employee {
    private String employeeName;
    private int employeeId;
    private double monthlySalary;
    private int performanceRating;

    public Employee(String employeeName, int employeeId, double monthlySalary, int performanceRating) {
        if (monthlySalary < 0) {
            throw new IllegalArgumentException("Monthly salary cannot be negative");
        }
        if (performanceRating < 1 || performanceRating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.monthlySalary = monthlySalary;
        this.performanceRating = performanceRating;
    }

    public double calculateAnnualSalary() {
        return monthlySalary * 12;
    }

    public double calculateBonus() {
        double annualSalary = calculateAnnualSalary();
        if (performanceRating == 5) {
            return annualSalary * 0.20;
        } else if (performanceRating == 4) {
            return annualSalary * 0.15;
        } else if (performanceRating == 3) {
            return annualSalary * 0.10;
        } else if (performanceRating == 2) {
            return annualSalary * 0.05;
        } else {
            return 0;
        }
    }

    public double calculateTotalCompensation() {
        return calculateAnnualSalary() + calculateBonus();
    }

    public void displayDetails() {
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Annual Salary: " + calculateAnnualSalary());
        System.out.println("Annual Bonus: " + calculateBonus());
        System.out.println("Total Annual Compensation: " + calculateTotalCompensation());
    }
}

public class P08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Monthly Salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter Performance Rating (1-5): ");
        int rating = sc.nextInt();

        try {
            Employee emp = new Employee(name, id, salary, rating);
            System.out.println();
            emp.displayDetails();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Input: " + e.getMessage());
        }

        sc.close();
    }
}