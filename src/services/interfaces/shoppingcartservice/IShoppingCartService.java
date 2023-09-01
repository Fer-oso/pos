package services.interfaces.shoppingcartservice;

import entitys.ShoppingCart;
import interfaces.all.IDelete;
import interfaces.all.IFindById;
import interfaces.all.ISave;
import interfaces.all.IShow;
import java.util.Optional;

public interface IShoppingCartService<T extends ShoppingCart,ID> extends ISave<T>,IShow<T>,IFindById<T, Integer>,IDelete<Integer>{

    @Override
    public void delete(Integer id);

    @Override
    public Optional<T> findById(Integer id);

    @Override
    public <S extends T> S save(S s);

    @Override
    public void show(T t);
    
}
