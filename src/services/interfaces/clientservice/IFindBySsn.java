package services.interfaces.clientservice;

import entitys.Client;
import java.util.Optional;

public interface IFindBySsn<T extends Client> {
    
    Optional<T> findBySsn(Integer ssn);
}
