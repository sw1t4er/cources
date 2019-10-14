package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;
import java.util.List;

public class Dao<T> {

    private Class<T> persistentClass;

    public Dao(Class<T> typeParameterClass) {
        this.persistentClass = typeParameterClass;
    }
    public Class<T> getClassT(){
        return persistentClass;
    }

    public T findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(persistentClass, id);
    }

    public void save(T user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(T user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(T user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public List<T> findAll() {
        List<T> users = (List<T>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From "+persistentClass+" where isActive=true").list();

        return users;

    }
}
