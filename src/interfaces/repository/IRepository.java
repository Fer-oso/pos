package interfaces.repository;

import interfaces.all.IFindAll;
import interfaces.all.IFindById;

public interface IRepository<T, ID> extends IFindById<T, ID>, IFindAll<T> {
    
}
