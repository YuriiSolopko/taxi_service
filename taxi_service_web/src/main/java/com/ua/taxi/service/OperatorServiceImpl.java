package com.ua.taxi.service;

import com.ua.taxi.dao.OperatorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jura on 14.05.2015.
 */
@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorDao operatorDao;
}
