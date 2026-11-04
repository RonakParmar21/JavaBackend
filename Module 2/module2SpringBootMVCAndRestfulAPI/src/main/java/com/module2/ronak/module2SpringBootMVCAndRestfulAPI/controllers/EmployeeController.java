package com.module2.ronak.module2SpringBootMVCAndRestfulAPI.controllers;

import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.dto.EmployeeDTO;
import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.entities.EmployeeEntity;
import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.repositories.EmployeeRepository;
import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    public EmployeeController(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    @GetMapping(path = "/getSecretMessage")
    public String getMySuperSecretMessage() {
        return "Secret message : sdlfjksdklf@lskfjk#dsjfkl12214";
    }

    @GetMapping(path = "/{employeeID}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeID") Long id) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                                @RequestParam(required = false) String sortBy) {
//        return "Hi age : " + age + " " + sortBy;
//        return employeeRepository.findAll();
//        return employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
//        inputEmployeeDTO.setId(100L);
//        System.out.println("Employee Id is : " + inputEmployeeDTO.getId());
//        System.out.println("Employee name is : " + inputEmployeeDTO.getName());
//        System.out.println("Employee age is : " + inputEmployeeDTO.getAge());
//        System.out.println("Employee joining date is : " + inputEmployeeDTO.getDateOfJoining());
//        System.out.println("Employee is active : " + inputEmployeeDTO.getActive());
//        return inputEmployeeDTO;
//        return employeeRepository.save(inputEmployeeDTO);

        EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO,
                                          @PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                                 @PathVariable Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(employeeId, updates);
        if (employeeDTO == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(employeeDTO);
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId) {
        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
        if (gotDeleted) return ResponseEntity.ok(true);
        else return ResponseEntity.notFound().build();
    }
}
