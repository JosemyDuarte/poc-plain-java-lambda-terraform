package io.josemyduarte.helloworld.service;


import io.josemyduarte.helloworld.view.DynamoGameScore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class GameScoreRepositoryTest {
    public static final String USER_ID = UUID.randomUUID().toString();
    public static final String GAME_TITLE = "CS:GO";
    public static final Integer TOP_SCORE = 5;
    private GameScoreRepository gameScoreRepository;

    @Before
    public void setUp() {
        gameScoreRepository = new GameScoreRepository();
        gameScoreRepository.save(DynamoGameScore.builder()
                .userId(USER_ID)
                .gameTitle(GAME_TITLE)
                .topScore(TOP_SCORE)
                .build());
    }

    @After
    public void tearDown() {
        gameScoreRepository.delete(DynamoGameScore.builder()
                .userId(USER_ID)
                .build());
    }

    @Test
    public void find() {
        Optional<DynamoGameScore> optionalGameScore = gameScoreRepository.find(USER_ID);
        assertTrue(optionalGameScore.isPresent());
        assertEquals(GAME_TITLE, optionalGameScore.get().getGameTitle());
        assertEquals(TOP_SCORE, optionalGameScore.get().getTopScore());
    }
}