package de.ktel.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Created on 22.12.15.
 *
 * @author David Steiman, K-TEL Communications GmbH
 */

@EnableAutoConfiguration
public class SimpleTwo {
    public static void main(String[] args) {
        SpringApplication.run(SimpleTwo.class, args);
    }
}
