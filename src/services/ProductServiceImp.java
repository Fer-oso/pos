package services;

import java.util.List;
import persistence.ProductRepository;
import interfaces.entityes.IProduct;
import models.Product;

public class ProductServiceImp implements IProduct{

    ProductRepository productRepository;
    
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void show(Product product) {
       productRepository.show(product);
    }

    @Override
    public Product update(int id,Product product) {
      return productRepository.update(id,product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> findAll() {
       return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
      return productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
       return productRepository.findByName(name);
    }

    public List<Product> findByPc(String productCode) {
        return productRepository.findByPc(productCode);
    }

}