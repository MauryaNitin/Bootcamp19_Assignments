package demo.domain;

/**
 * @author Dhanendra Kumar
 */
public class Order {

    private int quantity;
    private String itemName;
    private double price;
    private double priceWithTax;

    public Order() {}

    public Order(int quantity, String itemName, double price) {
        this.quantity = quantity;
        this.itemName = itemName;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Order setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public Order setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Order setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getPriceWithTax() {
        return priceWithTax;
    }

    public Order setPriceWithTax(double priceWithTax) {
        this.priceWithTax = priceWithTax;
        return this;
    }
}
