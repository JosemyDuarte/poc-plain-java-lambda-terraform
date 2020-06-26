package io.josemyduarte.helloworld;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.josemyduarte.helloworld.service.ProcessingService;
import io.josemyduarte.helloworld.view.InputObject;
import io.josemyduarte.helloworld.view.OutputObject;

public class HelloLambdaHandler implements RequestHandler<InputObject, OutputObject> {

    private final ProcessingService service;

    public HelloLambdaHandler() {
        this.service = new ProcessingService();
    }

    public OutputObject handleRequest(InputObject input, Context context) {
        System.out.println(input);
        return service.process(input).setRequestId(context.getAwsRequestId());
    }
}