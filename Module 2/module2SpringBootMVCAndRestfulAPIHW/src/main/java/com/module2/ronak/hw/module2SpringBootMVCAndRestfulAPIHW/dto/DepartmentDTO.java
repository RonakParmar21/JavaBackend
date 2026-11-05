package com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;
    @NotBlank(message = "Title of department cannot be blank.")
    @Size(min = 2, max = 10, message = "Number of character for title between range 3 to 10.")
    private String title;

    @AssertTrue(message = "Department should be active.")
    private Boolean isActive;

    @CreationTimestamp
    private LocalDate createdAt;
}
