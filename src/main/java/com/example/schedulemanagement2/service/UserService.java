package com.example.schedulemanagement2.service;

import com.example.schedulemanagement2.dto.UserResponseDto;
import com.example.schedulemanagement2.entity.User;
import com.example.schedulemanagement2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // post 메서드
    public UserResponseDto post (String username, String email, String password) {

        User user = new User(username, email, password);

        userRepository.save(user);

        return new UserResponseDto(username, email, password);
    }


    // get 메서드 - 전체조회
    public List<UserResponseDto> getList() {

        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::toDto)
                .toList();

    }


    // get 메서드 - 단건조회
    public UserResponseDto getUser(Long id) {

        User user = userRepository.bringOptionValue(id);

        return new UserResponseDto(user.getUsername(), user.getEmail(), user.getPassword());

    }


    // put 메서드
    public UserResponseDto put(Long id, String username, String email) {

        User user = userRepository.bringOptionValue(id);

            user.setUsername(username);
            user.setEmail(email);

            userRepository.save(user);

            return new UserResponseDto(user.getUsername(), user.getEmail(), user.getPassword());

    }


    // patch 메서드
    public UserResponseDto patch(Long id, String email) {

        User user = userRepository.bringOptionValue(id);

        user.setEmail(email);

        userRepository.save(user);

        return new UserResponseDto(user.getUsername(), user.getEmail(),user.getPassword());

    }


    // delete 메서드
    public UserResponseDto delete(Long id, String password) {

        User user = userRepository.bringOptionValue(id);

        if(!password.equals(user.getPassword())) {
            return new UserResponseDto(
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword()
            );
        } else {

            userRepository.deleteById(id);

            return new UserResponseDto(
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword()
            );
        }
    }

}
