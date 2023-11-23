package com.edae.users.userControl.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDetailDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDay;

    public UserDetailDTO() {
    }

    public UserDetailDTO(String firstName, String lastName, Integer age, LocalDate birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDay = birthDay;
    }
}
