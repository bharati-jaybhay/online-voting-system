package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UserDto {

    private int userId;

    private String username;

    private String password;

    private String email;

    private String phone;

    private int age;
}
