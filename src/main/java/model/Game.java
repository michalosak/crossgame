package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private Board board;

    private GameState currentState;

    private Seed currentPlayer;
    public Game() {

    }

    public void initGame() {

        this.board = new Board();
        this.board.initBoard();
        this.randomInitialPlayer();
    }

    public void updateGameState(Seed seed, Integer row, Integer col) {
        this.currentPlayer = seed;
        if (!board.getTable()[row][col].getContent().equals(Seed.EMPTY)) throw new IllegalArgumentException("This field is not empty");

        Cell cell = new Cell(row, col);
        cell.setContent(seed);
        board.getTable()[row][col] = cell;
    }

    public Board getBoard() {
        return board;
    }

    public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void randomInitialPlayer() {

        List<Seed> player = new ArrayList<>();
        player.add(Seed.CROSS);
        player.add(Seed.NOUGHT);
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(player.size());
        this.currentPlayer = player.get(index);
        this.currentState = GameState.PLAYING;
    }

    public Seed getCurrentPlayer() {
        return currentPlayer;
    }

    public void changePlayer() {
        if (this.currentPlayer.equals(Seed.CROSS)) this.currentPlayer = Seed.NOUGHT;
        else this.currentPlayer = Seed.CROSS;
    }
}

