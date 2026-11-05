package Main.game;

public class Game {

    private HumanPlayer me;
    private ComputerPlayer it;

    public Game(String playerName) {
        me = new HumanPlayer(playerName);
        it = new ComputerPlayer("Machine");
    }

    public void selectScreen() {
        System.out.println("~~~~Välj en fighter~~~~");

        me.pickFighter();
        it.pickFighter();

        System.out.println();
    }

    public void battle() {

        System.out.println("FIGHT BÖRJAS!");

        Boolean startText = true;

        while (me.getFightersHP(startText) > 0 &&
                it.getFightersHP(startText) > 0) {

            System.out.println();

            me.selectMove(it.getFighter());

            if (it.getFightersHP(false) <= 0) {
                break;
            }

            it.selectMove(me.getFighter());

            System.out.println();
            me.getFightersHP(true);
            it.getFightersHP(true);

            startText = false;
        }

        if (me.getFightersHP(false) <= 0) {
            System.out.println(it.getMyName() + " vinner!");
        } else {
            System.out.println(me.getMyName() + " vinner!");
        }
    }
}