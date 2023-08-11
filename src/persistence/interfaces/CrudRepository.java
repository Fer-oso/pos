package persistence.interfaces;

import interfaces.crud.ICrud;
import interfaces.repository.IRepository;
import interfaces.entity.Entity;

public interface CrudRepository<T extends Entity<ID>, ID> extends ICrud<T, ID>, IRepository<T, ID>, EntityRepository {      
}
