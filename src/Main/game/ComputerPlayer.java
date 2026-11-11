package Main.game;
import Main.characters.Fighter;
import java.util.Random;

public class ComputerPlayer extends Player {
    private Random rand = new Random();

    public ComputerPlayer(String myName) {super(myName);}

    @Override
    public void selectMove(Fighter target) {
        useMove(String.valueOf(rand.nextInt(1,3)), target);
    }

    @Override
    public void pickFighter() {
        fighterList(String.valueOf(rand.nextInt(1,4)));
    }
}
