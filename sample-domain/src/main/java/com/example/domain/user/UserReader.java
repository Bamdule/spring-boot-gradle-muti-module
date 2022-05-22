package com.example.domain.user;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface UserReader {
    List<User> getUsers(Pageable pageable);
}
