package com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.controllers;

import com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.dto.DepartmentDTO;
import com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.entities.DepartmentEntity;
import com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.exceptions.ResourceNotFoundException;
import com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.services.DepartmentService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable(name = "departmentId") Long id) {
        Optional<DepartmentDTO> departmentDTO = departmentService.getEmployeeById(id);

        return departmentDTO
                .map(departmentDTO1 -> ResponseEntity.ok(departmentDTO1))
                .orElseThrow(() -> new ResourceNotFoundException("Department not found."));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment() {
        List<DepartmentDTO> departments = departmentService.getAllDepartment();
        if (departments.isEmpty()) throw new ResourceNotFoundException("No departments found.");
        return ResponseEntity.ok(departments);
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO inputDepartment) {
        DepartmentDTO savedDepartment = departmentService.createNewDepartment(inputDepartment);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId) {
        boolean gotDeleted = departmentService.deleteDepartmentById(departmentId);
        if (gotDeleted) return ResponseEntity.ok(true);
        else return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody @Valid DepartmentDTO departmentDTO, @PathVariable Long departmentId) {
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentId, departmentDTO));
    }
}
