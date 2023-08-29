package services.interfaces.clientservice;

import entitys.Client;
import interfaces.all.IDelete;
import interfaces.all.IFindAll;
import interfaces.all.IFindById;
import interfaces.all.IFindByName;
import interfaces.all.ISave;
import interfaces.all.IShow;
import interfaces.all.IUpdate;
import java.util.List;
import java.util.Optional;

public interface IclientService<T extends Client, ID> extends ISave<T>, IShow<T>, IUpdate<T, ID>, IDelete<ID>, IFindAll<T>, 
                  IFindById<T, ID>, IFindByName<T>, IfindByLastName<T>, IFindByAge<T>, IFindBySsn<T>, IfindByPhoneNumber<T> {

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
    public List<T> findByLastName(String lastName);

    @Override
    public List<T> findByAge(Integer age);

    @Override
    public Optional<T> findBySsn(Integer ssn);

    @Override
    public List<T> findByPhoneNumber(String phoneNumber);

}
