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

    public boolean isDraw() {

        return true;
    }

    public boolean checkWin() {

        if (table[0][0].getContent() == table[0][1].getContent() && table[0][1].getContent() == table[0][2].getContent() && table[0][2].getContent() != Seed.EMPTY) {
            return true;
        }
        if (table[1][0].getContent() == table[1][1].getContent() && table[1][1].getContent() == table[1][2].getContent() && table[1][2].getContent() != Seed.EMPTY) {
            return true;
        }
        if (table[2][0].getContent() == table[2][1].getContent() && table[2][1].getContent() == table[2][2].getContent() && table[2][2].getContent() != Seed.EMPTY) {
            return true;
        }
        if (table[0][0].getContent() == table[1][0].getContent() && table[1][0].getContent() == table[2][0].getContent() && table[2][0].getContent() != Seed.EMPTY) {
            return true;
        }
        if (table[0][1].getContent() == table[1][1].getContent() && table[1][1].getContent() == table[2][1].getContent() && table[2][1].getContent() != Seed.EMPTY) {
            return true;
        }
        if (table[0][2].getContent() == table[1][2].getContent() && table[1][2].getContent() == table[2][2].getContent() && table[2][2].getContent() != Seed.EMPTY) {
            return true;
        }
        if (table[0][0].getContent() == table[1][1].getContent() && table[1][1].getContent() == table[2][2].getContent() && table[2][2].getContent() != Seed.EMPTY) {
            return true;
        }
        if (table[0][2].getContent() == table[1][1].getContent() && table[1][1].getContent() == table[2][0].getContent() && table[2][0].getContent() != Seed.EMPTY) {
            return true;
        }

        return false;
    }

    public boolean hasWon(Seed seed, Integer row, Integer col) throws IllegalArgumentException {

        if (!table[row][col].getContent().equals(Seed.EMPTY)) throw new IllegalArgumentException("This field is not empty");

        Cell cell = new Cell(row, col);
        cell.setContent(seed);
        table[row][col] = cell;

        boolean hasWon = checkWin();

        return hasWon;
    }
}
