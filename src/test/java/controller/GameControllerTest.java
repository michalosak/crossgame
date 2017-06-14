package controller;

import model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


class GameControllerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private GameController gc;

    @BeforeEach
    void setup() {

        System.setOut(new PrintStream(outContent));
        this.gc = new GameController();
        this.gc.init();
    }

    @Test
    void testDisplayTable() {

        String expected =
                "\u001B[H\u001B[2J\u001B[31m------------------------\u001B[0m\n" +
                "\u001B[0;1m\u001B[31mCrosses and Noughts Game\u001B[0m\u001B[0;0m\n" +
                "\u001B[31m------------------------\u001B[0m\n" +
                "  |   |  \n" +
                "---------\n" +
                "  |   |  \n" +
                "---------\n" +
                "  |   |  \n";

        this.gc.displayTable();

        assertEquals(expected, outContent.toString());
    }

    @Test
    void testGetterGameFromControllerReturnsGame() {
        assertNotNull(gc.getGame());
    }
}