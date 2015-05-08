package com.ua.taxi.dao;

import com.ua.taxi.domain.Operator;

import java.util.List;

/**
 * Created by Jura on 01.04.2015.
 */
public interface OperatorDao {

    public Long create(Operator operator);
    public Operator read(Long id);
    public Operator readByLogin(String login);
    public void update(Operator operator);
    public void delete(Operator operator);
    public List<Operator> findAll();
    public boolean authenticate(String login, String password);
    public boolean isExpiredPass(String login);
}
