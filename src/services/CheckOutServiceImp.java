package services;

import entitys.CheckOut;
import java.util.Optional;
import persistence.CheckOutRepository;
import services.interfaces.checkoutservice.ICheckOutService;

public class CheckOutServiceImp implements ICheckOutService{

    private final CheckOutRepository CheckOutRepository;

    public CheckOutServiceImp(CheckOutRepository CheckOutRepository) {
        this.CheckOutRepository = CheckOutRepository;
    }

    @Override
    public <S extends CheckOut> S save(S s) {
       return CheckOutRepository.save(s);
    }

    @Override
    public void show(CheckOut t) {
        CheckOutRepository.show(t);
    }

    @Override
    public Optional<CheckOut> findById(Integer id) {
       return CheckOutRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
       CheckOutRepository.delete(id);
    }

    
}
