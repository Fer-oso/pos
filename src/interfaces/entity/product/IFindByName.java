package interfaces.entity.product;

import entitys.Product;
import java.util.List;

public interface IFindByName<T extends Product> {

  List<T> findByName(String name);    
}
