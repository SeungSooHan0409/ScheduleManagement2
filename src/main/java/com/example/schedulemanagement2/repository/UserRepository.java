package com.example.schedulemanagement2.repository;

import com.example.schedulemanagement2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    default User bringOptionValue(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"id 값이 없습니다."));
    }

    // 이메일로 유저조회
    Optional<User> findByEmail(String email);


}
