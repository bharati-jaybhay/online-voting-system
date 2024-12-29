//package com.example.demo.mapper;
//
//import com.example.demo.model.User;
//import com.example.demo.model.UserDto;
//
//public class UserMapper {
//
//    // Converts User to UserDto
//    public static UserDto convertUserToUserDto(User user, UserDto userDto) {
//        userDto.setUserId(user.getUserId());  // Ensure user has getUserId()
//        userDto.setUsername(user.getUsername());
//        userDto.setPassword(user.getPassword());
//        userDto.setEmail(user.getEmail());
//        userDto.setPhone(user.getPhone());
//        userDto.setAge(user.getAge());
//        return userDto;
//    }
//
//    // Converts UserDto to User
//    public static User convertUserDtoToUser(UserDto userDto, User user) {
//        user.setUserId(userDto.getUserId());  // Ensure userDto has getUserId()
//        user.setUsername(userDto.getUsername());
//        user.setPassword(userDto.getPassword());
//        user.setEmail(userDto.getEmail());
//        user.setPhone(userDto.getPhone());
//        user.setAge(userDto.getAge());
//        return user;
//    }
//}
