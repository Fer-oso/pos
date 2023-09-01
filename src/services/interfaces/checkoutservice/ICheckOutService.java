package services.interfaces.checkoutservice;

import entitys.CheckOut;
import interfaces.entity.checkout.ICheckOut;
import java.util.Optional;

public interface ICheckOutService extends ICheckOut<Integer>{

    @Override
    public Optional<CheckOut> findById(Integer id);

    @Override
    public <S extends CheckOut> S save(S s);

    @Override
    public void show(CheckOut t);
    
}
