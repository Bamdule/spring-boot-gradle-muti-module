package com.example.infrastructure;

import org.springframework.stereotype.Repository;

import com.example.domain.user.User;
import com.example.domain.user.UserStore;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UserStoreImpl implements UserStore {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
}
