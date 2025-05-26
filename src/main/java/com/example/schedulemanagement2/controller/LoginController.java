package com.example.schedulemanagement2.controller;

import com.example.schedulemanagement2.constant.SessionConst;
import com.example.schedulemanagement2.dto.LoginReqeustDto;
import com.example.schedulemanagement2.entity.User;
import com.example.schedulemanagement2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    // 로그인 기능
    @PostMapping("/session-login")
    public ResponseEntity<String> login(
            @RequestBody LoginReqeustDto dto,
            HttpServletRequest request
    ) {

        User user = userService.bringUser(dto.getEmail());

        if(!dto.getEmail().equals(user.getEmail()) || !dto.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        HttpSession session = request.getSession();

        session.setAttribute(SessionConst.USER, user);

        return new ResponseEntity<>("로그인 성공!",HttpStatus.OK);
    }

    // 로그아웃 기능
    @PostMapping("/session-logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if(session != null) {
            session.invalidate();
        }

        return new ResponseEntity<>("로그아웃 성공!",HttpStatus.OK);
    }

}
