package org.example.react_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//날짜 자동변환
@EnableJpaAuditing
public class ReactSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactSpringbootApplication.class, args);
    }

}
