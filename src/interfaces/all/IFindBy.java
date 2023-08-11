package interfaces.all;

import java.util.Optional;

public interface IFindBy<T,V> {
    
    Optional<T> findBy(V arg);
}
