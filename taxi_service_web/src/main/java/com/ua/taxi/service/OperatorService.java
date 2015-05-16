package com.ua.taxi.service;

import com.ua.taxi.domain.Operator;

/**
 * Created by Jura on 14.05.2015.
 */
public interface OperatorService {

    boolean registerOperator(String login, String password);
    boolean operatorLoginCheck(String login);
    boolean authenticate(String login, String password);
    boolean isExpiredPass(String login);
    Operator readByLogin(String login);
}
