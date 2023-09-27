package com.geekster.EventManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    @Id
   @NotNull(message = "id should not be null")
    private Long studentId;

    @NotBlank
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Z][a-z]*", message = "First letter should be capital")
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 25)
    private String lastName;

    @Min(18)
    @Max(25)
    private int age;

    @Enumerated(EnumType.STRING)
    private Department department;

}
