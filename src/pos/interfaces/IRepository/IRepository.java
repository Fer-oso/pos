package pos.interfaces.IRepository;

public interface IRepository<T,ID> extends IFindById<T,ID>,IFindAll,IFindByName<T> {
    
    
}
