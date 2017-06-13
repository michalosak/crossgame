package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setup() {
        this.game = new Game();
        this.game.initGame();
    }

    @Test
    void testGetCurrentStateReturnsEnumPlaying() {

        GameState expected = GameState.PLAYING;
        this.game.updateGameState(Seed.CROSS, 1, 1);
        assertEquals(expected, this.game.getCurrentState());
    }

    @Test
    void testChangePlayerFromCrossToNought() {
        Seed expected = Seed.NOUGHT;
        this.game.updateGameState(Seed.CROSS, 1,1);
        this.game.changePlayer();
        assertEquals(expected, this.game.getCurrentPlayer());
    }

}