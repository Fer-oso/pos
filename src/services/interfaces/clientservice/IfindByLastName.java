package services.interfaces.clientservice;

import entitys.Client;
import java.util.List;

public interface IfindByLastName<T extends Client>{

    List<T> findByLastName(String lastName);
}
