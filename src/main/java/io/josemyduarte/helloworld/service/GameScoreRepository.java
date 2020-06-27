package io.josemyduarte.helloworld.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import io.josemyduarte.helloworld.view.DynamoGameScore;

import java.util.Optional;

public class GameScoreRepository {

    private final DynamoDBMapper mapper;

    public GameScoreRepository() {
        final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                //TODO this can be passed through environment variables/terraform
                .withRegion(Regions.EU_WEST_2)
                .build();
        mapper = new DynamoDBMapper(client);

    }

    public Optional<DynamoGameScore> find(final String userId) {
        return Optional.ofNullable(mapper.load(DynamoGameScore
                .builder()
                .userId(userId)
                .build()));
    }

    public void save(final DynamoGameScore gameScore) {
        mapper.save(gameScore);
    }

    public void delete(final DynamoGameScore gameScore) {
        mapper.delete(gameScore);
    }
}
