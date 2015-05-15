package com.ua.taxi.service;

import com.ua.taxi.dao.OperatorDao;
import com.ua.taxi.domain.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Jura on 14.05.2015.
 */
@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorDao operatorDao;

    @Override
    public boolean registerOperator(String login, String password) {
        if (operatorDao.readByLogin(login.toLowerCase()) != null) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        Calendar passExpireDate = new GregorianCalendar(instance.get(Calendar.YEAR), instance.get(Calendar.MONTH) + 3, instance.get(Calendar.DAY_OF_MONTH));
        Operator operator = new Operator(login.toLowerCase(), password, passExpireDate);
        Long id = operatorDao.create(operator);
        return id != null;
    }

    @Override
    public boolean operatorLoginCheck(String login) {
        Operator operator = operatorDao.readByLogin(login.toLowerCase());
        return operator == null;
    }
}
