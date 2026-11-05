package Main;

import Main.game.Game;

public class Main {
    public static void main(String[] args) {
        //Starts to the menu/character selection screen
        //Game-logic starts in Game-class
        Game game = new Game();
        game.selectScreen();
        game.battle();
        //Testing
    }
}
