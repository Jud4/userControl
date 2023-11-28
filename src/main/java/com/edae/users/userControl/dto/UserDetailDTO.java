package com.edae.users.userControl.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDetailDTO {
    private Long id;
    @NotBlank(message = "Firstname is mandatory")
    private String firstName;
    @NotBlank(message = "Lastname is mandatory")
    private String lastName;
    private Integer age;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDay;

    public UserDetailDTO() {
    }

    public UserDetailDTO(Long id,String firstName, String lastName, Integer age, LocalDate birthDay) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDay = birthDay;
    }
}
