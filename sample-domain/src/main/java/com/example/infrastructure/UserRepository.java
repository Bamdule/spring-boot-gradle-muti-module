package com.example.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
