// File Name: Main
// Author: Attal
// Date: 27/07/2024
// Purpose: Main class to run the retail store simulation program with a menu-driven interface.

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Main class to run the retail store simulation program.
 */
public class Main {

    private static ArrayList<Product> productList = new ArrayList<>();
    private static Scanner inputScanner = new Scanner(System.in);

    // Define a functional interface for menu actions
    @FunctionalInterface
    private interface MenuAction {
        void execute();
    }

    // Define action methods
    private static void CreateProduct() {
        inputScanner.nextLine(); // Consume newline

        System.out.print("Enter SKU (8+ digits): ");
        String sku = inputScanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = inputScanner.nextLine();
        System.out.print("Enter Unit Cost: ");
        double unitCost = inputScanner.nextDouble();
        System.out.print("Enter Sale Price: ");
        double salePrice = inputScanner.nextDouble();
        System.out.print("Enter Quantity on Hand: ");
        int quantityOnHand = inputScanner.nextInt();
        System.out.print("Enter Quantity Needed: ");
        int quantityNeeded = inputScanner.nextInt();
        inputScanner.nextLine(); // Consume newline
        System.out.print("Enter Special Instructions: ");
        String specialInstructions = inputScanner.nextLine();

        try {
            Product product = new Product(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
            productList.add(product);
            System.out.println("Product created successfully.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void CreatePerishableProduct() {
        inputScanner.nextLine(); // Consume newline

        System.out.print("Enter SKU (8+ digits): ");
        String sku = inputScanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = inputScanner.nextLine();
        System.out.print("Enter Unit Cost: ");
        double unitCost = inputScanner.nextDouble();
        System.out.print("Enter Sale Price: ");
        double salePrice = inputScanner.nextDouble();
        System.out.print("Enter Quantity on Hand: ");
        int quantityOnHand = inputScanner.nextInt();
        System.out.print("Enter Quantity Needed: ");
        int quantityNeeded = inputScanner.nextInt();
        inputScanner.nextLine(); // Consume newline
        System.out.print("Enter Special Instructions: ");
        String specialInstructions = inputScanner.nextLine();
        System.out.print("Enter Expiry Date (yyyy-mm-dd): ");
        String expiryDateStr = inputScanner.nextLine();

        try {
            Date expiryDate = java.sql.Date.valueOf(expiryDateStr);
            PerishableProduct perishableProduct = new PerishableProduct(sku, name, unitCost, salePrice,
                    quantityOnHand, quantityNeeded, specialInstructions, expiryDate);
            productList.add(perishableProduct);
            System.out.println("Perishable product created successfully.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void EditProductBySku() {
        inputScanner.nextLine(); // Consume newline

        System.out.print("Enter SKU to edit: ");
        String sku = inputScanner.nextLine();

        for (Product product : productList) {
            if (product.getSku().equals(sku)) {
                try {
                    System.out.print("Enter new Product Name: ");
                    String name = inputScanner.nextLine();
                    System.out.print("Enter new Unit Cost: ");
                    double unitCost = inputScanner.nextDouble();
                    System.out.print("Enter new Sale Price: ");
                    double salePrice = inputScanner.nextDouble();
                    System.out.print("Enter new Quantity on Hand: ");
                    int quantityOnHand = inputScanner.nextInt();
                    System.out.print("Enter new Quantity Needed: ");
                    int quantityNeeded = inputScanner.nextInt();
                    inputScanner.nextLine(); // Consume newline
                    System.out.print("Enter new Special Instructions: ");
                    String specialInstructions = inputScanner.nextLine();

                    product.setProductName(name);
                    product.setUnitCost(unitCost);
                    product.setSalePrice(salePrice);
                    product.setQuantityOnHand(quantityOnHand);
                    product.setQuantityNeeded(quantityNeeded);
                    product.setSpecialInstructions(specialInstructions);

                    System.out.println("Product updated successfully.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
                return;
            }
        }
        System.out.println("Product with SKU " + sku + " not found.");
    }

    private static void DeleteProductBySku() {
        inputScanner.nextLine(); // Consume newline

        System.out.print("Enter SKU to delete: ");
        String sku = inputScanner.nextLine();

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getSku().equals(sku)) {
                productList.remove(i);
                System.out.println("Product with SKU " + sku + " deleted.");
                return;
            }
        }
        System.out.println("Product with SKU " + sku + " not found.");
    }

    private static void DisplayProductBySku() {
        inputScanner.nextLine(); // Consume newline

        System.out.print("Enter SKU to display: ");
        String sku = inputScanner.nextLine();

        for (Product product : productList) {
            if (product.getSku().equals(sku)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Product with SKU " + sku + " not found.");
    }

    private static void DisplayAllProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : productList) {
                System.out.println(product);
                System.out.println(); // Print a blank line between products
            }
        }
    }

    private static void ExitProgram() {
        System.out.println("Exiting program...");
    }

    private static final Map<Integer, MenuAction> MENU_ACTIONS = new HashMap<>();

    static {
        MENU_ACTIONS.put(1, Main::CreateProduct);
        MENU_ACTIONS.put(2, Main::CreatePerishableProduct);
        MENU_ACTIONS.put(3, Main::EditProductBySku);
        MENU_ACTIONS.put(4, Main::DeleteProductBySku);
        MENU_ACTIONS.put(5, Main::DisplayProductBySku);
        MENU_ACTIONS.put(6, Main::DisplayAllProducts);
        MENU_ACTIONS.put(7, Main::ExitProgram);
    }

    /**
     * Main method to start the program.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        int userChoice;

        do {
            displayMenu();
            userChoice = getUserChoice();
            MenuAction action = MENU_ACTIONS.get(userChoice);

            if (action != null) {
                action.execute();
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (userChoice != 7);
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
        return inputScanner.nextInt();
    }
}
