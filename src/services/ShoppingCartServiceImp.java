package services;

import entitys.Client;
import entitys.SelectedProduct;
import entitys.ShoppingCart;
import java.util.List;
import java.util.Optional;
import persistence.ShoppingCartRepository;
import services.interfaces.shoppingcartservice.IShoppingCartService;

public class ShoppingCartServiceImp implements IShoppingCartService<ShoppingCart,Integer> {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImp(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public ShoppingCart createShoppingCart(Client client, List<SelectedProduct> listSelectedProducts,Double total){
    
    return new ShoppingCart(client, listSelectedProducts, total);
    
    }
    
   @Override
    public <S extends ShoppingCart> S save(S s) {
       return shoppingCartRepository.save(s);
    }

    @Override
    public void show(ShoppingCart t) {
        shoppingCartRepository.show(t);
    }

    @Override
    public Optional<ShoppingCart> findById(Integer id) {
        return shoppingCartRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        shoppingCartRepository.delete(id);
    }

  

}
