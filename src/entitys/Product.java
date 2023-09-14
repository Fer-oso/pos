package entitys;

import interfaces.entity.product.IProduct;
import java.io.Serializable;

public class Product implements IProduct<Product,Integer>,Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Double price;

    private boolean availability;

    private Integer stock;

    private String brand;

    private String productCode;

    private Integer quantity;

    private static Integer countId = 0;

    public Product() {

        countId++;
        this.id = countId;
    }

    public Product(String name, Double price, boolean availability, Integer stock, String brand, String productCode) {

        countId++;

        this.id = countId;

        this.name = name;

        this.price = price;

        this.availability = availability;

        this.stock = stock;

        this.brand = brand;

        this.productCode = productCode;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", availability=" + availability + ", stock=" + stock + ", brand=" + brand + ", productCode=" + productCode + '}';
    }
}
