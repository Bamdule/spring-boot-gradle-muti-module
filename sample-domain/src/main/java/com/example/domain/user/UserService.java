package com.example.domain.user;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface UserService {

    UserInfo.Main createUser(UserCommand.Create create);

    List<UserInfo.Main> getUsers(Pageable pageable);

}
