package com.lht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FileUpload2Application {
    public static void main(String[] args) {
        SpringApplication.run(FileUpload2Application.class, args);
    }
}
