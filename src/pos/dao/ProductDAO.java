package pos.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pos.interfaces.ICrud.ICrud;
import pos.interfaces.IRepository.IRepository;
import pos.models.Product;

public class ProductDAO implements ICrud<Product>, IRepository<Product, Integer> {

    public List<Product> productDB;

 
    public ProductDAO() {
        productDB = new ArrayList<>();
        productDB.add(new Product("IphoneX", 1000.00, true, 10, "Apple", "IphoneX0001"));
        productDB.add(new Product("Iphone11", 1500.00, true, 10, "Apple", "Iphone110001"));
        productDB.add(new Product("Iphone12", 2000.00, true, 10, "Apple", "Iphone120001"));
        productDB.add(new Product("Iphone13", 2500.00, false, 10, "Apple", "Iphone130001"));
        productDB.add(new Product("Samsung a32", 2500.00, false, 10, "Apple", "Iphone130001"));
        productDB.add(new Product("Nokia 2032", 2500.00, false, 10, "Apple", "Iphone130001"));
    }

    @Override
    public Product save(Product p) {
        productDB.add(p);
        return p;
    }

    @Override
    public void show(Product product) {
        System.out.println(product);
    }

    @Override
    public Product update(int id,Product p) {
        productDB.set(id, p);
        return p;
    }

    @Override
    public void delete(int id) {
       Iterator<Product> iteratorProduct = productDB.iterator();
        while (iteratorProduct.hasNext()) {
            if (iteratorProduct.next().getId() == id) {
                iteratorProduct.remove();
            }
        }
    }

    @Override
    public Product findById(Integer id) {
        for (Product product : productDB) {
            if (product.getId() == id) {
                 return product;
            } }
            return null;
    }

    @Override
    public List<Product> findAll() {
        return productDB;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product>listProductsFindByName = new ArrayList<>();
        for (Product product : productDB) {
            if (product.getName().contains(name)) {
                 listProductsFindByName.add(product);
                
            } }
            return listProductsFindByName;
    }

    public List<Product> findByPc(String productCode) {
         List<Product>listProductsFindByPc = new ArrayList<>();
        for (Product product : productDB) {
            if (product.getProductCode().contains(productCode)) {
                 listProductsFindByPc.add(product);
                
            } }
            return listProductsFindByPc;
    }

  

}
