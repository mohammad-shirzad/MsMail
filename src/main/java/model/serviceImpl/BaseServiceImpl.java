package model.serviceImpl;

import model.dao.BaseDao;
import model.service.BaseService;

import javax.annotation.PostConstruct;
import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {


    BaseDao baseDao;

    @PostConstruct
    public void init() {
        baseDao = getDao();
    }

    public abstract BaseDao getDao();

    @Override
    public void saveEntity(T t) {
        baseDao.save(t);
    }

    @Override
    public List getAll() {
        return baseDao.getAll();
    }

    @Override
    public void deleteEntity(T t) {
        baseDao.delete(t);
    }

    @Override
    public T getInstanceByField(String colName, String value) {
        return (T) getDao().getInstanceByField(colName, value);
    }

    @Override
    public List<T> getListByField(String colName, String value) {
        return getDao().getListByField(colName, value);
    }

    @Override
    public T getEntityById(T t, int id) {
        return (T) getDao().getById(t, id);
    }
}
