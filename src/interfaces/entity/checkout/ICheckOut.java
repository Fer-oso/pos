package interfaces.entity.checkout;

import entitys.CheckOut;
import interfaces.all.IFindById;
import interfaces.all.ISave;
import interfaces.all.IShow;

public interface ICheckOut<ID> extends ISave<CheckOut>,IShow<CheckOut>,IFindById<CheckOut, ID>{
  
}
