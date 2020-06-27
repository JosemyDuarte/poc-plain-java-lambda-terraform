package io.josemyduarte.helloworld;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.josemyduarte.helloworld.service.GameScoreRepository;
import io.josemyduarte.helloworld.view.DynamoGameScore;
import io.josemyduarte.helloworld.view.GameScoreRequest;

import java.util.NoSuchElementException;

public class HelloLambdaHandler implements RequestHandler<GameScoreRequest, DynamoGameScore> {

    public DynamoGameScore handleRequest(GameScoreRequest input, Context context) {
        System.out.println(input);
        final GameScoreRepository repository = new GameScoreRepository();
        return repository.find(input.getUserId()).orElseThrow(NoSuchElementException::new);
    }
}