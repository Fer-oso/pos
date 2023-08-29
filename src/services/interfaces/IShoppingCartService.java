package services.interfaces;

import entitys.ShoppingCart;
import interfaces.entity.shoppingCart.IShoppingCart;
import java.util.Optional;

public interface IShoppingCartService extends IShoppingCart<Integer>{

    @Override
    public <S extends ShoppingCart> S save(S s);

    @Override
    public void show(ShoppingCart t);

    @Override
    public Optional<ShoppingCart> findById(Integer id);

    @Override
    public void delete(Integer id);
    
    
    
}
