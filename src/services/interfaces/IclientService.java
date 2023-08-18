package services.interfaces;

import entitys.Client;
import interfaces.entity.client.IClient;
import java.util.List;
import java.util.Optional;

public interface IclientService<T extends Client, ID> extends IClient<T, ID> {

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
    public List<T> findByPhoneNumber(Integer phoneNumber);

}
