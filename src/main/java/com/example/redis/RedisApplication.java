package com.example.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        LOG.info("Saving users. Current user count is {}.", userRepository.count());
        User roman = new User("Roman", 2000);
        User dipesh = new User("Dipesh", 30000);
        User subij = new User("Subij", 1000);
        userRepository.save(roman);
        userRepository.save(dipesh);
        userRepository.save(subij);
        LOG.info("Done saving users. Data: {}.", userRepository.findAll());
    }
}