package interfaces.all;

public interface ISave<T> {
    
   <S extends T> S save(S s);
}