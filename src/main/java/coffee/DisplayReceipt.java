package coffee;

import java.util.*;
import java.util.logging.Logger;

public class DisplayReceipt {

    private static final Logger logger = Logger.getLogger(DisplayReceipt.class.getName());
    public static final String CURRENCY = "CHF  ";

    public static void main(String[] args) {

        var coffeeShop = new CoffeeShop();

        var availableProducts = coffeeShop.getAvailableProducts();

        availableProducts.entrySet().forEach(prod -> System.out.println(
                prod.getKey() + ". " + prod.getValue().getName()));

        System.out.println(
                "Select the products number and their quantity (separated by :) to purchase. Please separate your choices with comma.");
        System.out.println("Example:  1:3, 5:2 means three small coffee, two orange juice.");

        var sc = new Scanner(System.in);
        var userEntry = sc.nextLine();
        sc.close();

        var totalBillToPay = coffeeShop.purchaseProcessing(userEntry);

        System.out.println();
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");

        // Display a receipt
        for (Product product : coffeeShop.getPurchasedProducts()) {

            System.out.print(product.getName()); // Display item name

            System.out.print("          X" + product.getQuantity());

            System.out.println("            " + CURRENCY + product.getTotalCost());
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Total:                          " + CURRENCY + totalBillToPay);
    }
}
