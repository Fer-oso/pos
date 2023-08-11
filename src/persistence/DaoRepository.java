package persistence;

import persistence.interfaces.CrudRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import interfaces.entity.Entity;

public abstract class DaoRepository<T extends Entity<ID>,ID> implements CrudRepository<T, ID>{
    
    List<T> entityList = new ArrayList<>();
    
    @Override
    public <S extends T> S save(S t) {       
        entityList.add(t);
        return t;
    }
    
    @Override
    public void show(T t) {
        System.out.println(t);
    }
    
    @Override
    public <S extends T> S update(ID id, S s) {        
        try {
            if (id.equals(s.getId())) {
                 entityList.set((int)s.getId(), s); 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return s;
       
    }
    
    @Override
    public void delete(ID id) {
        Iterator<T> iteratorList = entityList.iterator();
        while (iteratorList.hasNext()) {
            if (iteratorList.next().getId() == id) {
                iteratorList.remove();
                break;
            }            
        }
    }

    @Override
    public Optional<T> findById(ID id) {
      return entityList.stream().filter(entity -> {
           return entity.getId() == (id);
       }).findFirst();
   
    }
    
    @Override
    public List<T> findAll() {
        return entityList;
    }   
    
}
