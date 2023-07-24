package pos.interfaces.IRepository;

public interface IFindById<T,ID> {
    
    T findById(ID id);
}
