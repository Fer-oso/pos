package interfaces.entity.client;

import entitys.Client;
import java.util.List;

public interface IfindByLastName<T extends Client>{

    List<T> findByLastName(String lastName);
}
