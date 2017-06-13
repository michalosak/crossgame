package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    public Game game;

    @BeforeEach
    void setup() {

        this.game.initGame();
    }

    @Test
    void testGetCurrentStateWinningCombinationReturnsEnumPlaying() {

        GameState expected = GameState.PLAYING;
        this.game.updateGameState(Seed.CROSS, 1, 1);
        assertEquals(expected, this.game.getCurrentState());
    }


}