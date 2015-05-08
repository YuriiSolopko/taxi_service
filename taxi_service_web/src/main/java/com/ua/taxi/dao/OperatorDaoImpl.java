package com.ua.taxi.dao;

import com.ua.taxi.domain.Operator;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Jura on 01.04.2015.
 */
@Repository
public class OperatorDaoImpl implements OperatorDao {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public OperatorDaoImpl() {
    }

    @Override
    public Long create(Operator operator) {
        sessionFactory.getCurrentSession().save(operator);
        return operator.getOperatorId();
    }

    @Override
    public Operator read(Long id) {
        return (Operator) sessionFactory.getCurrentSession().get(Operator.class, id);
    }

    @Override
    public Operator readByLogin(String login) {
        return (Operator) sessionFactory.getCurrentSession().createCriteria(Operator.class)
                .add(Restrictions.eq("login", login.toLowerCase())).uniqueResult();
    }

    @Override
    public void update(Operator operator) {
        sessionFactory.getCurrentSession().update(operator);
    }

    @Override
    public void delete(Operator operator) {
        sessionFactory.getCurrentSession().delete(operator);
    }

    @Override
    public List<Operator> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Operator.class).list();
    }

    @Override
    public boolean authenticate(String login, String password) {
        Operator operator = (Operator) sessionFactory.getCurrentSession().createCriteria(Operator.class)
                .add(Restrictions.eq("login", login.toLowerCase())).add(Restrictions.eq("password", password)).uniqueResult();
        if (operator != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isExpiredPass(String login) {
        Operator operator = (Operator) sessionFactory.getCurrentSession().createCriteria(Operator.class)
                .add(Restrictions.eq("login", login.toLowerCase())).uniqueResult();
        if (operator != null) {
            Calendar instance = Calendar.getInstance();
            if (operator.getPassExpireDate().compareTo(instance) > 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
