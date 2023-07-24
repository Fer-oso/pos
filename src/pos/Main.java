package pos;

import pos.dao.ProductDAO;
import pos.models.Product;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product("Iphone13", 2500.00, true, 10, "Apple", "Iphone130001");
        productDAO.save(product);
        productDAO.show(product);
        System.out.println(productDAO.productDB);
        System.out.println(productDAO.findById(1));
        productDAO.delete(1);
        System.out.println(productDAO.findById(4));
        System.out.println(productDAO.productDB);
    }
    
}
