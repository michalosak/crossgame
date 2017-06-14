package controller;

import model.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


class GameControllerTest {

    @Test
    void testGetterGameFromControllerReturnsGame() {
        GameController gc = new GameController();
        gc.init();

        assertNotNull(gc.getGame());

    }
}