package io.josemyduarte.helloworld.service;

import io.josemyduarte.helloworld.view.InputObject;
import io.josemyduarte.helloworld.view.OutputObject;

public class ProcessingService {

    public static final String CAN_ONLY_GREET_NICKNAMES = "Can only greet nicknames";

    public OutputObject process(InputObject input) {
        if (input.getName().equals("Stuart")) {
            throw new IllegalArgumentException(CAN_ONLY_GREET_NICKNAMES);
        }
        String result = input.getGreeting() + " " + input.getName();
        OutputObject out = new OutputObject();
        out.setResult(result);
        return out;
    }
}
