package com.example.schedulemanagement2.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {

    private final String email;
    private final String password;


    public LoginResponseDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
