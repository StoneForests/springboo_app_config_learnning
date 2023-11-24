package com.example.learning.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@Slf4j
@RefreshScope
public class IndexController {
    @Value("${key}")
    private String key;

    @Value("${priority}")
    private Integer priority;

    @Bean
    public void getKey() {
        log.info("key is {}", key);
        log.info("priority is {}", priority);
    }

    @RequestMapping("/")
    public String hello() {
        return String.format("key is %s, priority is %d", key, priority);
    }
}
