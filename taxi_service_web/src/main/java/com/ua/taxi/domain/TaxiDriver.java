package com.ua.taxi.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by julia on 23.04.2015.
 */

@Entity
@Table(name="TAXI_DRIVER")
public class TaxiDriver {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "TAXI_DRIVER_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "TAXI_DRIVER_ID")
    private Long taxiDriverId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PATRONYMIC")
    private String patronymic;

    @Column(name="CAR_BRAND")
    private String carBrand;

    @Column(name="PHONE")
    private String phone;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "taxiDriver")
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference
    private Set<Order> ordersSet;

    @ManyToOne
    @JsonBackReference
    private Region region;

    public TaxiDriver() {
    }

    public TaxiDriver(String firstName, String lastName, String patronymic,
                      String carBrand, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.carBrand = carBrand;
        this.phone = phone;
    }

    public TaxiDriver(String firstName, String lastName, String patronymic,
                      String carBrand, String phone, Set<Order> ordersSet, Region region) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.carBrand = carBrand;
        this.phone = phone;
        this.ordersSet = ordersSet;
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Long getTaxiDriverId() {
        return taxiDriverId;
    }

    //public void setTaxiDriverId(Long taxiDriverId) {
    //    this.taxiDriverId = taxiDriverId;
    //}

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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Order> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Order> ordersSet) {
        this.ordersSet = ordersSet;
    }

    public boolean addOrdersSet(Order order){
        return ordersSet.add(order);
    }

    @Override
    public String toString() {
        return "TaxiDriver{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", carBrand='" + carBrand + '\'' +
                '}';
    }
}
