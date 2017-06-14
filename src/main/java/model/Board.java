package model;

public class Board {

    private Cell[][] table = new Cell[3][3];

    public Board() {
        initBoard();
    }

    public void initBoard() {

        for (int x = 0; x <= 2; x++ ) {
            for (int  y = 0; y <= 2; y++){
                table[x][y] = new Cell(x, y);
                table[x][y].clear();
            }
        }
    }

    public Cell[][] getTable() {
        return table;
    }


    public boolean hasWon() {

        if ((table[0][0].getContent() == table[0][1].getContent() && table[0][1].getContent() == table[0][2].getContent() && table[0][2].getContent() != Seed.EMPTY)
        ||(table[1][0].getContent() == table[1][1].getContent() && table[1][1].getContent() == table[1][2].getContent() && table[1][2].getContent() != Seed.EMPTY)
        ||(table[2][0].getContent() == table[2][1].getContent() && table[2][1].getContent() == table[2][2].getContent() && table[2][2].getContent() != Seed.EMPTY)
        ||(table[0][0].getContent() == table[1][0].getContent() && table[1][0].getContent() == table[2][0].getContent() && table[2][0].getContent() != Seed.EMPTY)
        ||(table[0][1].getContent() == table[1][1].getContent() && table[1][1].getContent() == table[2][1].getContent() && table[2][1].getContent() != Seed.EMPTY)
        ||(table[0][2].getContent() == table[1][2].getContent() && table[1][2].getContent() == table[2][2].getContent() && table[2][2].getContent() != Seed.EMPTY)
        ||(table[0][0].getContent() == table[1][1].getContent() && table[1][1].getContent() == table[2][2].getContent() && table[2][2].getContent() != Seed.EMPTY)
        ||(table[0][2].getContent() == table[1][1].getContent() && table[1][1].getContent() == table[2][0].getContent() && table[2][0].getContent() != Seed.EMPTY)) {
            return true;
        }

        return false;
    }
}
