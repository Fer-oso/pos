package interfaces.crud;

public interface ICrud<T,ID> extends ISave<T>,IShow<T>,IUpdate<T,ID>,IDelete<ID> {
    
    
  
}
