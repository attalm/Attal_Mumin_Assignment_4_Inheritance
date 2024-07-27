// Product.java
// Author: Attal
// Date: 27/07/2024
// Purpose: Defines the Product class with properties, constructors, and methods for a retail store.

public class Product {

    // Properties
    private String sku;
    private String productName;
    private double unitCost;
    private double salePrice;
    private int quantityOnHand;
    private int quantityNeeded;
    private String specialInstructions;

    // Default Constructor
    /**
     * Default constructor for the Product class. Initializes properties with default values.
     */
    public Product() {
        this.sku = "";
        this.productName = "";
        this.unitCost = 0.0;
        this.salePrice = 0.0;
        this.quantityOnHand = 0;
        this.quantityNeeded = 0;
        this.specialInstructions = "";
    }

    // Parameterized Constructor
    /**
     * Parameterized constructor for the Product class.
     *
     * @param sku                    Product SKU (Stock Keeping Unit)
     * @param productName            Name of the product
     * @param unitCost               Cost of the product
     * @param salePrice              Sale price of the product
     * @param quantityOnHand         Quantity of the product in stock
     * @param quantityNeeded         Quantity needed for next order
     * @param specialInstructions    Any special instructions or notes
     */
    public Product(String sku, String productName, double unitCost, double salePrice,
                   int quantityOnHand, int quantityNeeded, String specialInstructions) {
        setSku(sku);
        setProductName(productName);
        setUnitCost(unitCost);
        setSalePrice(salePrice);
        setQuantityOnHand(quantityOnHand);
        setQuantityNeeded(quantityNeeded);
        this.specialInstructions = specialInstructions;
    }

    // Getters and Setters
    /**
     * Gets the SKU of the product.
     *
     * @return SKU as a String
     */
    public String getSku() {
        return sku;
    }

    /**
     * Sets the SKU of the product. Must be at least 8 digits.
     *
     * @param sku SKU as a String
     * @throws IllegalArgumentException if SKU does not meet the validation criteria
     */
    public void setSku(String sku) {
        if (sku.matches("\\d{8,}")) {
            this.sku = sku;
        } else {
            throw new IllegalArgumentException("SKU must be at least 8 digits.");
        }
    }

    /**
     * Gets the name of the product.
     *
     * @return Product name as a String
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the name of the product. Cannot be blank.
     *
     * @param productName Name of the product
     * @throws IllegalArgumentException if name is blank
     */
    public void setProductName(String productName) {
        if (productName != null && !productName.trim().isEmpty()) {
            this.productName = productName;
        } else {
            throw new IllegalArgumentException("Product name cannot be blank.");
        }
    }

    /**
     * Gets the unit cost of the product.
     *
     * @return Unit cost as a double
     */
    public double getUnitCost() {
        return unitCost;
    }

    /**
     * Sets the unit cost of the product. Must be >= 0.
     *
     * @param unitCost Unit cost as a double
     * @throws IllegalArgumentException if unit cost is negative
     */
    public void setUnitCost(double unitCost) {
        if (unitCost >= 0) {
            this.unitCost = unitCost;
        } else {
            throw new IllegalArgumentException("Unit cost cannot be negative.");
        }
    }

    /**
     * Gets the sale price of the product.
     *
     * @return Sale price as a double
     */
    public double getSalePrice() {
        return salePrice;
    }

    /**
     * Sets the sale price of the product. Must be >= 0.
     *
     * @param salePrice Sale price as a double
     * @throws IllegalArgumentException if sale price is negative
     */
    public void setSalePrice(double salePrice) {
        if (salePrice >= 0) {
            this.salePrice = salePrice;
        } else {
            throw new IllegalArgumentException("Sale price cannot be negative.");
        }
    }

    /**
     * Gets the quantity of the product on hand.
     *
     * @return Quantity on hand as an int
     */
    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    /**
     * Sets the quantity of the product on hand. Must be >= 0.
     *
     * @param quantityOnHand Quantity on hand as an int
     * @throws IllegalArgumentException if quantity is negative
     */
    public void setQuantityOnHand(int quantityOnHand) {
        if (quantityOnHand >= 0) {
            this.quantityOnHand = quantityOnHand;
        } else {
            throw new IllegalArgumentException("Quantity on hand cannot be negative.");
        }
    }

    /**
     * Gets the quantity of the product needed for the next order.
     *
     * @return Quantity needed as an int
     */
    public int getQuantityNeeded() {
        return quantityNeeded;
    }

    /**
     * Sets the quantity of the product needed for the next order. Must be >= 0.
     *
     * @param quantityNeeded Quantity needed as an int
     * @throws IllegalArgumentException if quantity is negative
     */
    public void setQuantityNeeded(int quantityNeeded) {
        if (quantityNeeded >= 0) {
            this.quantityNeeded = quantityNeeded;
        } else {
            throw new IllegalArgumentException("Quantity needed cannot be negative.");
        }
    }

    /**
     * Gets any special instructions for the product.
     *
     * @return Special instructions as a String
     */
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    /**
     * Sets any special instructions for the product.
     *
     * @param specialInstructions Special instructions as a String
     */
    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    /**
     * Displays the details of the product.
     *
     * @return Product details as a formatted String
     */
    @Override
    public String toString() {
        return String.format("SKU: %s\nProduct Name: %s\nUnit Cost: $%.2f\nSale Price: $%.2f\n" +
                        "Quantity on hand: %d\nQuantity Needed: %d\nSpecial Instructions: %s",
                sku, productName, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
    }
}

