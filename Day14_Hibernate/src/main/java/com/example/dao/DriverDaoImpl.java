package com.example.dao;

import com.example.model.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class DriverDaoImpl implements DriverDao {

    private final SessionFactory sessionFactory;

    public DriverDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDriver(Driver driver) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(driver);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteDriver(int id) {

    }

    @Override
    public void getDriver(int id) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Driver where idDriver =: id");
            query.setParameter("id", id);
        }
    }

    @Override
    public List<Driver> getListOfDrivers() {
        return null;
    }
}
