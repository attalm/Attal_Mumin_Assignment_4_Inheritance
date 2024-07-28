//File Name: PerishableProduct
// Author: [Your Name]
// Date: [Current Date]
// Purpose: Defines the PerishableProduct class extending Product with additional expiry date functionality.

import java.util.Date;

public class PerishableProduct extends Product {

    // Properties
    private Date expiryDate;

    // Default Constructor
    /**
     * Default constructor for the PerishableProduct class. Initializes properties with default values.
     */
    public PerishableProduct() {
        super();
        this.expiryDate = new Date(); // Default to current date
    }

    // Parameterized Constructor
    /**
     * Parameterized constructor for the PerishableProduct class.
     *
     * @param sku                    Product SKU (Stock Keeping Unit)
     * @param productName            Name of the product
     * @param unitCost               Cost of the product
     * @param salePrice              Sale price of the product
     * @param quantityOnHand         Quantity of the product in stock
     * @param quantityNeeded         Quantity needed for next order
     * @param specialInstructions    Any special instructions or notes
     * @param expiryDate             Expiry date of the product
     */
    public PerishableProduct(String sku, String productName, double unitCost, double salePrice,
                             int quantityOnHand, int quantityNeeded, String specialInstructions, Date expiryDate) {
        super(sku, productName, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
        this.expiryDate = expiryDate;
    }

    // Getter and Setter for expiryDate
    /**
     * Gets the expiry date of the perishable product.
     *
     * @return Expiry date as a Date
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the expiry date of the perishable product.
     *
     * @param expiryDate Expiry date as a Date
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Displays the details of the perishable product including the expiry date.
     *
     * @return Perishable product details as a formatted String
     */
    @Override
    public String toString() {
        return super.toString() + String.format("\nExpiry Date: %s", expiryDate.toString());
    }
}
