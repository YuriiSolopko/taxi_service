package com.ua.taxi.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by julia on 27.04.2015.
 */

@Entity
@Table(name = "REGION")
public class Region {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "REGION_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "REGION_ID")
    private Long regionId;

    @Column(name = "REGION_NAME")
    private String regionName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "region")
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference
    private Set<Address> addressesSet;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "region")
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference
    private Set<TaxiDriver> taxiDriversSet;

    public Region() {
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public Long getRegionId() {
        return regionId;
    }

   // public void setRegionId(Long regionId) {
   //     this.regionId = regionId;
   // }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Set<Address> getAddressesSet() {
        return addressesSet;
    }

    public void setAddressesSet(Set<Address> addressesSet) {
        this.addressesSet = addressesSet;
    }

    public boolean addAddressesSet(Address address){
        return addressesSet.add(address);
    }

    public boolean addTaxiDriversSet(TaxiDriver taxiDriver){
        return taxiDriversSet.add(taxiDriver);
    }
    @Override
    public String toString() {
        return "Region{" +
                "regionId=" + regionId +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
