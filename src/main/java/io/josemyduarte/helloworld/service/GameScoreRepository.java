package io.josemyduarte.helloworld.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import io.josemyduarte.helloworld.view.GameScore;

import java.util.Optional;

public class GameScoreRepository {

    private final DynamoDBMapper mapper;

    public GameScoreRepository() {
        final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.EU_WEST_1)
                .build();
        mapper = new DynamoDBMapper(client);

    }

    public Optional<GameScore> find(final String userId) {
        return Optional.ofNullable(mapper.load(GameScore
                .builder()
                .userId(userId)
                .build()));
    }

    public void save(final GameScore gameScore) {
        mapper.save(gameScore);
    }

    public void delete(final GameScore gameScore) {
        mapper.delete(gameScore);
    }
}
