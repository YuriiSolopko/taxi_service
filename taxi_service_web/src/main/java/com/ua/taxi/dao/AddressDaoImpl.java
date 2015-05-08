package com.ua.taxi.dao;

import com.ua.taxi.domain.Address;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by julia on 27.04.2015.
 */
@Repository
public class AddressDaoImpl implements AddressDao {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public Long create(Address address) {
        sessionFactory.getCurrentSession().save(address);
        return address.getAddressId();
    }

    @Override
    public Address read(Long id) {
        return (Address) sessionFactory.getCurrentSession().get(Address.class, id);
    }

    @Override
    public void update(Address address) {
        sessionFactory.getCurrentSession().update(address);
    }

    @Override
    public void delete(Address address) {
        sessionFactory.getCurrentSession().delete(address);

    }

    @Override
    public List<Address> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Address.class).list();
    }
}
