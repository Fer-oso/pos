package services.interfaces.clientservice;

import entitys.Client;
import java.util.List;

public interface IfindByPhoneNumber<T extends Client> {
    
    List<T> findByPhoneNumber(String phoneNumber);
}
