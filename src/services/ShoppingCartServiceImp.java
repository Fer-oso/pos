package services;

import entitys.ShoppingCart;
import java.util.Optional;
import persistence.ShoppingCartRepository;
import services.interfaces.IShoppingCartService;

public class ShoppingCartServiceImp implements IShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImp(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
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
