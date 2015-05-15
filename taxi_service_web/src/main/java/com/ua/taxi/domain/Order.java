package com.ua.taxi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Jura on 05.04.2015.
 */
@Entity
@Table(name = "ORDERS")
public class Order {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "ORDER_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "ORDER_DATE")
    private Calendar orderDate;

    @Column(name = "SUM")
    private Integer sum;

    @ManyToOne
    @JsonBackReference
    private Address addressFrom;

    @ManyToOne
    @JsonBackReference
    private Address addressTo;

    //новый - new, (забронирован - reserved,) активный,забраный - active,
    // отменен -canceled, executed - выполненый
    @Column(name="ORDER_TYPE")
    private String orderType;

    @ManyToOne
    @JsonBackReference
    private TaxiDriver taxiDriver;

    public Order() {
    }

    public Order(Calendar orderDate, Integer sum, Address addressFrom, Address addressTo) {
        this.orderDate = orderDate;
        this.sum = sum;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.orderType="new";
    }

    public Order(Calendar orderDate, Integer sum, Address addressFrom, Address addressTo,
                 String orderType, TaxiDriver taxiDriver) {
        this.orderDate = orderDate;
        this.sum = sum;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.orderType = orderType;
        this.taxiDriver = taxiDriver;
    }


    public Long getOrderId() {
        return orderId;
    }

   // public void setOrderId(Long orderId) {
   //     this.orderId = orderId;
   // }

    public String getOrderDate() {
        if (orderDate == null) {
            return "";
        }
        return DATE_FORMAT.format(orderDate.getTime());
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Address getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(Address addressFrom) {
        this.addressFrom = addressFrom;
    }

    public Address getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(Address addressTo) {
        this.addressTo = addressTo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public TaxiDriver getTaxiDriver() {
        return taxiDriver;
    }

    public void setTaxiDriver(TaxiDriver taxiDriver) {
        this.taxiDriver = taxiDriver;
    }

    public Calendar getOrderCalendarDate(){
        return orderDate;
    }

    public String toString() {
        return orderId + "|" + sum + "|" + addressFrom + "|" + addressTo + "|\n";
    }
}
