package com.mapping.demo.onetoone.embeded.repository;

import com.mapping.demo.onetoone.embeded.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,Integer> {
}
