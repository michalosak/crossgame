package controller;

import model.Game;
import model.GameState;
import model.Ui;

public class GameController {

    public static void startGame() {

        Game game = new Game();
        game.initGame();

        int moveCounter = 0;
        boolean isDraw = false;
        Integer x;
        Integer y;

        Ui.clear();
        Ui.printHeader("Crosses and Noughts Game");
        Ui.printBoard(game.getBoard().getTable());

        while (!game.getBoard().hasWon() && !isDraw) {


            try {
                game.changePlayer();
                x = Ui.selectFromList(3, "Select y position for " + game.getCurrentPlayer() + ": ");
                y = Ui.selectFromList(3, "Select x position: " + game.getCurrentPlayer() + ": ");
                game.updateGameState(game.getCurrentPlayer(), x, y);
                game.getBoard().hasWon();
                moveCounter += 1;
                if(moveCounter == 9 && !game.getBoard().hasWon()) {
                    isDraw = true;
                    game.setCurrentState(GameState.DRAW);
                }
            } catch (IllegalArgumentException e) {
                Ui.printWarning(e.getMessage());
            }

            Ui.clear();
            Ui.printHeader("Crosses and Noughts Game");
            Ui.printBoard(game.getBoard().getTable());


        }
        if(game.getBoard().hasWon()) System.out.println("WIN! " + game.getCurrentPlayer());
        else System.out.println("Draw");
    }
}
