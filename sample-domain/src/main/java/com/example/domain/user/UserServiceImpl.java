package com.example.domain.user;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserReader userReader;
    private final UserStore userStore;

    @Override
    public UserInfo.Main createUser(UserCommand.Create create) {
        User user = new User(create);
        return UserInfo.Main.of(userStore.create(user));
    }

    @Override
    public List<UserInfo.Main> getUsers(Pageable pageable) {
        return UserInfo.Main.ofs(userReader.getUsers(pageable));
    }
}
