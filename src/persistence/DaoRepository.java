package persistence;

import interfaces.repository.IRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class DaoRepository<T, ID> implements IRepository<T, ID> {

    

    List<T> entityList = new ArrayList<>();

    @Override
    public <S extends T> S save(S s) {
       
        entityList.add(s);
        return s;
    }

    @Override
    public void show(T t) {
        System.out.println(t);
    }

    @Override
    public <S extends T >S update(ID id, S s) {
        entityList.set((int) id, s);
        return s;

    }

    @Override
    public void delete(ID id) {
         Iterator<T> iteratorList = entityList.iterator();
         T entity = findById(id);
         while (iteratorList.hasNext()) {
             if (iteratorList.next().equals(entity)) {
                 iteratorList.remove();
             }
            
        }
     //   entityList.remove(findById(id));
    }

    @Override
    public T findById(ID id) {
        return entityList.get((int) id);
    }

    @Override
    public List<T> findAll() {
        return entityList;
    }

}
