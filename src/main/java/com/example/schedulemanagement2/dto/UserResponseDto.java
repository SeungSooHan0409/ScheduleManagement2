package com.example.schedulemanagement2.dto;

import com.example.schedulemanagement2.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final String username;
    private final String email;
    private final String password;

    public UserResponseDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
