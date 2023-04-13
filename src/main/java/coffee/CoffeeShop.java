package coffee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeShop {

    private Map<Integer, Product> availableProducts;
    private List<Product> purchasedProducts;

    public CoffeeShop() {

        availableProducts = new HashMap<>();
        availableProducts.put(1, new Product("Coffee small", 2.50f, 0, 0));
        availableProducts.put(2, new Product("Coffee medium", 3.00f, 0, 0));
        availableProducts.put(3, new Product("Coffee large", 3.50f, 0, 0));
        availableProducts.put(4, new Product("Bacon Roll", 4.50f, 0, 0));
        availableProducts.put(5, new Product("Orange juice", 3.95f, 0, 0));
        availableProducts.put(6, new Product("Extra milk", 0.30f, 0, 0));
        availableProducts.put(7, new Product("Foamed milk", 0.50f, 0, 0));
        availableProducts.put(8, new Product("Special roast coffee", 0.90f, 0, 0));

        purchasedProducts = new ArrayList<>();
    }

    public float purchaseProcessing(String cartContent) {

        cartContent = cartContent.replaceAll("\\s", "");

        var customerChoice = cartContent.split(",");

        var eachProductNumberAndQuantityPurchased = new String[2];

        var quantity = 0;

        var totalBillToPay = 0f;

        for (String product : customerChoice) {

            eachProductNumberAndQuantityPurchased = product.split(":");
            var purchasedProduct = availableProducts.get(Integer.parseInt(eachProductNumberAndQuantityPurchased[0]));

            quantity = Integer.parseInt(eachProductNumberAndQuantityPurchased[1]);
            purchasedProduct.setQuantity(quantity);

            float totalCostPerProduct = 0;

            // Bonus program
            if ((quantity % 5) == 0) {
                totalCostPerProduct = (quantity - (quantity / 5)) * purchasedProduct.getUnitPrice();  // 5th beverage is for free
            } else {
                totalCostPerProduct = quantity * purchasedProduct.getUnitPrice();
            }

            purchasedProduct.setTotalCost(totalCostPerProduct);
            purchasedProducts.add(purchasedProduct);

            totalBillToPay += totalCostPerProduct;
        }

        return totalBillToPay;
    }

    public Map<Integer, Product> getAvailableProducts() {
        return availableProducts;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }
}
