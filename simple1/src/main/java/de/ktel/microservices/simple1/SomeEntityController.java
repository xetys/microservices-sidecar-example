package de.ktel.microservices.simple1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 12.01.16.
 *
 * @author David Steiman, K-TEL Communications GmbH
 */
@RestController
@RequestMapping("/")
public class SomeEntityController {
    SomeEntityClient client;

    @Autowired
    public SomeEntityController(SomeEntityClient client) {
        this.client = client;
    }

    @RequestMapping(method = RequestMethod.GET)
    public SomeEntity get() {
        return client.getOne();
    }
}
