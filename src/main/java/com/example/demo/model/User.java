package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "user_table")
@Data
public class User {

    @Id

    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private long id;

    @NotBlank(message="name is required")

    @Size(min=2,max=40,message="Name should have min 2 and max 40 character")

    private String name;

    @NotBlank(message="email should not be empty")

    @Email

    @Column(unique=true,nullable=false)

    private String email;

    @NotBlank(message = "passward should not empty")

    @Size(min=8,message =" passward must be at least 8 characters")

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$",

            message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, and one special character")

    private String password;

    @NotNull

    private long mobile;

}