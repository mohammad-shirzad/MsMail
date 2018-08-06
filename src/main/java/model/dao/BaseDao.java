package model.dao;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface BaseDao<T,Id> extends Repository<T,Id>{
    void save(T t);
    List<T> getAll();
    void delete(T t);

}
