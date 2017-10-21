package com.serhii.court.configs;

import com.serhii.court.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = "prototype")
    public User user() {
        User user = new User();
        return user;
    }

}
