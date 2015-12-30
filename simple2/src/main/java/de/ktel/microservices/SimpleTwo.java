package de.ktel.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created on 22.12.15.
 *
 * @author David Steiman, K-TEL Communications GmbH
 */

@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@ComponentScan
public class SimpleTwo {

    @RequestMapping("/")
    public SomeEntity root() {
        SomeEntity someEntity = new SomeEntity();
        someEntity.setSomeField(String.valueOf(new Random().nextInt()));

        return someEntity;
    }
    public static void main(String[] args) {
        SpringApplication.run(SimpleTwo.class, args);
    }
}
