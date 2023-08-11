package interfaces.crud;

import interfaces.all.ISave;
import interfaces.all.IDelete;
import interfaces.all.IShow;
import interfaces.all.IUpdate;

public interface ICrud<T,ID> extends ISave<T>, IShow<T>,IUpdate<T,ID>,IDelete<ID> {
    
    
  
}
