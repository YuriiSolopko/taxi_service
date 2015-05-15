package com.ua.taxi.service;

/**
 * Created by Jura on 14.05.2015.
 */
public interface OperatorService {

    boolean registerOperator(String login, String password);
    boolean operatorLoginCheck(String login);
}
