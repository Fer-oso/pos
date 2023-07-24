package pos.services;

import java.util.List;
import pos.dao.ProductDAO;
import pos.interfaces.IEntitys.IProduct;
import pos.models.Product;

public class ProductService implements IProduct{

    ProductDAO productDAO;
    
    public ProductService(ProductDAO productDAO) {
        this.productDAO=productDAO;
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public void show(Product product) {
       productDAO.show(product);
    }

    @Override
    public Product update(int id,Product product) {
      return productDAO.update(id,product);
    }

    @Override
    public void delete(int id) {
        productDAO.delete(id);
    }

    @Override
    public List<Product> findAll() {
       return productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
      return productDAO.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
       return productDAO.findByName(name);
    }

    public List<Product> findByPc(String productCode) {
        return productDAO.findByPc(productCode);
    }

}