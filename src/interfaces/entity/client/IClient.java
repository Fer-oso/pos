package interfaces.entity.client;

import entitys.Client;
import interfaces.all.IFindByName;

public interface IClient<T extends Client, ID> extends IFindByName<T>,
                         IfindByLastName<T>,IFindByAge<T>,IFindBySsn<T>,IfindByPhoneNumber<T>{}
