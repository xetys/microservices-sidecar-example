package de.ktel.microservices.simple1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 22.12.15.
 *
 * @author David Steiman, K-TEL Communications GmbH
 */

@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class SimpleOne {
    @RequestMapping("/")
    public String greet() {
        return "Hello World3";
    }
    public static void main(String[] args) {
        SpringApplication.run(SimpleOne.class, args);
    }
}
