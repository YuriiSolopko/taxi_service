package com.ua.taxi.domain;

import javax.persistence.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Jura on 01.04.2015.
 */
@Entity
@Table(name = "OPERATORS")
public class Operator {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "OPERATOR_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "OPERATOR_ID")
    private Long operatorId;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PASS_EXPIRE_DATE")
    private Calendar passExpireDate;

    public Operator() {
    }

    public Operator(String login, String password) {
        this.setLogin(login);
        this.setPassword(password);
        Calendar instance = Calendar.getInstance();
        this.passExpireDate = new GregorianCalendar(instance.get(Calendar.YEAR), instance.get(Calendar.MONTH) + 3, instance.get(Calendar.DAY_OF_MONTH));
    }

    public Operator(String login, String password, Calendar passExpireDate) {
        this.setLogin(login);
        this.setPassword(password);
        Calendar instance = Calendar.getInstance();
        this.passExpireDate = passExpireDate;
    }

    @Override
    public String toString() {
        return "Operator ID: " + operatorId + " = {" + login + " " + password + "}";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getPassExpireDate() {
        return passExpireDate;
    }

    public void setPassExpireDate(Calendar passExpireDate) {
        this.passExpireDate = passExpireDate;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

}
