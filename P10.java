public class P10 {

    static class Employee {
        private String employeeName;
        private int employeeId;
        private double monthlySalary;

        public Employee(String employeeName, int employeeId, double monthlySalary) {
            this.employeeName = employeeName;
            this.employeeId = employeeId;
            this.monthlySalary = monthlySalary;
        }

        public double getAnnualSalary() {
            return monthlySalary * 12;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void compareSalary(Employee other) {
            if (this.getAnnualSalary() > other.getAnnualSalary()) {
                System.out.println(this.employeeName + " earns more than " + other.employeeName + ".");
            } else if (this.getAnnualSalary() < other.getAnnualSalary()) {
                System.out.println(other.employeeName + " earns more than " + this.employeeName + ".");
            } else {
                System.out.println(this.employeeName + " and " + other.employeeName + " have equal annual salaries.");
            }
        }

        public Employee getHigherPaidEmployee(Employee other) {
            if (this.getAnnualSalary() >= other.getAnnualSalary()) return this;
            else return other;
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Rahul", 101, 40000);
        Employee emp2 = new Employee("Amit", 102, 50000);
        Employee emp3 = new Employee("Priya", 103, 50000);

        emp1.compareSalary(emp2);
        emp2.compareSalary(emp3);

        Employee highest = emp1.getHigherPaidEmployee(emp2);
        highest = highest.getHigherPaidEmployee(emp3);

        System.out.println();
        System.out.println("Highest-paid employee: " + highest.getEmployeeName());
        System.out.println("Annual Salary: " + highest.getAnnualSalary());
    }
}