package com.gssprototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GssPrototypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GssPrototypeApplication.class, args);
    }

}
