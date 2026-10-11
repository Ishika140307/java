import java.util.Scanner;

class Product {
    private String productName;
    private int productId;
    private double unitPrice;
    private int quantity;

    public Product(String productName, int productId, double unitPrice, int quantity) {
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("Unit price must be greater than zero");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        this.productName = productName;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public double calculateSubtotal() {
        return unitPrice * quantity;
    }

    public double calculateDiscountPercentage() {
        double subtotal = calculateSubtotal();
        if (subtotal >= 10000) {
            return 15;
        } else if (subtotal >= 5000) {
            return 10;
        } else if (subtotal >= 1000) {
            return 5;
        } else {
            return 0;
        }
    }

    public double calculateDiscountAmount() {
        return calculateSubtotal() * calculateDiscountPercentage() / 100;
    }

    public double calculateFinalBill() {
        return calculateSubtotal() - calculateDiscountAmount();
    }

    public void displayBill() {
        System.out.println("Product Name: " + productName);
        System.out.println("Product ID: " + productId);
        System.out.println("Subtotal: " + calculateSubtotal());
        System.out.println("Discount: " + calculateDiscountAmount());
        System.out.println("Final Bill: " + calculateFinalBill());
    }
}

public class P09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Unit Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        try {
            Product product = new Product(name, id, price, qty);
            System.out.println();
            product.displayBill();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Input: " + e.getMessage());
        }

        sc.close();
    }
}