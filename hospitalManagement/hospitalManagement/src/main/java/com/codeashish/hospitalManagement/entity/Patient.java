package com.codeashish.hospitalManagement.entity;

import jakarta.persistence.*;
        import jakarta.validation.constraints.*;
        import java.time.LocalDate;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 50)
    private String name;

    @Past(message = "Date of birth must be in the past")
    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    private String gender;

    @Email(message = "Invalid email format")
    @Size(max = 100)
    private String email;

    @Override
    public String toString() {
        return "Pateint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // Getters and setters omitted for brevity
}