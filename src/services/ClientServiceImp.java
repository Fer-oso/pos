package services;

import java.util.List;
import entitys.Client;
import java.util.Optional;
import persistence.ClientRepository;
import services.interfaces.IclientService;

public class ClientServiceImp implements IclientService<Client, Integer> {

    private final ClientRepository clientRepository;
    
    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository =  clientRepository;
    }

    
    @Override
    public <S extends Client> S save(S s) {
        return clientRepository.save(s);
    }

    @Override
    public void show(Client t) {
        clientRepository.show(t);
    }

    @Override
    public <S extends Client> S update(Integer id, S s) {
        return clientRepository.update(id, s);
    }

    @Override
    public void delete(Integer id) {
        clientRepository.delete(id);
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
    @Override
    public List<Client> findByName(String name) {
        return clientRepository.findByName(name);
    }

    @Override
    public List<Client> findByLastName(String lastName) {
       return clientRepository.findByLastName(lastName);
    }

    @Override
    public List<Client> findByAge(Integer integer) {
        return clientRepository.findByAge(integer);
    }

    @Override
    public Optional<Client> findBySsn(Integer ssn) {
        return clientRepository.findBySsn(ssn);
    }

    @Override
    public List<Client> findByPhoneNumber(Integer phoneNumber) {
        return clientRepository.findByPhoneNumber(phoneNumber);
    }


}
