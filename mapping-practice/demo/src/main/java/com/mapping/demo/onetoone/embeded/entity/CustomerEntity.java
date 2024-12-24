package com.mapping.demo.onetoone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "customer")
@Entity
public class CustomerEntity {

    @Id
    @Column(name = "customer_id")
    private int id;
    private String name;


}
