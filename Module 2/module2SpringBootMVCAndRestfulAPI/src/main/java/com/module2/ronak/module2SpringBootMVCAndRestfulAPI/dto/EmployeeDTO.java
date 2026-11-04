package com.module2.ronak.module2SpringBootMVCAndRestfulAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.annotations.EmployeeRoleValidation;
import com.module2.ronak.module2SpringBootMVCAndRestfulAPI.annotations.PrimeNumberValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotNull(message = "Required field in employee name.")
    @NotEmpty(message = "Name of employee not empty.")
    @NotBlank(message = "Name of employee cannot be blank.")
    @Size(min = 3, max = 10, message = "Number of characters in name should be in the range 3 to 10.")
    private String name;

    @NotBlank(message = "Employee email can not be blank.")
    @Email(message = "Email should be a valid email.")
    private String email;

    @NotNull(message = "Employee age can not be null.")
    @Max(value = 80, message = "Age of employee can not be greater than 80.")
    @Min(value = 18, message = "Age of employee can not be less than 18.")
    private Integer age;

    @NotNull(message = "Employee salary should be not null.")
    @Positive(message = "Employee salary should be positive.")
    @Digits(integer = 6, fraction = 2, message = "The salary can be in the form of xxxxxx.yy")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @NotBlank(message = "Employee role can not be blank.")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of employee can be USER or ADMIN.")
    @EmployeeRoleValidation
    private String role; // ADMIN, USER

//    @Past(message = "Employee joining date shoud be past")
    @PastOrPresent(message = "Date of joining field in employee cannot be in the future.")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active.")
    private Boolean isActive;

//    @PrimeNumberValidation
//    private Integer isPrime;
}
