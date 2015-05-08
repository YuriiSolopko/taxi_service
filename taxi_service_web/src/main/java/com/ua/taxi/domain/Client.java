package com.ua.taxi.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Jura on 03.04.2015.
 */
@Entity
@Table(name = "CLIENTS")
public class Client {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CLIENT_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "CLIENT_ID")
    private Long clientId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "SUM")
    private Integer sum;

    @Column(name = "LAST_ORDER_DATE")
    private Calendar lastOrderDate;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
//    @Fetch(FetchMode.SELECT)
//    private Set<Order> orderSet;

    public Client() {
    }

    public Client(String name, String surname, String phone, String address) {
        this.firstName = name;
        this.lastName = surname;
        this.phoneNumber = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        String id;
        String name;
        String surname;
        String phone;
        String addr;
        String summa;
        String date;
        return firstName + " " + lastName;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getLastOrderDate() {
        if (lastOrderDate == null) {
            return "";
        }
        return DATE_FORMAT.format(lastOrderDate.getTime());
    }

    public void setLastOrderDate(Calendar lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }
/*
    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }*/
}
