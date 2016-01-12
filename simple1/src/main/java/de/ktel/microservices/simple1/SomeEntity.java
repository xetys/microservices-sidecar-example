package de.ktel.microservices.simple1;

import java.util.Random;

/**
 * Created on 11.01.16.
 *
 * @author David Steiman, K-TEL Communications GmbH
 */
public class SomeEntity {
    public String someField;

    public String ownRandom;

    public SomeEntity() {
        ownRandom = (String.valueOf(new Random().nextInt()));
    }

    public String getSomeField() {
        return someField;
    }

    public void setSomeField(String someField) {
        this.someField = someField;
    }
}
