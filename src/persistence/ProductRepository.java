package persistence;

import java.util.List;
import entitys.Product;
import interfaces.all.IFindByName;
import java.io.Serializable;
import java.util.Optional;
import services.interfaces.productservice.IFindByBrand;
import services.interfaces.productservice.IFindByPc;

public class ProductRepository extends DaoRepository<Product, Integer> implements IFindByName<Product>, IFindByPc<Product>, IFindByBrand<Product>,Serializable{

    private static final long serialVersionUID = 1L;

  //  private final List<Product> productDB = super.entityList;

    public ProductRepository() {
    }

    @Override
    public List<Product> findByName(String name) {
        return super.entityList.stream().filter(product -> product.getName().equals(name)).toList();
    }

    @Override
    public Optional<Product> findByPc(String productCode) {
        return super.entityList.stream().filter(product -> product.getProductCode().equals(productCode)).findFirst();
    }

    @Override
    public List<Product> findByBrand(String brand) {
        return super.entityList.stream().filter(product -> product.getBrand().equals(brand)).toList();
    }
}
