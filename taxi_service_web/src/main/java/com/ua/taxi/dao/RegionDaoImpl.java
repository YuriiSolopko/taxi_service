package com.ua.taxi.dao;

import com.ua.taxi.domain.Region;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by julia on 27.04.2015.
 */
@Repository
public class RegionDaoImpl implements RegionDao{

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public Long create(Region region) {
        sessionFactory.getCurrentSession().save(region);
        return region.getRegionId();
    }

    @Override
    public Region read(Long id) {
        return (Region) sessionFactory.getCurrentSession().get(Region.class, id);
    }

    @Override
    public void update(Region region) {
        sessionFactory.getCurrentSession().update(region);
    }

    @Override
    public void delete(Region region) {
        sessionFactory.getCurrentSession().delete(region);
    }

    @Override
    public List<Region> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Region.class).list();
    }
}
