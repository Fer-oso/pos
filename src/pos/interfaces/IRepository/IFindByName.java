package pos.interfaces.IRepository;

import java.util.List;

public interface IFindByName<T> {

   List<T> findByName(String s);
}
