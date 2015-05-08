package com.ua.taxi.dao;

import com.ua.taxi.domain.Client;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Jura on 03.04.2015.
 */
@Repository
public class ClientDaoImpl implements ClientDao {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public Long create(Client client) {
        sessionFactory.getCurrentSession().save(client);
        return client.getClientId();
    }

    @Override
    public Client read(Long id) {
        return (Client) sessionFactory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public void update(Client client) {
        sessionFactory.getCurrentSession().update(client);
    }

    @Override
    public void delete(Client client) {
        sessionFactory.getCurrentSession().delete(client);
    }

    @Override
    public List<Client> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Client.class).list();
    }

    @Override
    public List<Client> findPortion(int firstResult, int maxResults) {
        return sessionFactory.getCurrentSession().createCriteria(Client.class)
                .setFirstResult(firstResult).setMaxResults(maxResults).list();
    }

    @Override
    public Long rowCount() {
        return (Long) sessionFactory.getCurrentSession().createCriteria(Client.class)
                .setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public List<Client> lastMonth() {
        Calendar instance = Calendar.getInstance();
        Calendar month = new GregorianCalendar(instance.get(Calendar.YEAR), instance.get(Calendar.MONTH) - 1, instance.get(Calendar.DAY_OF_MONTH));
        return sessionFactory.getCurrentSession().createCriteria(Client.class).
                add(Restrictions.gt("lastOrderDate", month)).list();

    }

    @Override
    public List<Client> showGtSum(Integer sum) {
        return sessionFactory.getCurrentSession().createCriteria(Client.class).add(Restrictions.gt("sum", sum)).list();
    }

    @Override
    public Client readByPhoneNo(String phoneNumber) {
        return (Client) sessionFactory.getCurrentSession().createCriteria(Client.class).add(Restrictions.eq("phoneNumber", phoneNumber)).uniqueResult();
    }
}
