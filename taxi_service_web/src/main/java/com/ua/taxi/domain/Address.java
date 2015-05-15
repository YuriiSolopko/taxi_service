package com.ua.taxi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by julia on 27.04.2015.
 */

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "ADDRESS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ADDRESS_ID")
    private Long addressId;

    @Column(name = "ADDRESS_NAME")
    private String addressName;

    @ManyToOne
    @JsonBackReference
    private Region region;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "addressTo")
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference
    private Set<Order> ordersSetTo;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "addressFrom")
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference
    private Set<Order> ordersSetFrom;

    public Address() {
    }

    public Address(String addressName, Region region) {
        this.addressName = addressName;
        this.region = region;
    }

    public Long getAddressId() {
        return addressId;
    }

    //public void setAddressId(Long addressId) {
    //    this.addressId = addressId;
    //}

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", addressName='" + addressName + '\'' +
                ", region=" + region +
                '}';
    }
}
