package org.dominwos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;


@SpringBootApplication(scanBasePackages = "org.dominwos")
@EnableAutoConfiguration
public class Boot{
    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }
}
