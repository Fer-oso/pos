package interfaces.entity.client;

import entitys.Client;
import java.util.List;

public interface IFindByName<T extends Client> {

    List<T> findByName(String name);

}
