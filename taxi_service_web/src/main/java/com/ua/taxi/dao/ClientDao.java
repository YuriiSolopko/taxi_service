package com.ua.taxi.dao;

import com.ua.taxi.domain.Client;

import java.util.List;

/**
 * Created by Jura on 03.04.2015.
 */
public interface ClientDao {
    public Long create(Client client);
    public Client read(Long id);
    public void update(Client client);
    public void delete(Client client);
    public List<Client> findAll();
    public List<Client> findPortion(int firstResult, int maxResults);
    public Long rowCount();
    public List<Client> lastMonth();
    public List<Client> showGtSum(Integer sum);
    public Client readByPhoneNo(String phoneNumber);
}
