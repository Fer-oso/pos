package interfaces.all;

import java.util.List;

public interface IFindByName<T> {
    
    List<T> findByName(String name);
    
}