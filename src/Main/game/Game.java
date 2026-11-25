package Main.game;

public class Game {
    //Game starts from Main-class

    //Select Fighter

    //1st turn

    //The fastest player/character start
    //Other one goes last

    //2nd turn... (looping)

    //If one of the player has lost HP, the other one wins.
    //The loop/game ends.

    HumanPlayer me = new HumanPlayer("Fausto");
    ComputerPlayer it = new ComputerPlayer("Machine");

    public void selectScreen(){
        System.out.println("~~~~Välj en fighter~~~~");
        me.pickFighter();
        it.pickFighter();
        System.out.println();
    }

    public void battle() {

        System.out.println("FIGHT BÖRJAS!");

        while(me.getFightersHP() > 0 && it.getFightersHP() > 0) {
            System.out.println();

            me.selectMove(it.getFighter());

            if (it.getFightersHP() > 0) {
                it.selectMove(me.getFighter());
            }

            System.out.println();

            me.printFightersHP();
            it.printFightersHP();
        }
        if(me.getFightersHP() == 0 ) {
            System.out.println(it.getMyName() + " vinner!");
        } else {
            System.out.println(me.getMyName() + " vinner!");
        }
    }
}
