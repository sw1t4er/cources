package dao;

import model.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import java.util.List;

public class AddressDao<T> {

    public Address findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Address.class, id);
    }

    public void save(Address address) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(address);
        tx1.commit();
        session.close();
    }

    public void update(Address address) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(address);
        tx1.commit();
        session.close();
    }

    public void delete(Address address) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(address);
        tx1.commit();
        session.close();
    }

    public List<Address> findAll() {
        List<Address> addresss = (List<Address>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From Address where isActive=true").list();

        return addresss;

    }
}
