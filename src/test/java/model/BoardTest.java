package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BoardTest {

    public Board board;

    private Cell[][] testTable = new Cell[3][3];

    @BeforeEach
    void setup() {

        this.board = new Board();
        this.board.initBoard();

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
    void testisDrawDrawCombinationReturnsTrue() {

        this.board.hasWon(Seed.CROSS, 0, 0);
        this.board.hasWon(Seed.NOUGHT, 0, 1);
        this.board.hasWon(Seed.NOUGHT, 0, 2);

        this.board.hasWon(Seed.NOUGHT, 1, 0);
        this.board.hasWon(Seed.CROSS, 1, 1);
        this.board.hasWon(Seed.CROSS, 1, 2);

        this.board.hasWon(Seed.NOUGHT, 2, 0);
        this.board.hasWon(Seed.CROSS, 2, 1);
        this.board.hasWon(Seed.NOUGHT, 2, 2);

        assertEquals(true, this.board.isDraw());
    }

    @Test
    void testHasWonWinningCombinationReturnsTrue() {

        this.board.hasWon(Seed.CROSS, 0, 0);
        this.board.hasWon(Seed.CROSS, 1, 1);
        assertEquals(true,  this.board.hasWon(Seed.CROSS, 2, 2));

        this.board.initBoard();

        this.board.hasWon(Seed.CROSS, 0, 0);
        this.board.hasWon(Seed.CROSS, 0, 1);
        assertEquals(true,  this.board.hasWon(Seed.CROSS, 0, 2));

        this.board.initBoard();

        this.board.hasWon(Seed.CROSS, 0, 1);
        this.board.hasWon(Seed.CROSS, 1, 1);
        assertEquals(true,  this.board.hasWon(Seed.CROSS, 2, 1));
    }

    @Test
    void testHasWonNotWinningCombinationReturnsFalse() {

        this.board.initBoard();
        assertEquals(false, this.board.hasWon(Seed.CROSS, 2, 2));
    }

    }