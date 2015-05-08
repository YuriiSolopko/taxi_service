package com.ua.taxi.dao;

import com.ua.taxi.domain.Region;

import java.util.List;

/**
 * Created by julia on 27.04.2015.
 */
public interface RegionDao {
    public Long create(Region region);
    public Region read(Long id);
    public void update(Region region);
    public void delete(Region region);
    public List<Region> findAll();
}
