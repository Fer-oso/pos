package services.interfaces.checkoutservice;

import entitys.CheckOut;
import interfaces.all.IDelete;
import interfaces.all.IFindById;
import interfaces.all.ISave;
import interfaces.all.IShow;
import java.util.Optional;

public interface ICheckOutService extends ISave<CheckOut>, IShow<CheckOut>, IFindById<CheckOut, Integer>, IDelete<Integer> {

    @Override
    public <S extends CheckOut> S save(S s);

    @Override
    public void show(CheckOut t);

    @Override
    public Optional<CheckOut> findById(Integer id);

    @Override
    public void delete(Integer id);
}
