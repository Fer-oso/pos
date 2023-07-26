package persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import models.Product;

public class ProductRepository extends DaoRepository<Product, Integer> {

    public List<Product> productDB;

    public ProductRepository() {
        productDB = super.entityList;
//        productDB = new ArrayList<>();
//        productDB.add(new Product("IphoneX", 1000.00, true, 10, "Apple", "IphoneX0001"));
//        productDB.add(new Product("Iphone11", 1500.00, true, 10, "Apple", "Iphone110001"));
//        productDB.add(new Product("Iphone12", 2000.00, true, 10, "Apple", "Iphone120001"));
//        productDB.add(new Product("Iphone13", 2500.00, false, 10, "Apple", "Iphone130001"));
//        productDB.add(new Product("Samsung a32", 2500.00, false, 10, "Apple", "Iphone130001"));
//        productDB.add(new Product("Nokia 2032", 2500.00, false, 10, "Apple", "Iphone130001"));
    }

//    @Override
//    public Product save(Product p) {
//      return super.save(p);
//    }
//
//    @Override
//    public void show(Product product) {
//        super.show(product);
//    }

//    @Override
//    public void delete(Integer id) {
//        Iterator<Product> iteratorProduct = productDB.iterator();
//        while (iteratorProduct.hasNext()) {
//            if (iteratorProduct.next().getId().equals(id)) {
//                iteratorProduct.remove();
//            }
//        }
//    }

//    @Override
//    public Product update(Integer id, Product t) {
//        productDB.set(id, t);
//        return t;
//    }



//    @Override
//    public List<Product> findAll() {
//        return productDB;
//    }
    
    
//        @Override
//    public Product findById(Integer id) {
//        for (Product product : productDB) {
//            if (product.getId() == id) {
//                return product;
//            }
//        }
//        return null;
//    }

    public List<Product> findByName(String name) {
        List<Product> listProductsFindByName = new ArrayList<>();
        for (Product product : productDB) {
            if (product.getName().contains(name)) {
                listProductsFindByName.add(product);

            }
        }
        return listProductsFindByName;
    }

    public List<Product> findByPc(String productCode) {
        List<Product> listProductsFindByPc = new ArrayList<>();
        for (Product product : productDB) {
            if (product.getProductCode().contains(productCode)) {
                listProductsFindByPc.add(product);

            }
        }
        return listProductsFindByPc;
    }

}
