package com.example.presentations;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.user.UserCommand;
import com.example.domain.user.UserInfo;
import com.example.domain.user.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/api/user")
@RestController
public class UserApiController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserInfo.Main>> getUsers(Pageable pageable) {

        return ResponseEntity.ok(userService.getUsers(pageable));
    }

    @PostMapping
    public ResponseEntity<UserInfo.Main> createUser(String name, String email) {
        return ResponseEntity.ok(userService.createUser(UserCommand.Create.of(name, email)));
    }
}
