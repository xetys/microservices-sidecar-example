package de.ktel.microservices.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created on 22.12.15.
 *
 * @author David Steiman, K-TEL Communications GmbH
 */
@SpringBootApplication
@EnableZuulProxy
public class RoutingService {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RoutingService.class).web(true).run(args);
    }
}
