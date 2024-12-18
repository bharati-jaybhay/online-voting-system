package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    @Column(length = 15)
    private String phone;

    private int age;

    public int getUserId() {
        return userId;
    }


//    private Collection<RoleModel> roles;
}
