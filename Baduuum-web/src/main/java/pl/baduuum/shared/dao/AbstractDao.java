package pl.baduuum.shared.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import pl.baduuum.server.db.configuration.HibernateConfiguration;

import javax.transaction.TransactionManager;
import javax.transaction.Transactional;

/**
 * Created by mario on 18/07/15.
 */
public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    HibernateTransactionManager transactionManager;

    protected Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (Exception e){
            return sessionFactory.openSession();
        }


    }

    @Transactional
    public void persist(Object entity) {
        getSession().persist(entity);



    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }
}
