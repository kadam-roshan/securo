package org.hachiko.service.securo.dao;

import org.hachiko.service.securo.model.Incident;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IncidentDAOImpl implements IncidentDAO {
    private SessionFactory sessionFactory;

    @Override
    public Incident getIncident(int id) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Incident incident = session.createQuery("from Incident where id=:id", Incident.class)
                .setParameter("id", id).uniqueResult();
        session.close();
        return incident;
    }

    @Override
    public List getIncidents() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Incident");
        List incidents = query.list();
        session.close();
        return incidents;
    }

    @Override
    public List getIncidentsByCountry(String country) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Incident where country=:country");
        query.setParameter("country", country);
        List incidents = query.list();
        session.close();
        return incidents;
    }

    @Override
    public long saveIncident(Incident incident) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer) session.save(incident);
        transaction.commit();
        session.close();
        return id;
    }

    @Override
    public void deleteIncident(int id) {
        Incident incident = getIncident(id);

        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(incident);
        transaction.commit();
        session.close();
    }
}
