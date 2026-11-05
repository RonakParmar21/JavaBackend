package com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.repositories;

import com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
