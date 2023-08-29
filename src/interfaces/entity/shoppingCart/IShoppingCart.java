package interfaces.entity.shoppingCart;

import entitys.ShoppingCart;
import interfaces.all.IDelete;
import interfaces.all.IFindById;
import interfaces.all.ISave;
import interfaces.all.IShow;

public interface IShoppingCart<ID> extends ISave<ShoppingCart>,IShow<ShoppingCart>,IFindById<ShoppingCart, ID>,IDelete<ID>{
    
}
