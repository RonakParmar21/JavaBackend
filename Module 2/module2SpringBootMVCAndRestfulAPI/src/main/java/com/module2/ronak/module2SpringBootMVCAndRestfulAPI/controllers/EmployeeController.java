package com.module2.ronak.module2SpringBootMVCAndRestfulAPI.controllers;

import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.dto.EmployeeDTO;
import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.entities.EmployeeEntity;
import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.repositories.EmployeeRepository;
import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeID") Long id) {
//        return employeeRepository.findById(id).orElse(null);
//        return new EmployeeDTO(id, "Ronak", "ronak@gmail.com", 23, LocalDate.of(2024, 1, 2), true);
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                                @RequestParam(required = false) String sortBy) {
//        return "Hi age : " + age + " " + sortBy;
//        return employeeRepository.findAll();
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
//        inputEmployeeDTO.setId(100L);
//        System.out.println("Employee Id is : " + inputEmployeeDTO.getId());
//        System.out.println("Employee name is : " + inputEmployeeDTO.getName());
//        System.out.println("Employee age is : " + inputEmployeeDTO.getAge());
//        System.out.println("Employee joining date is : " + inputEmployeeDTO.getDateOfJoining());
//        System.out.println("Employee is active : " + inputEmployeeDTO.getActive());
//        return inputEmployeeDTO;
//        return employeeRepository.save(inputEmployeeDTO);

        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO,
                                          @PathVariable Long employeeId) {
        return employeeService.updateEmployeeById(employeeId, employeeDTO);
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDTO updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                                 @PathVariable Long employeeId) {
        return employeeService.updatePartialEmployeeById(employeeId, updates);
    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }
}
