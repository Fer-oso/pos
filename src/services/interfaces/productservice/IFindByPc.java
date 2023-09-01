package services.interfaces.productservice;

import entitys.Product;
import java.util.Optional;

public interface IFindByPc<T extends Product> {

    Optional<T> findByPc(String productCode);    
}
