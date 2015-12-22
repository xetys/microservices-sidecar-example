package de.ktel.microservices.simple1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Created on 22.12.15.
 *
 * @author David Steiman, K-TEL Communications GmbH
 */

@EnableAutoConfiguration
public class SimpleOne {
    public static void main(String[] args) {
        SpringApplication.run(SimpleOne.class, args);
    }
}
