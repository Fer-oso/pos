package interfaces.entity.client;

import entitys.Client;
import java.util.List;

public interface IFindBySsn<T extends Client> {
    
    List<T> findBySsn(Integer ssn);
}
