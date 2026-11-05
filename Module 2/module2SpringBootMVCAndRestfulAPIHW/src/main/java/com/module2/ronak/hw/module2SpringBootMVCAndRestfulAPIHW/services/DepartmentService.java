package com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.services;

import com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.configs.MapperConfig;
import com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.dto.DepartmentDTO;
import com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.entities.DepartmentEntity;
import com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.exceptions.ResourceNotFoundException;
import com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<DepartmentDTO> getEmployeeById(Long id) {
        return departmentRepository.findById(id).map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class));
    }

    public List<DepartmentDTO> getAllDepartment() {
        List<DepartmentEntity> departmentEntityList = departmentRepository.findAll();

        return departmentEntityList
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentDTO createNewDepartment(DepartmentDTO inputDepartment) {
        DepartmentEntity toSaveEntity = modelMapper.map(inputDepartment, DepartmentEntity.class);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(toSaveEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }

    public boolean deleteDepartmentById(Long departmentId) {
        boolean exists = departmentRepository.existsById(departmentId);
        if (!exists) throw new ResourceNotFoundException("Department not found with id : " + departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }

    public DepartmentDTO updateDepartmentById(Long departmentId, DepartmentDTO departmentDTO) {
        boolean exists = departmentRepository.existsById(departmentId);
        if (!exists) throw new ResourceNotFoundException("Department not found with id : " + departmentId);

        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);

        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }
}
