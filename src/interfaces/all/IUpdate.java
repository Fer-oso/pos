package interfaces.all;

public interface IUpdate<T,ID> {

    <S extends T> S update(ID id,S s);
}
