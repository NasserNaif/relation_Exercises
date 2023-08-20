package com.example.day1relations.DTO;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileDTO {


    @NotNull(message = "customer id must be valid")
    private Integer customer_id;

    @NotEmpty(message = "full name must not be null")
//    @Min(value = 2, message = "your name ust be more than 2 letters")
    private String fullName;

    @Pattern(regexp = "(male|female)", message = "gender must be male or female")
    private String gender;

    @Positive(message = "age must be positive number")
    @Min(value = 15, message = "customer age must be 15 or bigger")
    private Integer age;

    @Email(message = "must be valid email")
    private String email;
}
