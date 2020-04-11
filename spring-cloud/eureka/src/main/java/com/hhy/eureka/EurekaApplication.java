package com.hhy.eureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaServer
@RestController
public class EurekaApplication {


    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

    @RequestMapping("/api/ping")
    public String ping() {
        System.out.println(11);
        return "11";
    }

}
