package Main;

import Main.game.Game;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Ange ditt namn: ");
        String playerName = scan.nextLine().trim();

        while (playerName.isEmpty()) {
            System.out.print("Namnet får inte vara tomt. Försök igen: ");
            playerName = scan.nextLine().trim();
        }

        Game game = new Game(playerName);
        game.selectScreen();
        game.battle();
    }
}