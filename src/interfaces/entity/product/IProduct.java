package interfaces.entity.product;

import entitys.Product;
import interfaces.all.IDelete;
import interfaces.all.IFindAll;
import interfaces.all.IFindById;
import interfaces.all.IFindByName;
import interfaces.all.ISave;
import interfaces.all.IShow;
import interfaces.all.IUpdate;

public interface IProduct<T extends Product,ID> extends ISave<T>, IShow<T>, IUpdate<T, ID>, IDelete<ID>, IFindById<T, ID>,IFindAll<T>, IFindByName<T>,IFindByPc<T>,IFindByBrand<T>{}
