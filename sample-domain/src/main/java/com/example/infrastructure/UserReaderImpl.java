package com.example.infrastructure;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.domain.user.User;
import com.example.domain.user.UserReader;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UserReaderImpl implements UserReader {
    private final UserRepository userRepository;

    @Override
    public List<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }
}
