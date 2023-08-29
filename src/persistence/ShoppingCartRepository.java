package persistence;

import entitys.ShoppingCart;
import interfaces.entity.shoppingCart.IShoppingCart;

public class ShoppingCartRepository extends DaoRepository<ShoppingCart, Integer> implements IShoppingCart<Integer> {

}
