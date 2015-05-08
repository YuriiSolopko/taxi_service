package com.ua.taxi.dao;

import com.ua.taxi.domain.Address;

import java.util.List;

/**
 * Created by julia on 27.04.2015.
 */
public interface AddressDao {
    public Long create(Address address);
    public Address read(Long id);
    public void update(Address address);
    public void delete(Address address);
    public List<Address> findAll();


}
