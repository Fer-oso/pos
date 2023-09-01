package services.interfaces.productservice;

import entitys.Product;
import interfaces.all.IDelete;
import interfaces.all.IFindAll;
import interfaces.all.IFindById;
import interfaces.all.IFindByName;
import interfaces.all.ISave;
import interfaces.all.IShow;
import interfaces.all.IUpdate;
import java.util.List;
import java.util.Optional;

public interface IProductService<T extends Product, ID> extends ISave<T>, IShow<T>, IUpdate<T, ID>, IDelete<ID>, 
        IFindAll<T>, IFindById<T, ID>, IFindByName<T>, IFindByBrand<T>, IFindByPc<T> {

    @Override
    public <S extends T> S save(S s);

    @Override
    public void show(T t);

    @Override
    public <S extends T> S update(ID id, S s);

    @Override
    public void delete(ID id);

    @Override
    public List<T> findAll();

    @Override
    public Optional<T> findById(ID id);

    @Override
    public List<T> findByName(String name);

    @Override
    public List<T> findByBrand(String brand);

    @Override
    public Optional<T> findByPc(String productCode);

}
