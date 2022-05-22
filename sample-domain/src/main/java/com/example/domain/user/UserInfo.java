package com.example.domain.user;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class UserInfo {

    @ToString
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class Main {
        private Long id;

        private String name;
        private String email;

        public static UserInfo.Main of(User user) {
            return UserInfo.Main.builder()
                .email(user.getEmail())
                .id(user.getId())
                .name(user.getName())
                .build();
        }

        public static List<Main> ofs(List<User> users) {
            return users.stream().map(UserInfo.Main::of)
                .collect(Collectors.toList());
        }
    }
}
