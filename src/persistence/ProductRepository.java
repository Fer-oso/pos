package persistence;

import java.util.List;
import entitys.Product;
import interfaces.entity.product.IProduct;
import java.util.Optional;

public class ProductRepository extends DaoRepository<Product, Integer> implements IProduct<Product, Integer> {

    private final List<Product> productDB = super.entityList;

    public ProductRepository() {}

    @Override
    public List<Product> findByName(String name) {
       return productDB.stream().filter(product -> product.getName().equals(name)).toList();
    }

    @Override
    public Optional<Product> findByPc(String productCode) {
         return productDB.stream().filter(product -> product.getProductCode().equals(productCode)).findFirst();
    }

    @Override
    public List<Product> findByBrand(String brand) {
         return productDB.stream().filter(product -> product.getBrand().equals(brand)).toList();
    }
}
