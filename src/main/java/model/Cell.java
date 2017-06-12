package model;

public class Cell {

    private Seed content;
    private Integer row;
    private Integer col;

    public Cell(Integer row, Integer col) {
        this.row = row;
        this.col = col;

    }

    public void clear() {
        this.content = Seed.EMPTY;
    }
}
