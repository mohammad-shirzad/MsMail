package model.daoImpl;

import model.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;

@org.springframework.stereotype.Repository
public class BaseDaoImpl<T,Id extends Serializable> implements BaseDao<T,Id> {

    public SessionFactory sessionFactory;
    public Session session;

    public Class<T> clazz;

    @Autowired
    public  BaseDaoImpl(SessionFactory sessionFactory) {
        try {
            this.sessionFactory = sessionFactory;
            this.session = sessionFactory.openSession();
        }catch (Exception e){
            e.getStackTrace();
        }
    }


    @Override
    public void save(T t){
        session.saveOrUpdate(t);
    }
    @Override
    public List<T> getAll(){
        return session.createQuery("from " + clazz.getName()).list();
    }
    @Override
    public void delete(T t){
        session.delete(t);
    }
}
