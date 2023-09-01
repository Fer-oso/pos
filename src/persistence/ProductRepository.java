package persistence;

import java.util.List;
import entitys.Product;
import interfaces.all.IFindByName;
import java.util.Optional;
import services.interfaces.productservice.IFindByBrand;
import services.interfaces.productservice.IFindByPc;

public class ProductRepository extends DaoRepository<Product, Integer> implements IFindByName<Product>, IFindByPc<Product>, IFindByBrand<Product>{

    private final List<Product> productDB = super.entityList;

    public ProductRepository() {
    }

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
