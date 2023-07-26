package pos;

import models.Product;
import persistence.ProductRepository;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here

        ProductRepository productRepository = new ProductRepository();
        Product product = new Product("Iphone13", 2500.00, true, 10, "Apple", "Iphone130001");
        Product product1 = new Product("Iphone13", 2500.00, true, 10, "Apple", "Iphone130001");
        Product product2 = new Product("Iphone13", 2500.00, true, 10, "Apple", "Iphone130001");
        productRepository.save(product);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.show(product);
        System.out.println(productRepository.productDB);
       // System.out.println(productRepository.findById(1));
        productRepository.delete(2);
      //  System.out.println(productRepository.findById(3));
        System.out.println(productRepository.productDB);
        System.out.println("asdsad sadsadsadsadsadsa");
    }

}
