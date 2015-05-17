package com.ua.taxi.service;

import com.ua.taxi.dao.RegionDao;
import com.ua.taxi.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jura on 15.05.2015.
 */
@Service
@Transactional
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionDao regionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Region> getRegions() {
        return regionDao.findAll();
    }

    @Override
    public boolean addRegion(String regionName) {
        return regionDao.create(new Region(regionName)) == null ? false : true;
    }
}
