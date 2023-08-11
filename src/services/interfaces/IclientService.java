package services.interfaces;

import entitys.Client;
import interfaces.crud.ICrud;
import interfaces.entity.client.IClient;
import interfaces.repository.IRepository;

public interface IclientService<T extends Client,ID> extends IClient<T, ID>, ICrud<T, ID>, IRepository<T, ID>{  
}
