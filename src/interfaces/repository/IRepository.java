package interfaces.repository;

import interfaces.crud.ICrud;

public interface IRepository<T, ID> extends ICrud<T, ID>,IFindById<T, ID>, IFindAll {
    
}
