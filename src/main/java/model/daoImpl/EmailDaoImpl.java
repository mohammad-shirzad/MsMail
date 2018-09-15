package model.daoImpl;

import model.dao.EmailDao;
import model.dto.EmailDto;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("EmailDao")
public class EmailDaoImpl extends BaseDaoImpl<EmailDto> implements EmailDao {
    public EmailDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
