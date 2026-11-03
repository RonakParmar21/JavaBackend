package com.module2.ronak.module2SpringBootMVCAndRestfulAPI.repositories;

import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
