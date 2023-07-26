package interfaces.entityes;

import java.util.List;
import models.Product;

public interface IProduct {
    
    Product save(Product product);
    void show(Product product);
    Product update(int id,Product product);
    void delete(int id);
    List<Product> findAll();
    Product findById(int id);
    List<Product> findByName(String name);
    
}
