package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


class BoardTest {

    private Board board;
    private Game game;

    private Cell[][] testTable = new Cell[3][3];

    @BeforeEach
    void setup() {

        this.game = new Game();
        this.game.initGame();
        this.board = this.game.getBoard();

        for (int x = 0; x <= 2; x++ ) {
            for (int  y = 0; y <= 2; y++){
                testTable[x][y] = new Cell(x, y);
                testTable[x][y].clear();
            }
        }
    }

    @Test
    void testGetterReturnsTable() {
        assertEquals(testTable.length, this.board.getTable().length);
    }

    @Test
    void testHasWonWinningCombinationReturnsTrue() {

        this.game.updateGameState(Seed.CROSS, 0, 0);
        this.game.updateGameState(Seed.CROSS, 1, 1);
        this.game.updateGameState(Seed.CROSS, 2, 2);
        this.board.hasWon();
        assertEquals(true,  this.board.hasWon());
    }

    @Test
    void testHasWonNotWinningCombinationReturnsFalse() {

        this.game.updateGameState(Seed.CROSS, 0, 0);
        this.game.updateGameState(Seed.CROSS, 1, 1);
        this.game.updateGameState(Seed.CROSS, 2, 1);
        assertEquals(false, this.board.hasWon());
    }

}