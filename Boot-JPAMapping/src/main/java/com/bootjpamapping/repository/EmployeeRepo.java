package com.bootjpamapping.repository;

import com.bootjpamapping.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<EmployeeEntity,Long> {

}
