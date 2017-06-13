package controller;

import model.Game;
import model.GameState;
import model.Seed;
import model.Ui;

public class GameController {

    public static void startGame() {

        Game game = new Game();
        game.initGame();
        game.randomInitialPlayer();

        Integer x;
        Integer y;

        do {
            Ui.clear();
            Ui.printHeader("Crosses and Noughts Game");
            Ui.printBoard(game.getBoard().getTable());

            try {
                x = Ui.selectFromList(3, "Select x position: ");
                y = Ui.selectFromList(3, "Select y position: ");
                game.getBoard().hasWon(game.getCurrentPlayer(), x, y);
                game.changePlayer();
            } catch (IllegalArgumentException e) {
                Ui.printWarning(e.getMessage());
            }

        } while (game.getCurrentState() != GameState.PLAYING);
    }
}
