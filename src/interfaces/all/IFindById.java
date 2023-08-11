package interfaces.all;

import java.util.Optional;

public interface IFindById<T,ID> {
    
    Optional<T> findById(ID id);
}
