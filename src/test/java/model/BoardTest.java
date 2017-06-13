package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BoardTest {

    public Board board;

    @BeforeEach
    void setup() {

        this.board = new Board();
        this.board.initBoard();
    }

    @Test
    void initBoard() {
    }

    @Test
    void testisDrawDrawCombinationReturnsTrue() {

        this.board.hasWon(Seed.CROSS, 1, 1);
        this.board.hasWon(Seed.NOUGHT, 1, 2);
        this.board.hasWon(Seed.NOUGHT, 1, 3);

        this.board.hasWon(Seed.NOUGHT, 2, 1);
        this.board.hasWon(Seed.CROSS, 2, 2);
        this.board.hasWon(Seed.CROSS, 2, 3);

        this.board.hasWon(Seed.NOUGHT, 3, 1);
        this.board.hasWon(Seed.CROSS, 3, 2);
        this.board.hasWon(Seed.NOUGHT, 3, 3);

        assertEquals(true, this.board.isDraw());
    }

    @Test
    void testHasWonWinningCombinationReturnsTrue() {

        this.board.hasWon(Seed.CROSS, 1, 1);
        this.board.hasWon(Seed.CROSS, 2, 2);
        assertEquals(true,  this.board.hasWon(Seed.CROSS, 3, 3));

        this.board.initBoard();

        this.board.hasWon(Seed.CROSS, 1, 1);
        this.board.hasWon(Seed.CROSS, 1, 2);
        assertEquals(true,  this.board.hasWon(Seed.CROSS, 1, 3));

        this.board.initBoard();

        this.board.hasWon(Seed.CROSS, 1, 2);
        this.board.hasWon(Seed.CROSS, 2, 2);
        assertEquals(true,  this.board.hasWon(Seed.CROSS, 3, 2));
    }

    @Test
    void testHasWonNotWinningCombinationReturnsFalse() {

        this.board.initBoard();
        assertEquals(false, this.board.hasWon(Seed.CROSS, 3, 3));
    }

    }