package com.sprk.sprk_hotels.service;

import com.sprk.sprk_hotels.model.UserModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public interface UserService {
    UserModel getUserByEmail(@NotBlank(message = "please provide email") @Email(message = "incorrect email") String email);

    UserModel saveUserModel(@Valid UserModel userModel);
}
