package persistence;

import java.util.List;
import entitys.Client;
import interfaces.all.IFindAllBy;
import interfaces.entity.client.IClient;

public class ClientRepository extends DaoRepository<Client, Integer> implements IClient<Client, Integer> {

    public List<Client> listClients = super.entityList;

    @Override
    public List<Client> findByName(String name) {
        IFindAllBy<Client, String> findAllByName = (list, n) -> list.stream().filter(client -> client.getName().contains(n)).toList();
        return findAllByName.findAllBy(listClients, name);
    }

    @Override
    public List<Client> findByLastName(String lastname) {
        return  listClients.stream().filter(client -> client.getLastName().contains(lastname)).toList();
    }

    @Override
    public List<Client> findByAge(Integer age) {
        IFindAllBy<Client, Integer> findAllByAge = (list, a) -> list.stream().filter(client -> client.getAge().equals(a)).toList();
        return findAllByAge.findAllBy(listClients, age);
    }

    @Override
    public List<Client> findBySsn(Integer ssn) {
        IFindAllBy<Client, Integer> iFindBySsn = (list, s) -> listClients.stream().filter(client -> client.getSsn().equals(s)).toList();
        return iFindBySsn.findAllBy(listClients, ssn);
    }

    @Override
    public List<Client> findByPhoneNumber(Integer phoneNumber) {
        IFindAllBy<Client, Integer> iFindByPhoneNumber = (list, pn) -> listClients.stream().filter(client -> client.getAge().equals(pn)).toList();
        return iFindByPhoneNumber.findAllBy(listClients, phoneNumber);
    }

}
