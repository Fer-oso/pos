package interfaces.entity;

import entitys.Client;
import interfaces.crud.ICrud;
import interfaces.repository.IRepository;
import java.util.List;


public interface IClient<T extends Client, ID> extends ICrud<T, ID>, IRepository<T, ID>{

    List<Client> findByName(String name);

    List<Client> findByLastName(String lastName);
    
    List<Client> findByAge(Integer integer);
    
    Client findBySsn(Integer ssn);
    
    Client findByPhoneNumber(Integer phoneNumber);
}
