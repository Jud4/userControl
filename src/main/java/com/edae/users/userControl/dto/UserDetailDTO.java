package com.edae.users.userControl.dto;

import java.time.LocalDate;

public class UserDetailDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDay;

    public UserDetailDTO() {
    }

    public UserDetailDTO(String firstName, String lastName, Integer age, LocalDate birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDay = birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
