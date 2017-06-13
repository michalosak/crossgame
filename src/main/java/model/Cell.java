package model;

public class Cell {

    private Seed content;
    private Integer row;
    private Integer col;

    public Cell(Integer row, Integer col) {

        this.row = row;
        this.col = col;
    }

    public Seed getContent() {
        return content;
    }

    public void setContent(Seed content) {
        this.content = content;
    }

    public void clear() {
        this.content = Seed.EMPTY;
    }
}
