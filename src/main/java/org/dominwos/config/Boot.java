package org.dominwos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.io.File;


@SpringBootApplication(scanBasePackages = "org.dominwos")
@Configuration
public class Boot{
    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }
}
