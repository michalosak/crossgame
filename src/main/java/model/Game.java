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
    }

    public void updateGameState(Seed seed, Integer row, Integer col) {

    }

    public Board getBoard() {
        return board;
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
    }

    public Seed getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Seed currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void changePlayer() {
        if (this.currentPlayer.equals(Seed.CROSS)) this.currentPlayer = Seed.NOUGHT;
        else this.currentPlayer = Seed.CROSS;
    }
}

