package com.mapping.demo.onetoone.unidirectonal.entity;

import jakarta.persistence.*;

@Table(name = "customer")
@Entity
public class CustomerEntity {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "f_id")
    private AddressEntity addressEntity;

    public CustomerEntity() {
    }

    public CustomerEntity(int id, String name, AddressEntity addressEntity) {
        this.id = id;
        this.name = name;
        this.addressEntity = addressEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }
}
