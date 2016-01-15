package de.ktel.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * Created on 15.01.16.
 *
 * @author David Steiman, K-TEL Communications GmbH
 */
@SpringBootApplication
@EnableSidecar
public class SidecarApplication {
    public static void main(String[] args) {
        SpringApplication.run(SidecarApplication.class, args);
    }
}
