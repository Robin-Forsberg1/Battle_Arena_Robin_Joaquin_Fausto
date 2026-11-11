package Main;

import Main.game.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.namePlayers(null);
        game.selectScreen();
        game.battle();
    }
}
