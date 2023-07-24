package pos.models;

public class Product {

    private int id;
    private String name;
    private double price;
    private boolean availability;
    private int stock;
    private String brand;
    private String productCode;
    private int quantity;
    private static int countId;

    public Product() {
        countId++;
        this.id = countId;
    }

    public Product(String name, double price, boolean availability, int stock, String brand, String productCode) {
        countId++;
        this.id = countId;
        this.name = name;
        this.price = price;
        this.availability = availability;
        this.stock = stock;
        this.brand = brand;
        this.productCode = productCode;
       
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", availability=" + availability + ", stock=" + stock + ", brand=" + brand + ", productCode=" + productCode + '}';
    }

   
    

  
    
    

   
   
    
    
}