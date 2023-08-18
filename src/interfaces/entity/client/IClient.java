package interfaces.entity.client;

import entitys.Client;
import interfaces.all.IDelete;
import interfaces.all.IFindAll;
import interfaces.all.IFindById;
import interfaces.all.IFindByName;
import interfaces.all.ISave;
import interfaces.all.IShow;
import interfaces.all.IUpdate;

public interface IClient<T extends Client, ID> extends
        ISave<T>, IShow<T>, IUpdate<T, ID>, IDelete<ID>,
        IFindById<T, ID>, IFindAll<T>,
        IFindByName<T>, IfindByLastName<T>, IFindByAge<T>, IFindBySsn<T>, IfindByPhoneNumber<T> {

}
