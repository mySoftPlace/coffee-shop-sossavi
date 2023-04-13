package coffee;

public class Product {

    private String name;
    private int quantity;
    private float unitPrice;
    private float totalCost;

    public Product(String name, float unitPrice, int quantity, float totalCost) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }
}
