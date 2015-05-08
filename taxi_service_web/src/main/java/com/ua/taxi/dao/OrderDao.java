package com.ua.taxi.dao;


import com.ua.taxi.domain.Order;
import com.ua.taxi.domain.TaxiDriver;

import java.util.List;

/**
 * Created by Jura on 05.04.2015.
 */
public interface OrderDao {
    public Long create(Order order);
    public Order read(Long id);
    public void update(Order order);
    public void delete(Order order);
    public List<Order> findAll();

    public List<Order> findOrdersBySum(Integer from, Integer to);
    public List<Order> findPortion(int firstResult, int maxResults);
    public Long rowCount();

    public List<Order> findByTaxiDriver(TaxiDriver taxiDriver);
    //новый - new, забронирован - reserved, активный,забраный - active,
    // отменен -canceled, executed - выполненый
    public List<Order> findByType(String orderType);
    public List<Order> findByDriverAndType(TaxiDriver taxiDriver, String orderType);

}
