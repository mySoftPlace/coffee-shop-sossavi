import coffee.CoffeeShop;
import coffee.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CoffeeShopTest {

    CoffeeShop coffeeShop;
    Map<Integer, Product> availableProducts;

    Map<Integer, Product> purchasedProductWithoutBonus;
    String allPurchasedProduct;

    @Before
    public void setUp() {

        coffeeShop = new CoffeeShop();

        availableProducts = coffeeShop.getAvailableProducts();

        purchasedProductWithoutBonus = new HashMap<>();
        purchasedProductWithoutBonus.putAll(availableProducts);

        purchasedProductWithoutBonus.get(1).setQuantity(4);
        purchasedProductWithoutBonus.get(2).setQuantity(3);
        purchasedProductWithoutBonus.get(3).setQuantity(2);
        purchasedProductWithoutBonus.get(4).setQuantity(1);
        purchasedProductWithoutBonus.get(7).setQuantity(5);

        allPurchasedProduct = purchasedProduct(purchasedProductWithoutBonus);
    }

    @Test
    public void testTotalCostForEachProduct() {
        float totalBillToPay = coffeeShop.purchaseProcessing(allPurchasedProduct);

        assertEquals("Coffee small", 10, coffeeShop.getPurchasedProducts().get(0).getTotalCost(), 0.0);
        assertEquals("Coffee medium", 9, coffeeShop.getPurchasedProducts().get(1).getTotalCost(), 0.0);
        assertEquals("Coffee large", 7, coffeeShop.getPurchasedProducts().get(2).getTotalCost(), 0.0);
        assertEquals("Bacon Roll", 4.50, coffeeShop.getPurchasedProducts().get(3).getTotalCost(), 0.0);

        // 5th beverage is for free
        assertNotEquals("Foamed milk", 2.50, coffeeShop.getPurchasedProducts().get(6).getTotalCost(), 0.0);
        assertEquals("Foamed milk", 2, coffeeShop.getPurchasedProducts().get(6).getTotalCost(), 0.0);

        assertEquals(32.50, totalBillToPay, 0.0);
    }

    private String purchasedProduct(Map<Integer, Product> map) {
        String mapAsString = map.keySet().stream()
                .map(key -> key + ":" + map.get(key).getQuantity())
                .collect(Collectors.joining(", "));
        return mapAsString;
    }
}
