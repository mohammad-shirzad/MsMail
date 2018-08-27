package model.dao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseDao<T> {
    void save(T t);
    List<T> getAll();
    void delete(T t);

    T getInstanceByField(String tableColName, String value);

    List<T> getListByField(String tableColName, String value);

    void update(T t);

    T getById(T t, int id);

}
