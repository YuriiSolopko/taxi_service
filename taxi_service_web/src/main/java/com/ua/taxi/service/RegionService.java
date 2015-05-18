package com.ua.taxi.service;

import com.ua.taxi.domain.Region;

import java.util.List;

/**
 * Created by Jura on 15.05.2015.
 */
public interface RegionService {

    List<Region> getRegions();
    boolean addRegion(String regionName);
    boolean editRegion(String regionName, String regionId);
}
