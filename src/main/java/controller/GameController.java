package controller;

import model.Game;
import model.GameState;
import model.Seed;
import model.Ui;

public class GameController {

    private Game game;
    private Ui ui;

    GameController() {
    }

    public void init() {

        this.game = new Game();
        this.game.initGame();
        this.ui = new Ui();
    }

    public Game getGame() {
        return this.game;
    }

    private void play() {

        int moveCounter = 0;
        boolean isDraw = false;
        Integer x;
        Integer y;

        displayTable();

        while (!game.getBoard().hasWon() && !isDraw) {

            try {
                x = ui.selectFromList(3, "Select y position for " + game.getCurrentPlayer() + ": ");
                y = ui.selectFromList(3, "Select x position: " + game.getCurrentPlayer() + ": ");
                game.updateGameState(game.getCurrentPlayer(), x, y);
                game.getBoard().hasWon();
                game.changePlayer();
                moveCounter += 1;
                if (moveCounter == 9 && !game.getBoard().hasWon()) {
                    isDraw = true;
                    game.setCurrentState(GameState.DRAW);
                }
            } catch (IllegalArgumentException e) {
                ui.printWarning(e.getMessage());
            }

            displayTable();

            if (game.getBoard().hasWon()) {
                game.changePlayer();
                ui.printInformation("WIN! " + game.getCurrentPlayer());
                if(game.getCurrentPlayer() == Seed.NOUGHT) game.setCurrentState(GameState.NOUGHT_WON);
                else if(game.getCurrentPlayer() == Seed.CROSS) game.setCurrentState(GameState.CROSS_WON);
                this.playAgain();
                moveCounter = 0;

            }
            if (moveCounter == 9 && !game.getBoard().hasWon()) {
                ui.printInformation("Draw");
                this.playAgain();
                isDraw = false;
                moveCounter = 0;
            }
        }

    }

    private void playAgain() {

        String playOrnot = ui.userInputString("Do you want to play again? (y/n): ");
        if (playOrnot.equals("y")) {
            ui.clear();
            game.initGame();
            ui.printHeader("Crosses and Noughts Game");
            ui.printBoard(game.getBoard().getTable());
        }
    }

    public void displayTable() {

        ui.clear();
        ui.printHeader("Crosses and Noughts Game");
        ui.printBoard(game.getBoard().getTable());
    }

    public static void startGame() {

        GameController gc  = new GameController();
        gc.init();
        gc.play();
    }
}

