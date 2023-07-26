package interfaces.repository;

public interface IFindById<T,ID> {
    
    T findById(ID id);
}
