package de.ktel.microservices;

import org.springframework.stereotype.Component;

/**
 * Created on 29.12.15.
 *
 * @author David Steiman, K-TEL Communications GmbH
 */
public class SomeEntity {
    private String someField;

    public String getSomeField() {
        return someField;
    }

    public void setSomeField(String someField) {
        this.someField = someField;
    }
}
