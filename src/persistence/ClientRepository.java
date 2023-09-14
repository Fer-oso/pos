package persistence;

import java.util.List;
import entitys.Client;
import interfaces.all.IFindByName;
import java.io.Serializable;
import java.util.ArrayList;
import services.interfaces.clientservice.IFindByAge;
import services.interfaces.clientservice.IFindBySsn;
import java.util.Optional;
import services.interfaces.clientservice.IfindByLastName;
import services.interfaces.clientservice.IfindByPhoneNumber;


public class ClientRepository extends DaoRepository<Client, Integer> implements IFindByName<Client>, IfindByLastName<Client>, IFindByAge<Client>, IFindBySsn<Client>, IfindByPhoneNumber<Client>,Serializable {

    private static final long serialVersionUID = 1L;

    public ArrayList<Client> listClients = super.entityList;

    @Override
    public List<Client> findByName(String name) {
        return listClients.stream().filter(client -> client.getName().contains(name)).toList();
    }

    @Override
    public List<Client> findByLastName(String lastname) {
        return  listClients.stream().filter(client -> client.getLastName().contains(lastname)).toList();
    }

    @Override
    public List<Client> findByAge(Integer age) {
        return  listClients.stream().filter(client -> client.getAge().equals(age)).toList();
    }

    @Override
    public Optional<Client> findBySsn(Integer ssn) {
        return  listClients.stream().filter(client -> client.getSsn().equals(ssn)).findFirst();
    }

    @Override
    public List<Client> findByPhoneNumber(String phoneNumber) {
          return  listClients.stream().filter(client -> client.getPhoneNumber().equals(phoneNumber)).toList();
    }

}
