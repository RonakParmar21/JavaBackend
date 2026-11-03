package com.module2.ronak.module2SpringBootMVCAndRestfulAPI.controllers;

import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.dto.EmployeeDTO;
import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.entities.EmployeeEntity;
import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/getSecretMessage")
    public String getMySuperSecretMessage() {
        return "Secret message : sdlfjksdklf@lskfjk#dsjfkl12214";
    }

    @GetMapping(path = "/{employeeID}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeID") Long id) {
        return employeeRepository.findById(id).orElse(null);
//        return new EmployeeDTO(id, "Ronak", "ronak@gmail.com", 23, LocalDate.of(2024, 1, 2), true);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                                @RequestParam(required = false) String sortBy) {
//        return "Hi age : " + age + " " + sortBy;
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployeeDTO) {
//        inputEmployeeDTO.setId(100L);
//        System.out.println("Employee Id is : " + inputEmployeeDTO.getId());
//        System.out.println("Employee name is : " + inputEmployeeDTO.getName());
//        System.out.println("Employee age is : " + inputEmployeeDTO.getAge());
//        System.out.println("Employee joining date is : " + inputEmployeeDTO.getDateOfJoining());
//        System.out.println("Employee is active : " + inputEmployeeDTO.getActive());
//        return inputEmployeeDTO;
        return employeeRepository.save(inputEmployeeDTO);
    }

    @PutMapping
    public String updateEmployeeById() {
        return "Hello from put...";
    }

    @DeleteMapping
    public String deleteEmployeeById() {
        return "Hello from delete...";
    }

    @PatchMapping
    public String patchMapping() {
        return "Hello from patch...";
    }
}
