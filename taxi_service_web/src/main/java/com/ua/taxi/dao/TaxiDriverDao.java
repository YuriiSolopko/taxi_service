package com.ua.taxi.dao;

import com.ua.taxi.domain.Region;
import com.ua.taxi.domain.TaxiDriver;

import java.util.List;

/**
 * Created by julia on 23.04.2015.
 */
public interface TaxiDriverDao {
    public Long create(TaxiDriver taxiDriver);
    public TaxiDriver read(Long id);
    public void update(TaxiDriver taxiDriver);
    public void delete(TaxiDriver taxiDriver);
    public List<TaxiDriver> findAll();

    public TaxiDriver getByName(String firstName, String lastName);
    public Boolean isExist(String firstName, String lastName);
    public Boolean authentication(Long id, String firstName, String lastName, String patronymic);

    public List<TaxiDriver> getTaxiDriverByRegion(Region region);
    public List<TaxiDriver> getTaxiDriverByCar(Region region, String car);
}
