package services;

import java.util.List;
import persistence.ProductRepository;

import entitys.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;
import services.interfaces.productservice.IProductService;

public class ProductServiceImp implements IProductService<Product, Integer>,Serializable {

    private static final long serialVersionUID = 1L;

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public <S extends Product> S save(S product) {
        return productRepository.save(product);
    }

    @Override
    public void show(Product product) {
        productRepository.show(product);
    }

    @Override
    public <S extends Product> S update(Integer id, S product) {
        return productRepository.update(id, product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public ArrayList<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Optional<Product> findByPc(String productCode) {
        return productRepository.findByPc(productCode);
    }

    @Override
    public List<Product> findByBrand(String brand) {
        return null;
    }

}
