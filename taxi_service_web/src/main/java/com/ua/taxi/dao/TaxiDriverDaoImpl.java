package com.ua.taxi.dao;

import com.ua.taxi.domain.Region;
import com.ua.taxi.domain.TaxiDriver;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by julia on 23.04.2015.
 */

@Repository
public class TaxiDriverDaoImpl implements TaxiDriverDao {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public Long create(TaxiDriver taxiDriver) {
        sessionFactory.getCurrentSession().save(taxiDriver);
        return taxiDriver.getTaxiDriverId();
    }

    @Override
    public TaxiDriver read(Long id) {
        return (TaxiDriver) sessionFactory.getCurrentSession().get(TaxiDriver.class, id);
    }

    @Override
    public void update(TaxiDriver taxiDriver) {
        sessionFactory.getCurrentSession().update(taxiDriver);
    }

    @Override
    public void delete(TaxiDriver taxiDriver) {
        sessionFactory.getCurrentSession().delete(taxiDriver);
    }

    @Override
    public List<TaxiDriver> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(TaxiDriver.class).list();
    }

    @Override
    public TaxiDriver getByName(String firstName, String lastName) {
        return (TaxiDriver) sessionFactory.getCurrentSession().createCriteria(TaxiDriver.class)
                .add(Restrictions.eq("firstName", firstName))
                .add(Restrictions.eq("lastName", lastName))
                .uniqueResult();
    }

    @Override
    public Boolean isExist(String firstName, String lastName) {
        TaxiDriver taxiDriver=getByName(firstName, lastName);

        if (taxiDriver != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean authentication(Long id, String firstName, String lastName, String patronymic) {
        TaxiDriver taxiDriver = (TaxiDriver) sessionFactory.getCurrentSession()
                .createCriteria(TaxiDriver.class)
                .add(Restrictions.eq("taxiDriverId", id))
                .add(Restrictions.eq("firstName", firstName))
                .add(Restrictions.eq("lastName", lastName))
                .add(Restrictions.eq("patronymic", patronymic))
                .uniqueResult();
        if (taxiDriver == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<TaxiDriver> getTaxiDriverByRegion(Region region) {
        return sessionFactory.getCurrentSession()
                .createCriteria(TaxiDriver.class)
                .add(Restrictions.eq("region", region))
                .list();
    }

    @Override
    public List<TaxiDriver> getTaxiDriverByCar(Region region, String car) {
        return sessionFactory.getCurrentSession()
                .createCriteria(TaxiDriver.class)
                .add(Restrictions.eq("region", region))
                .add(Restrictions.like("carBrand", car + "%"))
                .list();
    }
}
