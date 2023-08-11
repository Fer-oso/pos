package entitys;

import java.util.List;

public class Order {
    
    private int id;
    private Client client;
    private List<Product>products;
    private int quantity;
    private double finalPrice;

    public Order(Client client, List<Product> products) {
        this.client = client;
        this.products = products;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", client=" + client + ", products=" + products + ", quantity=" + quantity + ", finalPrice=" + finalPrice + '}';
    }
    
    
}