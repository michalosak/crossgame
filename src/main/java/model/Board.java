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

    public boolean hasWon(Seed seed, Integer row, Integer col) throws IllegalArgumentException {

        if (!table[row][col].getContent().equals(Seed.EMPTY)) throw new IllegalArgumentException("This field is not empty");

        Cell cell = new Cell(row, col);
        cell.setContent(seed);
        table[row][col] = cell;

        return false;
    }
}
