package com.example.schedulemanagement2.controller;

import com.example.schedulemanagement2.dto.UserRequestDto;
import com.example.schedulemanagement2.dto.UserResponseDto;
import com.example.schedulemanagement2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // 유저 생성
    @PostMapping
    public ResponseEntity<UserResponseDto> postUser (@RequestBody UserRequestDto dto) {

        return new ResponseEntity<>( userService.post(
                dto.getUsername(),
                dto.getEmail()),
                HttpStatus.CREATED
        );

    }


    // 유저 목록 조회
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUserList() {

        return new ResponseEntity<>(userService.getList(),HttpStatus.OK);

    }


    // 유저 1명 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {

       return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);

    }


    // 유저정보 전체수정
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> changeUserInfo (
            @PathVariable Long id,
            @RequestBody UserRequestDto dto)
    {

        return new ResponseEntity<>(
                userService.put(id, dto.getUsername(), dto.getEmail()),
                HttpStatus.OK
        );

    }


    // 유저정보 이메일만 수정
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> changeEmail(
            @PathVariable Long id,
            @RequestBody UserRequestDto dto
    ) {

        return new ResponseEntity<>(
                userService.patch(id, dto.getEmail()),
                HttpStatus.OK);

    }

    // 유저정보 단건삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteUserInfo(@PathVariable Long id) {

        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
