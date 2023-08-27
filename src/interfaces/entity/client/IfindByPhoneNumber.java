package interfaces.entity.client;

import entitys.Client;
import java.util.List;

public interface IfindByPhoneNumber<T extends Client> {
    
    List<T> findByPhoneNumber(String phoneNumber);
}
