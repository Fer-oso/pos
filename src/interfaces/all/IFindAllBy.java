package interfaces.all;

import java.util.List;

public interface IFindAllBy<T,V extends Object>{

   List<T> findAllBy(List<T>list, V arg);

}
