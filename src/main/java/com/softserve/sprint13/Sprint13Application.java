package com.softserve.sprint13;

import com.softserve.sprint13.service.ProgressService;
import com.softserve.sprint13.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Sprint13Application {
    @Autowired
    TaskService service;
    @Autowired
    ProgressService progressService;

    public static void main(String[] args) {
        SpringApplication.run(Sprint13Application.class, args);

    }

//    @Bean
//    CommandLineRunner init() {
//        return args -> {
//            System.out.println(progressService.allProgressByUserIdAndMarathonId(1L, 1L));
//            System.out.println(progressService.allProgressByUserIdAndSprintId(1L, 1L));
//        };
//    }


}
