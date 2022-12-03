package com.example.apisync;

import com.example.apisync.dto.request.UserRequest;
import com.example.apisync.model.Role;
import com.example.apisync.model.User;
import com.example.apisync.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class ApisyncApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
//        userService.saveRole(Role.builder()
//                .name("ROLE_USER")
//                .build());
//        userService.saveRole(Role.builder()
//                .name("ROLE_ADMIN")
//                .build());

        User user1 = User.builder()
                .username("admin")
                .password("1234")
                .build();
        User user2 = User.builder()
                .username("user1")
                .password("1234")
                .build();
        UserRequest userRequest = new UserRequest("admin",   "1234");
        userService.saveUser(userRequest);
//        userService.saveUser(UserRequest.toDto(user2));
    }


}
