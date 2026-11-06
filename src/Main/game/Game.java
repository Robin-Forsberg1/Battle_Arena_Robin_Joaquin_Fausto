package Main.game;

import java.util.*;

public class Game {

    HumanPlayer me = new HumanPlayer("Fausto");
    ComputerPlayer it = new ComputerPlayer("Machine");
    public List<Player> players = new ArrayList<>();

    //Using TDD
    public void namePlayers(String name) {
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
        me.pickFighter();
        it.pickFighter();
        System.out.println();
    }

    public void battle() {

        System.out.println("FIGHT BÖRJAS!");
        Boolean startText = true;
        while(me.getFightersHP(startText) > 0 && it.getFightersHP(startText) > 0) {
            System.out.println();
            me.selectMove(it.getFighter());
            it.selectMove(me.getFighter());
            System.out.println();
            me.getFightersHP(true);
            it.getFightersHP(true);
            startText = false;
        }
        if(me.getFightersHP(false) < it.getFightersHP(false))
            System.out.println(it.getMyName() + " vinner!");
        else System.out.println(me.getMyName() + " vinner!");
    }
}
