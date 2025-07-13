package com.example.spring_learn;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.spring_learn.controller.AuthenticationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringLearnApplicationTests {

    @Autowired
    private AuthenticationController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
}
