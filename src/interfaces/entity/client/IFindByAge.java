package interfaces.entity.client;

import entitys.Client;
import java.util.List;

public interface IFindByAge<T extends Client> {
    List<T> findByAge(Integer age);
}
