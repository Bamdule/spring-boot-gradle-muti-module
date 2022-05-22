package com.example.batch;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.domain.user.UserCommand;
import com.example.domain.user.UserInfo;
import com.example.domain.user.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserScheduler {

    public UserScheduler(UserService userService) {
        this.userService = userService;
        log.info("UserScheduler Created!");

    }

    private final UserService userService;

    @Scheduled(cron = "0/10 * * * * *")
    public void userCreateBatch() {
        log.info("userCreateBatch Start!");

        UserInfo.Main user = userService.createUser(UserCommand.Create.of(
            String.format("%s_name", LocalDateTime.now()),
            String.format("%s_email", LocalDateTime.now())
        ));

        log.info("created {}", user);
    }

}
