package controller;

import model.Game;
import model.GameState;
import model.Seed;
import model.Ui;

public class GameController {

    public static void startGame() {

        Game game = new Game();
        game.initGame();

        Integer x;
        Integer y;

        Ui.clear();
        Ui.printHeader("Crosses and Noughts Game");
        Ui.printBoard(game.getBoard().getTable());

        while (game.getBoard().checkWin() != true) {


            try {
                x = Ui.selectFromList(3, "Select y position: ");
                y = Ui.selectFromList(3, "Select x position: ");
                game.getBoard().hasWon(game.getCurrentPlayer(), x, y);
                game.changePlayer();
            } catch (IllegalArgumentException e) {
                Ui.printWarning(e.getMessage());
            }

            Ui.clear();
            Ui.printHeader("Crosses and Noughts Game");
            Ui.printBoard(game.getBoard().getTable());


        }
        System.out.println("WIN!");
    }
}
