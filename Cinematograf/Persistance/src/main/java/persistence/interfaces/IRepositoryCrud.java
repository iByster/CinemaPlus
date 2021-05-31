package persistence.interfaces;

import java.util.List;

public interface IRepositoryCrud<T, ID> {
    T save(T t);
    T findOne(ID id);
    T update(T t);
    T delete(T t);
    List<T> getAll();
    int size();
}
