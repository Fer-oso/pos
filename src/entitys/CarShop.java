package entitys;

import java.util.List;

public class CarShop {

    private int id;
    private Client client;
    private List<Product> products;

    private static Integer countId = 0;

    public CarShop() {
         countId++;
        this.id = countId;
    }

    public CarShop(int id, Client client, List<Product> products) {
         countId++;
        this.id = countId;
        this.client = client;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
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

    @Override
    public String toString() {
        return "CarShop{" + "id=" + id + ", client=" + client + ", products=" + products + '}';
    }

}
