package pos;

import entitys.Client;
import entitys.CreditCard;
import entitys.Product;
import persistence.ProductRepository;
import services.ProductServiceImp;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        
        CreditCard creditCard = new CreditCard();
        creditCard.setQuantity(100);
        
        Client client = new Client("fernando", "osorio", 29, 38128526, true, "46698856", creditCard);
        System.out.println(client);
        
        creditCard.setQuantity(500);
        client.addPaymentMethod(creditCard);
        
        System.out.println(client);

//        ProductRepository productRepository = new ProductRepository();
//    
//        ProductServiceImp productServiceImp = new ProductServiceImp(productRepository);
//        Product product = productServiceImp.save(new Product());
//        productServiceImp.show(product);
  
  }

}
