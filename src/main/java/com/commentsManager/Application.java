package com.commentsManager;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication()
//@EntityScan
//@EnableJpaRepositories("com.example.commentsManager.repos")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
