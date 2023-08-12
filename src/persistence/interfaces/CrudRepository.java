package persistence.interfaces;

import interfaces.crud.ICrud;
import interfaces.repository.IRepository;
import interfaces.entity.Entity;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T extends Entity<ID>, ID> extends ICrud<T, ID>, IRepository<T, ID>, EntityRepository {      

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

   


    

}
