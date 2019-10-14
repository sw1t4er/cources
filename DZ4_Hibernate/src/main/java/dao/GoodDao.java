package dao;

import model.Good;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import java.util.List;

public class GoodDao<T> {

    public Good findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Good.class, id);
    }

    public void save(Good good) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(good);
        tx1.commit();
        session.close();
    }

    public void update(Good good) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(good);
        tx1.commit();
        session.close();
    }

    public void delete(Good good) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(good);
        tx1.commit();
        session.close();
    }

    public List<Good> findAll() {
        List<Good> goods = (List<Good>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From Good where isActive=true").list();

        return goods;

    }
}
