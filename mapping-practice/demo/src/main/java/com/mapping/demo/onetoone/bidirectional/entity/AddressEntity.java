package com.mapping.demo.onetoone.unidirectonal.entity;

import jakarta.persistence.*;

@Entity
public class AddressEntity {
    @Id
    @GeneratedValue
    private int address_id;
    private String streetNo;
    private String streetName;


    public AddressEntity() {
    }

    public AddressEntity(String streetNo, String streetName) {
        this.streetNo = streetNo;
        this.streetName = streetName;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
