package interfaces.entity.client;

import entitys.Client;

public interface IClient<T extends Client, ID> extends IFindByName<T>,
                         IfindByLastName<T>,IFindByAge<T>,IFindBySsn<T>,IfindByPhoneNumber<T>{}
