package entitys;

import java.util.List;

public class Order {
    
    private int id;
    
    private Client client;
    
    private List<SelectedProduct>products;
    
    private double finalPrice;
    
    private static Integer countId = 0;
    
    public Order(Client client, List<SelectedProduct> products) {
        
        countId++;

        this.id = countId;
        
        this.client = client;
        
        this.products = products;
    }

    public List<SelectedProduct> getSelectedProduct() {
        return products;
    }

    public void setSelectedProduct(List<SelectedProduct> products) {
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


    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", client=" + client + ", products=" + products + ", finalPrice=" + finalPrice + '}';
    }
    
    
}