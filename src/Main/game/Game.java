package Main.game;

import java.util.*;

public class Game {

    public List<Player> players = new ArrayList<>();

    //Using TDD
    public void nameYourself(String name) {
        while (name == null || name.isBlank() || name.equals(TextList.CPU_NAME.toString())) {
            Scanner myName = new Scanner(System.in);
            System.out.print(TextList.INPUT_YOUR_NAME);
            name = myName.nextLine().trim();
        }
        players.add(new HumanPlayer(name));
        players.add(new ComputerPlayer(TextList.CPU_NAME.toString()));
    }

    public void selectScreen(){
        System.out.println("~~~~Välj en fighter~~~~");
        for (Player player : players){player.pickFighter();}
        System.out.println();
    }

    public void battle() {

        Random random = new Random();
        if (random.nextBoolean()) {Collections.reverse(players);}

        System.out.println("FIGHT BÖRJAS!");
        System.out.println(players.get(0).getMyName() +" börjar sin tur!");
        while (true) {
            System.out.println();
            players.get(0).selectMove(players.get(1).getFighter());
            if(players.get(1).getFightersHP(true) == 0) break;
            Collections.reverse(players);
        }

        for (Player winner : players) {
            if (winner.getFightersHP(false) != 0) {
                System.out.println(winner.getMyName() + " vinner!");
            }
        }
    }
}
