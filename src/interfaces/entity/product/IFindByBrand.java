package interfaces.entity.product;

import entitys.Product;
import java.util.List;

public interface IFindByBrand<T extends Product> {
    
     List<T> findByBrand(String brand);
}
