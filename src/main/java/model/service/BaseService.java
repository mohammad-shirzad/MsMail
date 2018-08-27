package model.service;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BaseService<T> {
    void saveEntity(T t);

    List<T> getAll();

    void deleteEntity(T t);

    T getInstanceByField(String colName, String value);

    List<T> getListByField(String colName, String value);

    T getEntityById(T t, int id);
}
