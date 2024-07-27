// Main.java
// Author: [Your Name]
// Date: [Current Date]
// Purpose: Main class to run the retail store simulation program with a menu-driven interface.

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static ArrayList<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    createPerishableProduct();
                    break;
                case 3:
                    editProductBySKU();
                    break;
                case 4:
                    deleteProductBySKU();
                    break;
                case 5:
                    displayProductBySKU();
                    break;
                case 6:
                    displayAllProducts();
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (choice != 7);
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1) Create Product");
        System.out.println("2) Create Perishable Product");
        System.out.println("3) Edit Product by SKU");
        System.out.println("4) Delete Product by SKU");
        System.out.println("5) Display Product by SKU");
        System.out.println("6) Display all Products");
        System.out.println("7) Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void createProduct() {
        scanner.nextLine(); // Consume newline

        System.out.print("Enter SKU (8+ digits): ");
        String sku = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Unit Cost: ");
        double unitCost = scanner.nextDouble();
        System.out.print("Enter Sale Price: ");
        double salePrice = scanner.nextDouble();
        System.out.print("Enter Quantity on Hand: ");
        int quantityOnHand = scanner.nextInt();
        System.out.print("Enter Quantity Needed: ");
        int quantityNeeded = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Special Instructions: ");
        String specialInstructions = scanner.nextLine();

        try {
            Product product = new Product(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
            products.add(product);
            System.out.println("Product created successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void createPerishableProduct() {
        scanner.nextLine(); // Consume newline

        System.out.print("Enter SKU (8+ digits): ");
        String sku = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Unit Cost: ");
        double unitCost = scanner.nextDouble();
        System.out.print("Enter Sale Price: ");
        double salePrice = scanner.nextDouble();
        System.out.print("Enter Quantity on Hand: ");
        int quantityOnHand = scanner.nextInt();
        System.out.print("Enter Quantity Needed: ");
        int quantityNeeded = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Special Instructions: ");
        String specialInstructions = scanner.nextLine();
        System.out.print("Enter Expiry Date (yyyy-mm-dd): ");
        String expiryDateStr = scanner.nextLine();

        try {
            Date expiryDate = java.sql.Date.valueOf(expiryDateStr);
            PerishableProduct perishableProduct = new PerishableProduct(sku, name, unitCost, salePrice,
                    quantityOnHand, quantityNeeded, specialInstructions, expiryDate);
            products.add(perishableProduct);
            System.out.println("Perishable product created successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void editProductBySKU() {
        scanner.nextLine(); // Consume newline

        System.out.print("Enter SKU to edit: ");
        String sku = scanner.nextLine();

        for (Product product : products) {
            if (product.getSku().equals(sku)) {
                try {
                    System.out.print("Enter new Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new Unit Cost: ");
                    double unitCost = scanner.nextDouble();
                    System.out.print("Enter new Sale Price: ");
                    double salePrice = scanner.nextDouble();
                    System.out.print("Enter new Quantity on Hand: ");
                    int quantityOnHand = scanner.nextInt();
                    System.out.print("Enter new Quantity Needed: ");
                    int quantityNeeded = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new Special Instructions: ");
                    String specialInstructions = scanner.nextLine();

                    product.setProductName(name);
                    product.setUnitCost(unitCost);
                    product.setSalePrice(salePrice);
                    product.setQuantityOnHand(quantityOnHand);
                    product.setQuantityNeeded(quantityNeeded);
                    product.setSpecialInstructions(specialInstructions);

                    System.out.println("Product updated successfully.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Product with SKU " + sku + " not found.");
    }

    private static void deleteProductBySKU() {
        scanner.nextLine(); // Consume newline

        System.out.print("Enter SKU to delete: ");
        String sku = scanner.nextLine();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getSku().equals(sku)) {
                products.remove(i);
                System.out.println("Product with SKU " + sku + " deleted.");
                return;
            }
        }
        System.out.println("Product with SKU " + sku + " not found.");
    }

    private static void displayProductBySKU() {
        scanner.nextLine(); // Consume newline

        System.out.print("Enter SKU to display: ");
        String sku = scanner.nextLine();

        for (Product product : products) {
            if (product.getSku().equals(sku)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Product with SKU " + sku + " not found.");
    }

    private static void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products) {
                System.out.println(product);
                System.out.println(); // Print a blank line between products
            }
        }
    }
}