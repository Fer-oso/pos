package services.interfaces;

import entitys.Product;
import interfaces.entity.product.IProduct;
import java.util.List;
import java.util.Optional;

public interface IProductService<T extends Product, ID> extends IProduct<T, ID> {

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
