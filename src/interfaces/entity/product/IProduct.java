package interfaces.entity.product;

import entitys.Product;
import interfaces.entity.Entity;

public interface IProduct<T extends Product, ID> extends Entity<ID>{ 

    @Override
    public void setId(ID id);

    @Override
    public ID getId(); 
}
