package com.mapping.demo.onetoone.embeded.entity;

import jakarta.persistence.Embeddable;
import org.springframework.stereotype.Component;

@Embeddable
public class AddressEntity {
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
