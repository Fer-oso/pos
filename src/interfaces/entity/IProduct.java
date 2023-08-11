package interfaces.entityes;

import interfaces.crud.ICrud;
import interfaces.repository.IRepository;
import java.util.List;
import models.Product;

public interface IProduct<T extends Product,ID> extends ICrud<T, ID>,IRepository<T, ID>{

    List<Product> findByName(String name);

    List<Product> findByPc(String productCode);
    
    List<Product> findByBrand(String brand);

}
