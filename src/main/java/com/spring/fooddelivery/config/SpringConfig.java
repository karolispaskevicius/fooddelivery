package com.spring.fooddelivery.config;

import com.spring.fooddelivery.repository.NumberRepository;
import com.spring.fooddelivery.repository.UserRepository;
import com.spring.fooddelivery.service.NumberService;
import com.spring.fooddelivery.service.impl.NumberServiceImpl;
import com.spring.fooddelivery.service.UserService;
import com.spring.fooddelivery.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    final NumberRepository numberRepository;
    final UserRepository userRepository;

    @Autowired
    public SpringConfig(NumberRepository numberRepository, UserRepository userRepository) {
        this.numberRepository = numberRepository;
        this.userRepository = userRepository;
    }

    @Bean
    @Qualifier("NumberService")
    public NumberService getNumberService() {
        return new NumberServiceImpl(numberRepository);
    }

    @Bean
    @Qualifier("UserService")
    public UserService getUserService() {
        return new UserServiceImpl();
    }
}
