package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private Cell[][] table = new Cell[3][3];

    public Board() {
        initBoard();
    }

    public void initBoard() {

        for (int x = 1; x <= 3; x++ ) {
            for (int  y = 1; y <= 3; y++){
                table[x][y] = new Cell(x, y);
                table[x][y].clear();
            }
        }

    }

    public boolean isDraw() {

        return true;
    }

    public boolean hasWon(Seed seed, Integer row, Integer col) {

        return true;
    }
}
