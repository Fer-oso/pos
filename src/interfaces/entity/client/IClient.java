package interfaces.entity.client;

import entitys.Client;
import interfaces.entity.Entity;

public interface IClient<T extends Client, ID> extends Entity<ID>{

    @Override
    public void setId(ID id);

    @Override
    public ID getId();

}
