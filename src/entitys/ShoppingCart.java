package entitys;

import interfaces.entity.Entity;
import java.util.List;

public class ShoppingCart implements Entity<Integer> {

    private int id;

    private Client client;

    private List<SelectedProduct> products;
    
    private Double total;

    private static Integer countId = 0;

    public ShoppingCart() {

        countId++;

        this.id = countId;
    }

    public ShoppingCart(Client client, List<SelectedProduct> products, Double total) {

        countId++;

        this.id = countId;

        this.client = client;

        this.products = products;
        
        this.total = total;
    }

    @Override
    public Integer getId() {
       return id;
    }

    @Override
    public void setId(Integer id) {
       this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<SelectedProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SelectedProduct> products) {
        this.products = products;
    }

    public Double getFinalPrice() {
        return total;
    }

    public void setFinalPrice(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "id=" + id + ", client=" + client + ", products=" + products + ", total=" + total + '}';
    }

   
   
}
